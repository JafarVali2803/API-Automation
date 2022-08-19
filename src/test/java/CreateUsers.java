import Users.CreateUsersRequest;
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
                "    \"email\": \"tenali.ramakrishna28032@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Act
        new CreateUsersRequest().CreateUser(requestBody)
                .then()

                //Assert
                     .statusCode(201)
                     .body("data.id", Matchers.notNullValue())
                     .body("data.name",Matchers.equalTo("Tenali Ramakrishna2"))
                     .body("data.email",Matchers.equalTo("tenali.ramakrishna28032@gmail.com"))
                     .log().body();
    }
    @Test
    public void shouldCreateFemaleUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Riya1\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"riya.28032@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
       new CreateUsersRequest().CreateUser(requestBody)

                .then()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Riya1"))
                .body("data.email", Matchers.equalTo("riya.28032@gmail.com"))
                .log().body();
    }
}
