package space.nullpoint.secretsanta0.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    private String name;
    private String email;
    private Gender gender;
    @Setter
    private User ward;

    public User(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        if (ward == null)
            return "User: " + name + " (" + email + ")";
        return "User: " + name + " (" + email + ") --> Ward: " + ward.getName() + " (" + ward.getEmail() + ")";
    }
}
