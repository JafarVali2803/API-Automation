import io.restassured.http.ContentType;
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
   @Test
   public void shouldCreateUser(){
        given()
               .accept(ContentType.JSON)
               .contentType(ContentType.JSON)
               .header("Authorization", "Bearer e5efd1c0e45273b0369c22a479a2c8ef6335343001d046c4bcc63e6d22a27b67")
               .body("{\n" +
                       "    \"name\": \"Tenawerdbnfxgldi Ramakrishna\",\n" +
                       "    \"gender\": \"male\",\n" +
                       "    \"email\": \"tenhgcgjghali.ramakrifshnda@15ce.com\",\n" +
                       "    \"status\": \"active\"\n" +
                       "}")
               .when()
                   .post("https://gorest.co.in/public/v2/users")

                .then()
                   .statusCode(201)
                   .log().body();
   }

}
