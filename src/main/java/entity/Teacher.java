package entity;

public class Teacher extends User{
    private int classId;

    public Teacher(String userName, String passWord, String nicoName, String phoneNumber, Type type, boolean listenMessage,
                   int classId)
    {
          super(userName, passWord, nicoName, phoneNumber, type, listenMessage);
          this.classId=classId;
    }
    public Teacher(){
        super();
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
