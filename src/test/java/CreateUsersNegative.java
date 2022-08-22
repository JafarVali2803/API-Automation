import Users.Create.UsersCreateBodyObject;
import Users.CreateUsersRequest;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUsersNegative {

    private CreateUsersRequest createUsersRequest;
    @BeforeClass
    public void beforeClass(){
        createUsersRequest = new CreateUsersRequest();
    }

    @Test
    public void shouldNotAllowUserToCreateWithInvalidEmail(){
        //Arrange
        String name = "Riya1";
        String gender = "female";
        String email = "riya.28031.com";
        String status = "active";

        UsersCreateBodyObject requestBodyOb =  new UsersCreateBodyObject(name, gender,email, status);

        //Act
       createUsersRequest.CreateUser(requestBodyOb)
                .then()
                     .log().body()
                //Assert
                     .statusCode(422)
                     .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
