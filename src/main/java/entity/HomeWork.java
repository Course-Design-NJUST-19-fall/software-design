package entity;

public class HomeWork {
    private int id;
    private int classId;
    public HomeWork(int id,int classId){
        this.id=id;
        this.classId=classId;
    }
    public HomeWork(){

    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
