package org.example.collection.model;

import java.util.List;

public class StudentParent {

    int studentId;

    List<String> parentList;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<String> getParentList() {
        return parentList;
    }

    public void setParentList(List<String> parentList) {
        this.parentList = parentList;
    }

    @Override
    public String toString() {
        return "StudentParent{" +
                "studentId=" + studentId +
                ", parentList=" + parentList +
                '}';
    }
}
