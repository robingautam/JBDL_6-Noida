package org.gfg.JBDL6_DigitalLibrary.service;

import org.gfg.JBDL6_DigitalLibrary.models.Student;
import org.gfg.JBDL6_DigitalLibrary.models.StudentType;
import org.gfg.JBDL6_DigitalLibrary.repository.StudentDao;
import org.gfg.JBDL6_DigitalLibrary.request.StudentCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentDao studentDao;

    public Student createStudent(StudentCreationRequest studentCreationRequest){

        String id = studentCreationRequest.getStudentId();
        String type = StudentType.ACTIVE.toString();
        String name = studentCreationRequest.getName();
        String email = studentCreationRequest.getEmail();
        String phone = studentCreationRequest.getPhoneNo();


        Student student = Student.builder().studentId(Integer.parseInt(id)).studentType(StudentType.valueOf(type))
                .email(email).name(name).phoneNo(phone).build();

        int result = studentDao.createStudentInDatabase(student);

        if (result>0){
            System.out.println("Data has been inserted successfully");
            return student;
        }
        return null;

    }
}
