import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUser {
    public static void main(String[] args) {
        Response response = given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").when().post("https://reqres.in/api/users").then().extract().response();
        System.out.println(response.body().prettyPrint());
        System.out.println(response.statusCode());

    }
}
