package com.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Sandbox {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://619be7a868ebaa001753c69e.mockapi.io/cyram";

        JsonPath jsonPath = RestAssured
                .given()
                .request(Method.GET, "/cats")
                .getBody()
                .jsonPath()
                .prettyPeek();




    }
}
