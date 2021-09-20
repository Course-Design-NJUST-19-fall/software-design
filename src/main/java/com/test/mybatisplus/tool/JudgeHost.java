package com.test.mybatisplus.tool;

import com.test.mybatisplus.entity.Problem;
import com.test.mybatisplus.enums.ResultEnum;
import com.test.mybatisplus.entity.TestRecord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JudgeHost {
    static final String excutableSuffix = ".exe";
    static final String outputSuffix = ".out";
    static final String sandboxPath = "/home/oj_sandbox/build/judge_core";

    final private String executablePath;
    final private Problem problem;
    final private File sourceCodeFile;
    final private File[] answerFiles;
    final private File[] inputFiles;
    final private File[] outputFiles;

    public JudgeHost(Problem problem, File sourceFile){
        this.problem = problem;
        this.sourceCodeFile = sourceFile;
        this.executablePath = sourceFile.getAbsolutePath()+excutableSuffix;

        this.inputFiles = new File(problem.getInputPath()).listFiles();
        Arrays.sort(inputFiles);
        this.answerFiles = new File(problem.getOutputPath()).listFiles();
        Arrays.sort(answerFiles);
        outputFiles = new File[inputFiles.length];

        try {
            for (int i = 0; i < inputFiles.length; i++) {
                outputFiles[i] = new File(sourceFile.getParent()+ "/" + answerFiles[i].getName());
                outputFiles[i].createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //编译文件,返回报错信息，null为编译成功
    private String compileCode() throws IOException {
        //设置执行命令，以及参数
        List<String> commands = new ArrayList<String>();
        commands.add("g++");
        commands.add("-O2");
        commands.add("-o");
        commands.add(this.sourceCodeFile.getName()+excutableSuffix);
        commands.add(this.sourceCodeFile.getName());
        commands.add("-std=c++11");

        //启动编译器
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(this.sourceCodeFile.getParent()));
        processBuilder.command(commands);
        Process exec = processBuilder.start();
        try {
            exec.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }

        //获取编译器报错信息，注意警告也会输出至stderr，因此先做返回值判断
        if(0 != exec.exitValue()) {
            InputStream inputStream = exec.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                String s;
                while ((s = reader.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append(System.getProperty("line.separator"));
                }
            }
            if (null != reader.readLine())
                stringBuilder.append("more...");
            reader.close();
            return stringBuilder.toString();
        }
        return null;
    }

    //执行器，返回执行结果
    private RunningInformation run(int index){
        List<String> commands = new ArrayList<>();
        commands.add("sudo");
        commands.add(sandboxPath);
        commands.add("-t");
        commands.add(String.valueOf(problem.getCpuTimeLimit()*3));
        commands.add("-c");
        commands.add(String.valueOf(problem.getCpuTimeLimit()));
        commands.add("-m");
        commands.add(String.valueOf(problem.getMemoryLimit()));
        commands.add("-r");
        commands.add(executablePath);
        commands.add("-o");
        commands.add(outputFiles[index].getAbsolutePath());
        commands.add("-e");
        commands.add(outputFiles[index].getAbsolutePath());
        commands.add("-i");
        commands.add(inputFiles[index].getAbsolutePath());

        ProcessBuilder builder = new ProcessBuilder();
//        builder.redirectInput(inputFiles[index]);
//        builder.redirectOutput(outputFiles[index]);
//        builder.directory(program.getParentFile());
        builder.command(commands);
        try {
            Process exec = builder.start();
            exec.waitFor();

            RunningInformation ret = new RunningInformation();
            InputStream inputStream = exec.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            ret.cpuTimeCost = scanner.nextInt();
            ret.memoryCost = scanner.nextInt();
            ret.runningCondition = ResultEnum.values()[scanner.nextInt()];
//            switch (scanner.nextInt()){
//                case 0:ret.runningCondition = ResultEnum.ACCEPT;break;
//                case 1:ret.runningCondition = ResultEnum.RUNTIME_ERROR;break;
//                case 2:ret.runningCondition = ResultEnum.TIME_LIMIT_EXCEEDED;break;
//                case 3:ret.runningCondition = ResultEnum.MEMORY_LIMIT_EXCEEDED;break;
//                case 4:ret.runningCondition = ResultEnum.SEGMENTATION_FAULT;break;
//                case 5:ret.runningCondition = ResultEnum.UNKNOWN_ERROR;break;
//                default:ret.runningCondition = ResultEnum.EXEC_ERROR;
//            }
            return ret;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    //比较文件
    private boolean compareFile(int index){
        File outputFile = this.outputFiles[index];
        File answerFile = this.answerFiles[index];
        try {
            FileInputStream outputFileStream = new FileInputStream(outputFile);
            FileInputStream ansFileStream = new FileInputStream(answerFile);

            if(outputFileStream.available() != ansFileStream.available())
                return false;//长度不等直接返回
            while (true) {
                int oldChar = outputFileStream.read();
                int newChar = ansFileStream.read();
                if (oldChar != -1 && newChar != -1) {
                    if (oldChar != newChar) {
                        return false;
                    }
                } else {
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void cleanFile(){
        for (File outFile :
                outputFiles) {
            outFile.delete();
        }
    }

    //外部接口，判一道题目,返回是否成功
    public boolean startJudge(TestRecord result){
        //测评结果初始化
        result.setResult(ResultEnum.ACCEPT);

        //编译并设置编译器报错信息
        String ceMessage = null;
        try {
            ceMessage = this.compileCode();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        //非null代表编译失败,直接返回
        if(null != ceMessage){
            result.setResult(ResultEnum.COMPILATION_ERROR);
            result.setCompilationErrorMessage(ceMessage);
            return true;//编译错误不代表判题失败
        }

        //对每一个样例运行测试
        for(int i = 0; i< inputFiles.length; ++i) {
            //运行一次
            RunningInformation inf = this.run(i);

            //若有问题直接返回
            if(null == inf)
                return false;
            if (inf.runningCondition != ResultEnum.ACCEPT) {
                result.setResult(inf.runningCondition);
                this.cleanFile();
                return false;
            }
            if (!this.compareFile(i)) {
                result.setResult(ResultEnum.WRONG_ANSWER);
                this.cleanFile();
                return false;
            }

            //更新资源消耗数据，双双取最高值
            result.setCpuTimeCost(Math.max(result.getCpuTimeCost(), inf.cpuTimeCost));
            result.setMemoryCost(Math.max(result.getMemoryCost(), inf.memoryCost));
        }
        return true;
    }
}

class RunningInformation{
    protected int cpuTimeCost;
    protected int memoryCost;
    protected ResultEnum runningCondition;
}