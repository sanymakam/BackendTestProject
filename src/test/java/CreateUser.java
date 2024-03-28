import controllers.UserControllers;
import io.restassured.response.Response;
import models.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUser {
    @Test(groups = "users", dataProvider = "createUserData", dataProviderClass = CreateUserDataProvider.class)
    public void createDummyUser(String name, String job) {
        UserControllers userControllers = new UserControllers();
        Response response = userControllers.createUser(name, job);
        response.body().prettyPrint();
        Assert.assertEquals(response.statusCode(), 201, "Status code is not 201");
        CreateUserResponse actualResponseResponse = userControllers.constructActualResponse(response);
        CreateUserResponse expectedResponseResponse = userControllers.constructExpectedResponse(name, job);
        userControllers.verifyTheResponse(actualResponseResponse, expectedResponseResponse);
    }
}
