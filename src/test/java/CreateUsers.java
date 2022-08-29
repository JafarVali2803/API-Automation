import Users.Create.Response.CreateUserResponse;
import Users.Create.UsersCreateBodyObject;
import Users.CreateUsersRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
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
    //   String email = String.format("%s@gmail.com",UUID.randomUUID());

      //  UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Tenali RamaKrishna")
        //        .gender("male").email(email).status("active").build();

       UsersCreateBodyObject requestBodyOb = new UsersCreateBodyObject.Builder().gender("male").build();
        //Act
       CreateUserResponse createUserResponse = createUsersRequest.CreateUser(requestBodyOb);

                //Assert
        createUserResponse.assertUser(requestBodyOb);
    }
    @Test
    public void shouldCreateFemaleUser() {

        //Arrange
//        String email = String.format("%s@gmail.com",UUID.randomUUID());
//        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Riya")
//                .gender("female").email(email).status("active").build();
        UsersCreateBodyObject requestBodyOb = new UsersCreateBodyObject.Builder().gender("female").build();

        //Act
        CreateUserResponse createUserResponse = createUsersRequest.CreateUser(requestBodyOb);

        //Assert
        createUserResponse.assertUser(requestBodyOb);

    }
}
