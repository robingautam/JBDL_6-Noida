package org.gfg.JBDL6_SpringBoot.controller;

import org.gfg.JBDL6_SpringBoot.model.Student;
import org.gfg.JBDL6_SpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/get/student/id/{studentId}")
    public Student getStudentById(@PathVariable("studentId") String id){
        int iid = Integer.parseInt(id);
        Student student = studentService.getStudentById(iid);
        return student;
    }

    @RequestMapping("/get/student")
    public List<Student> getStudent(){
        System.out.println("Inside the getStudent() method");
        List<Student> student = studentService.getAllStudentList();
        return student;
    }

    @RequestMapping(value = "/post/student", method = RequestMethod.POST)
    public ResponseEntity<String> postData(@RequestBody Student student){
        System.out.println(student);
        return new ResponseEntity<>("data Recieved", HttpStatus.CREATED);
    }
}
