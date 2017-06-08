package com.student.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

/**
 * Created by nkooi on 6/7/2017.
 */
public class TestBase {

    //public static HashMap<String,Object> parameters = new HashMap<String,Object>();

    @BeforeClass
    public static void  init() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8085;
        RestAssured.basePath = "/student";

    }
}
