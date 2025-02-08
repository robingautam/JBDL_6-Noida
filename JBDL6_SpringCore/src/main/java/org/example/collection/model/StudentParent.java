package org.example.collection.model;

public class StudentParent {

    int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentParent{" +
                "studentId=" + studentId +
                '}';
    }
}
