package tool;

import entity.Problem;
import entity.Result;
import entity.TestRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class judgeHost {
    static final String excutableSuffix = ".out";

    //编译文件
    static private String compileCode(File sourceCodeFile) throws IOException {
        //设置执行命令，以及参数
        List<String> commands = new ArrayList<String>();
        commands.add("g++");
        commands.add("-O2");
        commands.add("-o");
        commands.add(sourceCodeFile.getName()+excutableSuffix);
        commands.add(sourceCodeFile.getName());
        commands.add("-ansi");

        //启动编译器
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(sourceCodeFile.getParent()));
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
    static private RunningInformation run(String executablePath,String outputPath,String inputPath,String answerPath,int cpuTimeLimit, int memoryLimit);

    //外部接口，判一道题目
    static public TestRecord startJudge(Problem problem, File sourceCodeFile){
        //测评结果初始化
        TestRecord result = new TestRecord(0, problem.getId(),null,0,0,Result.ACCEPT);

        //编译并设置编译器报错信息
        String ceMessage = null;
        try {
            ceMessage = judgeHost.compileCode(sourceCodeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert ceMessage != null;
        //非空串代表编译失败,直接返回
        if(!ceMessage.isEmpty()){
            result.setJudgeResult(Result.COMPILATION_ERROR);
            result.setComplieErrorMessage(ceMessage);
            return result;
        }

        //如果编译正确，初始化输入输出文件路径
        String[] inputPaths = new File(problem.getInputPath()).list();            assert inputPaths != null;
        String[] answerPaths = new File(problem.getOutputPath()).list();          assert answerPaths != null;
        //对每一个样例运行测试
        for(int i = 0; i< inputPaths.length; ++i) {
            final String executablePath = sourceCodeFile.getAbsolutePath() + excutableSuffix;
            final String outputPath = sourceCodeFile.getAbsolutePath() + i;
            //运行一次
            RunningInformation inf = judgeHost.run(executablePath,              outputPath,
                                                    inputPaths[i],              answerPaths[i],
                                                    problem.getCpuTimeLimit(),  problem.getMemoryLimit());
             //更新资源消耗数据，双双取最高值
            result.setCpuTimeCost(Math.max(result.getCpuTimeCost(), inf.cpuTimeCost));
            result.setMemoryCost( Math.max(result.getMemoryCost(),  inf.memoryCost));

            //若有问题直接返回
            if(inf.runningCondition!=Result.ACCEPT){
                result.setJudgeResult(inf.runningCondition);
                return result;
            }
            if(judgeHost.compareFile(answerPaths[i], outputPath){
                result.setJudgeResult(Result.WRONG_ANSWER);
                return result;
            }
        }

        return  result;
    }
}

class RunningInformation{
    public int cpuTimeCost;
    public int memoryCost;
    Result runningCondition;
}