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
        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Riya")
                .gender("female").email("riya.28.com").status("active").build();
        //Act
       createUsersRequest.create(requestBodyOb)

                //Assert
               .then()
                     .statusCode(422)
                     .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
