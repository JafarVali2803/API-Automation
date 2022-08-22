import Users.CreateUsersRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUsers {

    private CreateUsersRequest createUsersRequest;
    @BeforeClass
    public void beforeClass(){
        createUsersRequest = new CreateUsersRequest();
    }
    @Test
    public void shouldCreateMaleUser(){

        //Arrange
       String email = String.format("%s@gmail.com",UUID.randomUUID());
        String requestBody = String.format("{\n" +
                "    \"name\": \"Tenali Ramakrishna2\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);

        //Act
        createUsersRequest.CreateUser(requestBody)
                .then()
                //Assert
                     .statusCode(201)
                     .body("data.id", Matchers.notNullValue())
                     .body("data.name",Matchers.equalTo("Tenali Ramakrishna2"))
                     .body("data.email",Matchers.equalTo(email))
                     .log().body();
    }
    @Test
    public void shouldCreateFemaleUser() {

        String email = String.format("%s@gmail.com",UUID.randomUUID());
        String requestBody = String.format("{\n" +
                "    \"name\": \"Riya1\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);
        createUsersRequest.CreateUser(requestBody)

                .then()
                     .statusCode(201)
                     .body("data.id", Matchers.notNullValue())
                     .body("data.name", Matchers.equalTo("Riya1"))
                     .body("data.email", Matchers.equalTo(email))
                     .log().body();
    }
}
