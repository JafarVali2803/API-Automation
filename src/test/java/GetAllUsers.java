import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {
    @Test
    public void shouldGetAllUsers() {

        //1. Arrange - Creates the data required to run the tests
        //2. Act - Actions we perform
        //3. Assert - Will compare actual and expected values.
        //BDD syntax
        given()
                .when()
                      .get("https://gorest.co.in/public/v1/users")
                .then()
                        .statusCode(200)
                .body("data",Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                        .log().body();
    }
}
