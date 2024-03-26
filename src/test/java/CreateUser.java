import controllers.UserControllers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Test(groups = "users")
    public void createDummyUser() {
        UserControllers userControllers = new UserControllers();
        Response response = userControllers.createUser();
        response.body().prettyPrint();
        System.out.println(response.statusCode());
    }
}
