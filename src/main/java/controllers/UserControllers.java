package controllers;

import base.BaseRequests;
import io.restassured.response.Response;
import models.CreateUserRequest;

import java.util.HashMap;

public class UserControllers {
    public Response createUser(String name, String job) {
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName(name);
        createUserRequest.setJob(job);

        return BaseRequests.post("https://reqres.in/api/users", headers, createUserRequest);
    }
}
