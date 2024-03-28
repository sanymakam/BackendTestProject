package base;

import clients.RestAssuredClient;
import io.restassured.response.Response;

import java.util.Map;

public class BaseRequests {
    public static Response post(String url, Map<String, String> headers, Object payLoad) {
        return RestAssuredClient.post(url, headers, payLoad);
    }

    public static Response get(String url) {
        return RestAssuredClient.get(url);
    }

    public static Response patch(String url, Map<String, String> headers) {
        return RestAssuredClient.patch(url, headers);
    }
}