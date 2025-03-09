package org.gfg.JBDL6_DigitalLibrary.controller;

import org.gfg.JBDL6_DigitalLibrary.models.Student;
import org.gfg.JBDL6_DigitalLibrary.request.StudentCreationRequest;
import org.gfg.JBDL6_DigitalLibrary.response.StudentResponse;
import org.gfg.JBDL6_DigitalLibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService studentService;


    @PostMapping("/create/student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentCreationRequest studentCreationRequest){
        if (studentCreationRequest.getName()==null || studentCreationRequest.getName().isEmpty()){
            // return validation error
        }
        if (studentCreationRequest.getEmail()==null || studentCreationRequest.getEmail().isEmpty() ){
            // return validtion error
        }

       Student student = studentService.createStudent(studentCreationRequest);
        StudentResponse studentResponse = new StudentResponse();
        if (student==null){
            studentResponse.setErrCode("001");
            studentResponse.setErrMessage("Data Not Created");
            return new ResponseEntity<>(studentResponse, HttpStatus.BAD_REQUEST);
        }

        studentResponse.setErrCode("00");
        studentResponse.setErrMessage("Student Has been created");
        studentResponse.setStudentId(Integer.toString(student.getStudentId()));
        studentResponse.setName(student.getName());

        return new ResponseEntity<>(studentResponse,HttpStatus.CREATED);

    }
}
