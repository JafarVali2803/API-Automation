package Users;

import Users.Create.Response.CreateUserErrorResponse;
import Users.Create.Response.CreateUserResponse;
import Users.Create.UsersCreateBodyObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUsersRequest {

    public static CreateUserResponse CreateUser(UsersCreateBodyObject body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(UsersCreateBodyObject body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }

    public static Response create(UsersCreateBodyObject body) {
        Response response =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer e5efd1c0e45273b0369c22a479a2c8ef6335343001d046c4bcc63e6d22a27b67")
                        .body(body)
                        .when()
                        .post("https://gorest.co.in/public/v1/users");

        response
                .then()
                .log().body();
        return
                response;
    }

    public static Response getAllUsers() {
        return
                given()
                        .when()
                        .get("https://gorest.co.in/public/v1/users");
    }
}