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
public class StudentDeleteClass extends TestBase{

    @Test
    public void deleteStudent() {
        given()
                .when()
                .delete("/101")
                .then()
                .statusCode(204);
    }
}
