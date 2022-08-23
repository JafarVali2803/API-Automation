import Users.CreateUsersRequest;
import Users.getAll.GetAllUsersResponse;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
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

      GetAllUsersResponse getAllUsersResponse =  createUsersRequest.getAllUsers();

        //3. Assert - Will compare actual and expected values.
        Assert.assertEquals(getAllUsersResponse.getStatusCode(), 200);
        Assert.assertEquals(getAllUsersResponse.getDataList().size(), 20);
        Assert.assertTrue(getAllUsersResponse.hasMaleUser());
    }
}
