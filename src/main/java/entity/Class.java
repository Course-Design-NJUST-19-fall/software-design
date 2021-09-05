package entity;

import java.util.Collections;
import java.util.List;

public class Class {
    private int id;
    private String teacherId;
    private List<String> studentIds;
    private List<Integer> homeworkIds;
    public Class(int id,String teacherId,List<String> studentIds,List<Integer> homeworkIds){
       this.id=id;
       this.homeworkIds =homeworkIds;
       this.studentIds =studentIds;
       this.teacherId=teacherId;
    }

    public int getId() {
        return id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public List<Integer> getHomeworkIds() {
        return homeworkIds;
    }

    public List<String> getStudentIds() {
        return studentIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setHomeworkIds(List<Integer> homeworkIds) {
        this.homeworkIds = homeworkIds;
    }

    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public void addHomework(int homeworkId){
        this.homeworkIds.add(Integer.valueOf(homeworkId));
        Collections.sort(homeworkIds);
    }
    public void addStudent(String studentId){
        this.studentIds.add(studentId);
    }
    public void deleteStudent(String studentId){
        this.studentIds.remove(studentId);
    }
    public void deleteHomework(int homeworkId){
        this.homeworkIds.remove(Integer.valueOf(homeworkId));
    }
}
