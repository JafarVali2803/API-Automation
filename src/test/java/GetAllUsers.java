import Users.CreateUsersRequest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    //1. Arrange - Creates the data required to run the tests
    private CreateUsersRequest createUsersRequest;
    @BeforeClass
    public void beforeClass(){
        createUsersRequest = new CreateUsersRequest();
    }
    @Test
    public void shouldGetAllUsers() {
        //2. Act - Actions we perform

        createUsersRequest.getAllUsers()

                .then()
                //3. Assert - Will compare actual and expected values.
                        .statusCode(200)
                        .body("data",Matchers.hasSize(10))
                        .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                        .log().body();
    }
}
