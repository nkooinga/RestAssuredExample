package com.students.tests;

import com.student.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.testng.Assert.*;

/**
 * Created by nkooi on 6/7/2017.
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentInformation() {
        /**
         * given()
         * set cookies, add auth, adding parameters, setting header info
         * .when()
         *  GET, POST, PUT, DELETE, etc.
         * .then()
         * Validate status code, extract response, extract headers, cookies, extract the response body
         **/

        Response response = given()
                .when()
                .get("/list");
        System.out.println(response.body().prettyPrint());

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);


    }

    @Test
    public void getStudentInfo() {

        Response response = given()
                .when()
                .get("/1");

       System.out.println(response.body().prettyPrint());

        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void  getStudentsFromFA() {
        Response response = given()
                .when()
                .get("/list?programme=Financial Analysis&limit=2");

        //System.out.println(response.prettyPeak());

        Response response2 = given()
                .param("programme", "Financial Analysis")
                .param("limit", 2)
                .when()
                .get("/list");

        //System.out.println(response2.prettyPeak());

    }

}