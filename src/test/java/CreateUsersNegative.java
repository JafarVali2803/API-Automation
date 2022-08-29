import Users.Create.Response.CreateUserErrorResponse;
import Users.Create.UsersCreateBodyObject;
import Users.CreateUsersRequest;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateUsersNegative {

    private CreateUsersRequest createUsersRequest;
    @BeforeClass
    public void beforeClass(){
        createUsersRequest = new CreateUsersRequest();
    }

    @Test
    public void shouldNotAllowUserToCreateWithInvalidEmail(){
        //Arrange
//        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Riya")
//                .gender("female").email("riya.28.com").status("active").build();

        UsersCreateBodyObject requestBodyOb = new UsersCreateBodyObject.Builder().email("tiya.kjbj.com").build();
        //Act
      CreateUserErrorResponse errorResponse = createUsersRequest.createUserExpectingError(requestBodyOb);

                //Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("email", "is invalid");

    }

    @Test
    public void shouldNotAllowUserToCreateWithBlankGenderAndStatus(){
        //Arrange
//        UsersCreateBodyObject requestBodyOb = UsersCreateBodyObject.builder().name("Riya")
//                .gender("").email("riya2.28@gmail.com").status("").build();

        UsersCreateBodyObject requestBodyOb = new UsersCreateBodyObject.Builder().gender("").status("").build();
        //Act
        CreateUserErrorResponse errorResponse = createUsersRequest.createUserExpectingError(requestBodyOb);

        //Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("gender", "can't be blank, can be male or female");
        errorResponse.assertHasError("status", "can't be blank");

    }
}
