//package com.responseextraction.assertions;
//
//import io.restassured.RestAssured;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//
//import static io.restassured.RestAssured.given;
//
///**
// * Created by nkooi on 6/7/2017.
// */
//public class assertions {
//
////    static HashMap<String,Object> parameters = new HashMap<String,Object>();
////
////    @BeforeClass
////    public static void  init() {
////        RestAssured.baseURI = "https://query.yahooapis.com";
////        RestAssured.basePath = "/v1/public";
////
////        parameters.put("q", "select * from yahoo.finance.xchange where pair in (\"USDTHB\", \"USDINR\", \"USDCAD\", \"USDAUD\", \"USDEUR\", \"USDBRL\")");
////        parameters.put("format", "json");
////        parameters.put("env", "store://datatables.org/alltableswithkeys");
////
////    }
////// 1. Assert on count value
////    @Test
////    public void test001() {
////        given()
////                .parameters(parameters)
////                .when()
////                .get("/yql")
////                .then()
////                .log()
////                .body()
////                .extract()
////                .path("query.count");
//
//    }
//}
