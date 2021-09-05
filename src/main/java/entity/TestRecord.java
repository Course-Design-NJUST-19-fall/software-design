package entity;

enum Result{ACCEPT,WRONG_ANSWER,COMPILATION_ERROR,TIME_LIMIT_EXCEEDED,MEMORY_LIMIT_EXCEEDED,SEGMENTATION_FAULT,RUNTIME_ERROR};
public class TestRecord {
    private int id;
    private int problemId;
    private String submitterId;
    private int cpuTimeCost;
    private int memoryCost;
    private Result judgeResult;

    public TestRecord(int id, int problemId,String submitterId,int runningTime,int occupiedMemory,Result result){
        this.id=id;
        this.problemId=problemId;
        this.submitterId=submitterId;
        this.cpuTimeCost =runningTime;
        this.memoryCost =occupiedMemory;
        this.judgeResult =result;
    }

    public TestRecord(){

    }

    public int getId() {
        return id;
    }

    public int getProblemId() {
        return problemId;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public int getCpuTimeCost() {
        return cpuTimeCost;
    }

    public int getMemoryCost() {
        return memoryCost;
    }

    public Result getJudgeResult() {
        return judgeResult;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public void setCpuTimeCost(int cpuTimeCost) {
        this.cpuTimeCost = cpuTimeCost;
    }

    public void setMemoryCost(int memoryCost) {
        this.memoryCost = memoryCost;
    }

    public void setJudgeResult(Result judgeResult) {
        this.judgeResult = judgeResult;
    }
}
