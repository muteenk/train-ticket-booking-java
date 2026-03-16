package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("user_id")
    private String userId;
    private String username;
    private String email;
    private String password;


    public String getUserId() { return this.userId; }
    public String getUsername() { return this.username; }
    public String getEmail() {return this.email;}
    public String getPassword() { return this.password; }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
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
            this.userId = "randomString";
            this.username = username;
            this.email = email;
            this.password = password;
        }
    }

}
