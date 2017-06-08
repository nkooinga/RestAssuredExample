package com.students.tests;

import com.student.base.TestBase;
import com.student.model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

/**
 * Created by nkooi on 6/7/2017.
 */
public class StudentPostTest extends TestBase {

    @Test
    public void createNewStudent() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C++");

        Student student = new Student();
        student.setFirstName("Tej");
        student.setLastName("Hegde");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Compute Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);

    }

}