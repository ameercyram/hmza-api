package com.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Practice2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://universities.hipolabs.com/search?country=United+States";
        JsonPath jsonPath = RestAssured
                .given()
                .request(Method.GET)
                .jsonPath()
                .prettyPeek();


    }
}
