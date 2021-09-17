package tool;

import entity.Problem;
import entity.TestRecord;

import java.io.File;

class JudgeHostTest {
    public static void main(String[] args) {
        Problem problem = new Problem(1,100,100,0,0,1,"testProblem","c:/code/strange/printN.c","c:/code/test/input","c:/code/test/output");
        File sourceFile = new File("c:/code/1.cpp");

        JudgeHost judgeHost = new JudgeHost(problem,sourceFile);
        TestRecord record = judgeHost.startJudge();
        System.out.println(record.getCompilationErrorMessage());
        System.out.println(record.getCpuTimeCost());
        System.out.println(record.getMemoryCost());
        System.out.println(record.getResult());
    }
}