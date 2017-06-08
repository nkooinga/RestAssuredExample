package com.students.loggingexamples;

import com.student.base.TestBase;
import com.student.model.Student;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

/**
 * Created by nkooi on 6/7/2017.
 */
public class LoggingRequestValues extends TestBase {

    @Test
    public void test001() {

        /**
         * This test will print out all the request headers
         */

        System.out.println("-------Printing Request Headers---------");
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }


    @Test
    public void test002() {

        /**
         * This test will print out all the request parameters
         */

        System.out.println("-------Printing Request Parameters---------");
        given()
                .param("programme", "Computer Science")
                .param("limit", 1)
                .log()
                .params()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

//     This test will print out the request body

    @Test
    public void test003() {
        System.out.println("--------Printing Request Body--------");
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C++");

        Student student = new Student();
        student.setFirstName("Tej");
        student.setLastName("Hegde");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);

    }


//     This test will print out details

    @Test
    public void test004() {
        System.out.println("--------Printing Request Details--------");
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C++");

        Student student = new Student();
        student.setFirstName("Tej");
        student.setLastName("Hegde");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .post();

    }
//  This test will print Request details if validation fails
    @Test
    public void test005() {
        System.out.println("--------Printing Request Details on fail--------");
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C++");

        Student student = new Student();
        student.setFirstName("Tejw");
        student.setLastName("Hegdew");
        student.setEmail("xyz234@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);

    }

}
