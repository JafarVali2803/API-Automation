package Users.Create.Response;

import Users.Create.UsersCreateBodyObject;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;

    private String meta;
    private Data data;

    public void assertUser(UsersCreateBodyObject requestBodyOb) {
        Assert.assertEquals(this.getStatusCode(), 201);
        Assert.assertNotNull(this.getData().getId());
        Assert.assertEquals(this.getData().getEmail(),requestBodyOb.getEmail());
        Assert.assertEquals(this.getData().getName(),requestBodyOb.getName());
        Assert.assertEquals(this.getData().getGender(),requestBodyOb.getGender());
        Assert.assertEquals(this.getData().getStatus(),requestBodyOb.getStatus());
    }
}
