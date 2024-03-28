package clients;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    public static Response post(String url, Map<String, String> headers, Object payLoad) {
        return given().headers(headers).body(payLoad).when().post(url).then().extract().response();
    }

    public static Response get(String url) {
        return given().urlEncodingEnabled(false).when().get(url).then().extract().response();
    }

    public static Response patch(String url, Map<String, String> headers) {
        return given().headers(headers).when().patch(url).then().extract().response();
    }
}
