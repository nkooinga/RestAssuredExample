package com.student.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

/**
 * Created by nkooi on 6/7/2017.
 */
public class AssertionsBase {

    public static HashMap<String,Object> parameters = new HashMap<String,Object>();

    @BeforeClass
    public static void  init() {
        RestAssured.baseURI = "https://query.yahooapis.com";
        RestAssured.basePath = "/v1/public";

        parameters.put("q", "select * from yahoo.finance.xchange where pair in (\"USDTHB\", \"USDINR\", \"USDCAD\", \"USDAUD\", \"USDEUR\", \"USDBRL\")");
        parameters.put("format", "json");
        parameters.put("env", "store://datatables.org/alltableswithkeys");

    }
}
