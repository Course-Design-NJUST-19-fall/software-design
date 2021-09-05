package entity;

public class Problem {
    private int id;
    private int cpuTimeLimit;
    private int memoryLimit;
    private int acceptNumber;
    private int submitNumber;
    private String problemName;
    private String problemPath;
    private String inputPath;
    private String outputPath;
    public Problem(int id,int cpuTimeLimit,int memoryLimit,int acceptNumber,int submitNumber,String problemName,
                   String problemPath,String inputPath,String outputPath)
    {
        this.id=id;
        this.cpuTimeLimit=cpuTimeLimit;
        this.memoryLimit=memoryLimit;
        this.acceptNumber=acceptNumber;
        this.submitNumber=submitNumber;
        this.problemName=problemName;
        this.problemPath=problemPath;
        this.inputPath=inputPath;
        this.outputPath=outputPath;
    }
    public Problem(){

    }

    public int getId() {
        return id;
    }

    public String getProblemName() {
        return problemName;
    }

    public int getAcceptNumber() {
        return acceptNumber;
    }

    public int getSubmitNumber() {
        return submitNumber;
    }
    public int getCpuTimeLimit() {
        return cpuTimeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getProblemPath() {
        return problemPath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAcceptNumber(int acceptNumber) {
        this.acceptNumber = acceptNumber;
    }

    public void setSubmitNumber(int submitNumber) {
        this.submitNumber = submitNumber;
    }

    public void setCpuTimeLimit(int cpuTimeLimit) {
        this.cpuTimeLimit = cpuTimeLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public void setProblemPath(String problemPath) {
        this.problemPath = problemPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
