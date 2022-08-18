import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Sample {
    @Test
    public void shouldGetAllUsers() {

        //1. Arrange - Creates the data required to run the tests
        //2. Act - Actions we perform
        //3. Assert - Will compare actual and expected values.
        //BDD syntax
        given()
                .when()
                      .get("https://gorest.co.in/public/v2/users")
                .then()
                        .statusCode(200)
                        .log().body();
    }
}
