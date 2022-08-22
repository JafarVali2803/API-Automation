package Users.Create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class UsersCreateBodyObject {

    private String name;
    private String gender;
    private String email;
    private String status;

}
