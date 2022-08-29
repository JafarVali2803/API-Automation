package Users.Create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UsersCreateBodyObject {

    private String name;
    private String gender;
    private String email;
    private String status;

    public UsersCreateBodyObject(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.gender = builder.gender;
        this.status = builder.status;
    }

    public static class Builder {
        private String name;
        private String gender;
        private String email;
        private String status;

        public Builder() {
            this.name = "Tenali t";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.gender = "male";
            this.status = "active";
        }

        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }
        public UsersCreateBodyObject build(){
           UsersCreateBodyObject usersCreateBodyObject =  new UsersCreateBodyObject(this);
           return usersCreateBodyObject;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder status(String status){
            this.status =status;
            return this;
        }
    }
}
