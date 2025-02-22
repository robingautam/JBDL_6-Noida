package org.gfg.JBDL6_SpringBoot.service;

import org.gfg.JBDL6_SpringBoot.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student(1,"Robin","robin@gmail.com"));
        list.add(new Student(2,"Preeti", "preeti@gmail.com"));
        list.add(new Student(3,"Aakash","aakash@gmail.com"));
    }

    public Student getStudentById(int id){
        for (Student st: list){
            if (st.getId()==id){
                return st;
            }
        }
        return null;
    }

    public List<Student> getAllStudentList(){
        return list;
    }
}
