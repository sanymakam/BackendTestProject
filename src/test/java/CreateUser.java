import controllers.UserControllers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Test(groups = "users",dataProvider = "createUserData",dataProviderClass = CreateUserDataProvider.class)
    public void createDummyUser(String name, String job) {
        UserControllers userControllers = new UserControllers();
        Response response = userControllers.createUser(name, job);
        response.body().prettyPrint();
        Assert.assertEquals(response.statusCode(),201,"Status code is not 201");
    }
}
