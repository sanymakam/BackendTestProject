package controllers;

import base.BaseRequests;
import io.restassured.response.Response;

import java.util.HashMap;

public class UserControllers {
    public Response createUser() {
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        Object payload = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        return BaseRequests.post("https://reqres.in/api/users", headers, payload);
    }
}
