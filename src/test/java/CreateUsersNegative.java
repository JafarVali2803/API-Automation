import Users.CreateUsersRequest;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateUsersNegative {
    @Test
    public void shouldNotAllowUserToCreateWithInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"Riya1\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"riya.28031.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Act
        new CreateUsersRequest().CreateUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
