package com.students.tests;

import static io.restassured.RestAssured.given;

import com.student.base.TestBase;
import com.student.model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;



/**
 * Created by nkooi on 6/7/2017.
 */
public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudent() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C++");
        courses.add("C#");

        Student student = new Student();
        student.setFirstName("Mark");
        student.setLastName("Taylor");
        student.setEmail("mnx@gmail.com");
        student.setProgramme("Compute Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("/101")
                .then()
                .statusCode(200);

    }

}
