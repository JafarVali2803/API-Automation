package Users.get;

import Users.Create.UsersCreateBodyObject;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import static org.testng.Assert.*;

@Getter
public class GetUserResponse {

    @Setter
    private int statusCode;
    private Data data;
    private String meta;

    public void assertUser(UsersCreateBodyObject requestBodyOb) {
        assertEquals(data.email,requestBodyOb.getEmail());
        assertEquals(data.name,requestBodyOb.getName());
        assertEquals(data.gender,requestBodyOb.getGender());
        assertEquals(data.status,requestBodyOb.getStatus());
    }

    @Getter
    public static class Data{

        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }
}

