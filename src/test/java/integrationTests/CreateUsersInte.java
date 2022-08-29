package integrationTests;

import Users.Create.Response.CreateUserResponse;
import Users.Create.UsersCreateBodyObject;
import Users.CreateUsersRequest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUsersInte {
    private CreateUsersRequest createUsersRequest;
    @BeforeClass
    public void beforeClass(){
        createUsersRequest = new CreateUsersRequest();
    }
    @Test
    public void shouldCreateAndGetUser() {

        //Arrange
//        String email = String.format("%s@gmail.com", UUID.randomUUID());
//
//        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Tenali RamaKrishna")
//                .gender("male").email(email).status("active").build();
        UsersCreateBodyObject requestBodyOb = new UsersCreateBodyObject.Builder().build();

        //Act
        int id = createUsersRequest.CreateUser(requestBodyOb).getData().getId();

        //Assert
        CreateUsersRequest.getUser(id).assertUser(requestBodyOb);
    }
}
