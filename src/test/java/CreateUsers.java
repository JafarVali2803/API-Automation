import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsers {
    @Test
    public void shouldCreateMaleUser(){

        //Arrange
        String requestBody = "{\n" +
                "    \"name\": \"Tenali Ramakrishna2\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna28031@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Act
        CreateUser(requestBody)
                .then()

                //Assert
                     .statusCode(201)
                     .body("id", Matchers.notNullValue())
                     .body("name",Matchers.equalTo("Tenali Ramakrishna2"))
                     .body("email",Matchers.equalTo("tenali.ramakrishna28031@gmail.com"))
                     .log().body();
    }
    @Test
    public void shouldCreateFemaleUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Riya1\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"riya.28031@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        CreateUser(requestBody)

                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("Riya1"))
                .body("email", Matchers.equalTo("riya.28031@gmail.com"))
                .log().body();
    }
    private static Response CreateUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer e5efd1c0e45273b0369c22a479a2c8ef6335343001d046c4bcc63e6d22a27b67")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
