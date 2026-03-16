package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
//import lombok.Setter;
import java.util.UUID;
import org.mindrot.jbcrypt.BCrypt;

@Getter
public class User {
    @JsonProperty("user_id")
    private String userId;
    private String username;
    private String email;
    private String password;

    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }

    public void create(
            String username,
            String email,
            String password
    ) {
        if (
            this.username == null
            && this.email == null
            && this.password == null
        ){
            this.userId = UUID.randomUUID().toString();
            this.username = username;
            this.email = email;
            this.password = BCrypt.hashpw(password, BCrypt.gensalt(10));
        }
    }

}
