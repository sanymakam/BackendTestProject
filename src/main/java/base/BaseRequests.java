package base;

import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseRequests {
    private BaseRequests() {
        throw new IllegalAccessError("Utility class");
    }

    public static Response post(String url, Map<String, String> headers, Object payLoad) {
        return given().headers(headers).body(payLoad).when().post(url).then().extract().response();
    }

    public static Response get(String url) {
        Response response = given().urlEncodingEnabled(false).when().get(url).then().extract().response();
        return response;
    }

    public static Response patch(String url, Map<String, String> headers) {
        return given().headers(headers).when().patch(url).then().extract().response();
    }
}