package controllers;

import base.BaseRequests;
import io.restassured.response.Response;
import models.CreateUserRequest;
import models.CreateUserResponse;
import utils.ConfigReader;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllers {
    public Response createUser(String name, String job) {
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName(name);
        createUserRequest.setJob(job);

        return BaseRequests.post(ConfigReader.getConfigValue("url") + "users", headers, createUserRequest);
    }

    public CreateUserResponse constructActualResponse(Response response) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setName(response.getBody().path("name"));
        createUserResponse.setJob(response.getBody().path("job"));
        return createUserResponse;
    }

    public CreateUserResponse constructExpectedResponse(String name, String job) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setName(name);
        createUserResponse.setJob(job);
        return createUserResponse;
    }

    public void verifyTheResponse(CreateUserResponse actualResponseResponse, CreateUserResponse expectedResponseResponse) {
        assertThat("Expected and actual response does not match",actualResponseResponse,equalTo(expectedResponseResponse));
    }
}
