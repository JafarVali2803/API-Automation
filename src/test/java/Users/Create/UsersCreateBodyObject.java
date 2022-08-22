package Users.Create;

public class UsersCreateBodyObject {

    private String name;
    private String gender;
    private String email;
    private String status;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public UsersCreateBodyObject(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }


}
