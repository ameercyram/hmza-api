package com.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class MockApi_Practice {
    @Test
    public static void test_GET() {
        RestAssured.baseURI = "https://619be7a868ebaa001753c69e.mockapi.io/cyram/";
        RestAssured
                .given()
                .request(Method.GET, "cats")
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void test_Delete() {
        RestAssured.baseURI = "https://619be7a868ebaa001753c69e.mockapi.io/cyram/cats";
        RestAssured
                .given()
                .request(Method.DELETE,"/9")
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_update() {

        JSONObject object = new JSONObject();
        object.put("firstname","malikkgg");
        object.put("lastname","asim chaudry");
        object.put("address","51424 love street");


        RestAssured.baseURI = "https://619be7a868ebaa001753c69e.mockapi.io/cyram";
        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .and()
                .body(object)
                .when()
                .put("/cats/2")
                .then()
                .assertThat()
                .statusCode(200);

        RestAssured
                .given()
                .when()
                .get("/cats")
                .then()
                .assertThat()
                .extract()
                .response()
                .toString()
                .contains("malikkgg");

    }

    @Test
    public void test_POST() {

        String post = "{\n" +
                "  \"lastname\": \"ilzat  chauu\",\n" +
                "  \"firstname\": \"chaudry \",\n" +
                "  \"address\": \"2533 main street\",\n" +
                "  \"id\": \"2\"\n" +
                " }";





        RestAssured.baseURI = "https://619be7a868ebaa001753c69e.mockapi.io/cyram";
        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .and()
                .body(post)
                .when()
                .post("/cats")
                .then()
                .assertThat()
                .statusCode(201);
    }
}
