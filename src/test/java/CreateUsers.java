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

        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Tenali RamaKrishna")
                .gender("male").email(email).status("active").build();
        //Act
        createUsersRequest.CreateUser(requestBodyOb)
                .then()
                //Assert
                     .statusCode(201)
                     .body("data.id", Matchers.notNullValue())
                     .body("data.name",Matchers.equalTo("Tenali RamaKrishna"))
                     .body("data.email",Matchers.equalTo(email))
                     .log().body();
    }
    @Test
    public void shouldCreateFemaleUser() {

        String email = String.format("%s@gmail.com",UUID.randomUUID());

        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Riya")
                .gender("female").email(email).status("active").build();
        createUsersRequest.CreateUser(requestBodyOb)

                .then()
                     .statusCode(201)
                     .body("data.id", Matchers.notNullValue())
                     .body("data.name", Matchers.equalTo("Riya"))
                     .body("data.email", Matchers.equalTo(email))
                     .log().body();
    }
}
