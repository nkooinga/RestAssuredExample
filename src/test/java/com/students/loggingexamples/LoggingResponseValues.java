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
public class LoggingResponseValues extends TestBase {

        @Test
        public void test001() {

            /**
             * This test will print out all the response headers
             */

            System.out.println("-------Printing Response Headers---------");
            given()
                    .param("programme", "Computer Science")
                    .param("limit", 1)
                    .when()
                    .get("/list")
                    .then()
                    .log()
                    .headers()
                    .statusCode(200);
        }

    @Test
    public void test002() {

        /**
         * This test will print out the Response Status Line
         */

        System.out.println("-------Printing Response Status Line---------");
        given()
                .param("programme", "Computer Science")
                .param("limit", 1)
                .when()
                .get("/list")
                .then()
                .log()
                .status()
                .statusCode(200);
    }

    @Test
    public void test003() {

        /**
         * This test will print out all the response body
         */

        System.out.println("-------Printing Response Body---------");
        given()
                .param("programme", "Computer Science")
                .param("limit", 1)
                .when()
                .get("/list")
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void test004() {

        /**
         * This test will print out the response body on fail
         */

        System.out.println("-------Printing Response Body On Fail---------");
        given()
                .param("programme", "Computer Science")
                .param("limit", 1)
                .when()
                .get("/list")
                .then()
                .log()
                .ifError();

    }


}
