package com.codetesting.codetesting.databaseIntegrationTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

// integration testing with database jpa hibernate ok

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {
    /*
    @Autowired
    private JdbcTemplate jdbc; // from spring framework

    @BeforeEach
    public void setupDatabase() {
        jdbc.execute("insert into student(id, firstname, lastname, email_address) " +
                "values (1, 'Eric', 'Roby', 'eric.roby@luv2code_school.com')");   //insert in db
    }
    @AfterEach
    public void setupAfterTransaction() {
        jdbc.execute("DELETE FROM student"); // delete in db
    }

    @Test
    public void isStudentNullCheck() {
        assertTrue(studentService.checkIfStudentIsNull(1));
        assertFalse(studentService.checkIfStudentIsNull(0));
    }


     */
}