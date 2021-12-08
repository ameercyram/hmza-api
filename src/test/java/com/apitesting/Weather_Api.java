package com.apitesting;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Weather_Api {

    @Test
    public void getRandomCityWeather_API_Test(){

        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
        RestAssured
                .given()
                .queryParam("q","london")
                .queryParam("appid","8649167a809171b0f4715f6be2f12b5a")
                .queryParam("lang","ar")
                .queryParam("units","metric")
                .get()
                .prettyPeek();


    }
}
