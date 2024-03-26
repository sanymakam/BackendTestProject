import controllers.UserControllers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUser {
    public static void main(String[] args) {
        UserControllers userControllers = new UserControllers();
        Response response = userControllers.createUser();
        response.body().prettyPrint();
        System.out.println(response.statusCode());
    }
}
