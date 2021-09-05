package entity;

enum Result{ACCEPT,WRONG_ANSWER,COMPILATION_ERROR,TIME_LIMIT_EXCEEDED,MEMORY_LIMIT_EXCEEDED,SEGMENTATION_FAULT,RUNTIME_ERROR};
public class TestRecord {
    private int id;
    private int problemId;
    private String submitterId;
    private int runningTime;
    private int occupiedMemory;
    private Result result;

    public TestRecord(int id, int problemId,String submitterId,int runningTime,int occupiedMemory,Result result){
        this.id=id;
        this.problemId=problemId;
        this.submitterId=submitterId;
        this.runningTime=runningTime;
        this.occupiedMemory=occupiedMemory;
        this.result=result;
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

    public int getRunningTime() {
        return runningTime;
    }

    public int getOccupiedMemory() {
        return occupiedMemory;
    }

    public Result getResult() {
        return result;
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

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public void setOccupiedMemory(int occupiedMemory) {
        this.occupiedMemory = occupiedMemory;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
