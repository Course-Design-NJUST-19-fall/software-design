package entity;

import java.util.List;

public class Class {
    private int id;
    private String teacherId;
    private List<String> studentsId;
    private List<Integer> homeworkId;
    public Class(int id,String teacherId,List<String> studentsId,List<Integer> homeworkId){
       this.id=id;
       this.homeworkId=homeworkId;
       this.studentsId=studentsId;
       this.teacherId=teacherId;
    }

    public int getId() {
        return id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public List<Integer> getHomeworkId() {
        return homeworkId;
    }

    public List<String> getStudentsId() {
        return studentsId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setHomeworkId(List<Integer> homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setStudentsId(List<String> studentsId) {
        this.studentsId = studentsId;
    }
}
