package com.students.com.responsextraction.assertions;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * Created by nkooi on 6/7/2017.
 */
public class AddingAssertions {
    static HashMap<String,Object> parameters = new HashMap<String,Object>();

    @BeforeClass
    public static void  init() {
        RestAssured.baseURI = "https://query.yahooapis.com";
        RestAssured.basePath = "/v1/public";

        parameters.put("q", "select * from yahoo.finance.xchange where pair in (\"USDTHB\", \"USDINR\", \"USDCAD\", \"USDAUD\", \"USDEUR\", \"USDBRL\")");
        parameters.put("format", "json");
        parameters.put("env", "store://datatables.org/alltableswithkeys");

    }
    // 1. Assert on count value
    @Test
    public void test001() {
        given()
                .parameters(parameters)
                .when()
                .get("/yql")
                .then()
                .body("query.count", equalTo(6));
    }

    // 2. Assert on single name
    @Test
    public void test002() {
        given()
                .parameters(parameters)
                .when()
                .get("/yql")
                .then()
                .body("query.results.rate.Name", hasItem("USD/INR"));
    }

    // 3. Assert on multiple names
    @Test
    public void test003() {
        given()
                .parameters(parameters)
                .when()
                .get("/yql")
                .then()
                .body("query.results.rate.Name", hasItems("USD/INR","USD/THB","USD/BRL"));
    }

    // 4. Logical Assertions
    @Test
    public void test004() {
        given()
                .parameters(parameters)
                .when()
                .get("/yql")
                .then()
                .body("query.results.rate.Name", hasItems("USD/INR","USD/THB","USD/BRL"))
                .body("query.count", greaterThan(4))
                .body("query.count", lessThan(10));

    }

}
