package tool;

import entity.Problem;
import enums.ResultEnum;
import entity.TestRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JudgeHost {
    static final String excutableSuffix = ".exe";
    static final String outputSuffix = ".out";

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
        this.answerFiles = new File(problem.getOutputPath()).listFiles();
        outputFiles = new File[inputFiles.length];

        try {
            for (int i = 0; i < inputFiles.length; i++) {
                outputFiles[i] = new File(sourceFile.getParent()+ "/" + inputFiles[i].getName() + outputSuffix);
                outputFiles[i].createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //编译文件
    private String compileCode() throws IOException {
        //设置执行命令，以及参数
        List<String> commands = new ArrayList<String>();
        commands.add("clang++");
        commands.add("-O2");
        commands.add("-o");
        commands.add(this.sourceCodeFile.getName()+excutableSuffix);
        commands.add(this.sourceCodeFile.getName());
//        commands.add("-ansi");

        //启动编译器
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(this.sourceCodeFile.getParent()));
        processBuilder.command(commands);
        Process exec = processBuilder.start();

        //获取编译器报错信息
        InputStream inputStream = exec.getErrorStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<10;i++){
            String s;
            while ((s = reader.readLine()) != null) {
                stringBuilder.append(s);
                stringBuilder.append(System.getProperty("line.separator"));
            }
        }
        if(null != reader.readLine())
            stringBuilder.append("more...");
        return stringBuilder.toString();
    }

    //执行器，返回执行结果
    private RunningInformation run(int index){
        File program = new File(this.executablePath);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(program.getParentFile());
        builder.command(program.getAbsolutePath());
        try {
            Process exec = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RunningInformation ret = new RunningInformation();
        ret.cpuTimeCost = 100;
        ret.memoryCost = 100;
        ret.runningCondition = ResultEnum.ACCEPT;
        return ret;
    }

    //比较文件
    private boolean compareFile(int index){
        File outputFile = this.outputFiles[index];
        File answerFile = this.answerFiles[index];
        try {
            FileInputStream fileInputStream = new FileInputStream(outputFile);
            FileInputStream fileOutputStream = new FileInputStream(answerFile);
            int oldChar = 0;
            int newChar = 0;

            while (true) {
                oldChar = fileInputStream.read();
                newChar = fileOutputStream.read();
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
        }
        return false;
    }

    //外部接口，判一道题目
    public TestRecord startJudge(){
        //测评结果初始化
        TestRecord result = new TestRecord();

        //编译并设置编译器报错信息
        String ceMessage = null;
        try {
            ceMessage = this.compileCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert ceMessage != null;
        //非空串代表编译失败,直接返回
        if(!ceMessage.isEmpty()){
            result.setResult(ResultEnum.COMPILATION_ERROR);
            result.setCompilationErrorMessage(ceMessage);
            return result;
        }

        //对每一个样例运行测试
        for(int i = 0; i< inputFiles.length; ++i) {
            //运行一次
            RunningInformation inf = this.run(i);

            //更新资源消耗数据，双双取最高值
            result.setCpuTimeCost(Math.max(result.getCpuTimeCost(), inf.cpuTimeCost));
            result.setMemoryCost( Math.max(result.getMemoryCost(),  inf.memoryCost));

            //若有问题直接返回
            if(inf.runningCondition!=ResultEnum.ACCEPT){
                result.setResult(inf.runningCondition);
                return result;
            }
            if(!this.compareFile(i)){
                result.setResult(ResultEnum.WRONG_ANSWER);
                return result;
            }
        }

        return  result;
    }
}

class RunningInformation{
    protected int cpuTimeCost;
    protected int memoryCost;
    protected ResultEnum runningCondition;
}