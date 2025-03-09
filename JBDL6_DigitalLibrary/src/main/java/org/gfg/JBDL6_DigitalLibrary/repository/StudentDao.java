package org.gfg.JBDL6_DigitalLibrary.repository;

import org.gfg.JBDL6_DigitalLibrary.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createStudentInDatabase(Student student){
        String query = "INSERT INTO student (STUDENT_ID, NAME, EMAIL, PHONE_NO, STUDENT_TYPE) VALUES (?,?,?,?,?)";
        int row = jdbcTemplate.update(query, student.getStudentId(), student.getName(), student.getEmail(), student.getPhoneNo(), student.getStudentType().toString());
        return row;

    }
}
