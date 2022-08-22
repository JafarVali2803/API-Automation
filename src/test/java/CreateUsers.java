import Users.Create.UsersCreateBodyObject;
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
       String name = "Tenali Ramakrishna2";
       String gender = "male";
       String status = "active";

      UsersCreateBodyObject requestBodyOb =  new UsersCreateBodyObject(name, gender,email, status);

        //Act
        createUsersRequest.CreateUser(requestBodyOb)
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
        String name = "Riya1";
        String gender = "female";
        String status = "active";

        UsersCreateBodyObject requestBodyOb =  new UsersCreateBodyObject(name, gender,email, status);
        createUsersRequest.CreateUser(requestBodyOb)

                .then()
                     .statusCode(201)
                     .body("data.id", Matchers.notNullValue())
                     .body("data.name", Matchers.equalTo("Riya1"))
                     .body("data.email", Matchers.equalTo(email))
                     .log().body();
    }
}
