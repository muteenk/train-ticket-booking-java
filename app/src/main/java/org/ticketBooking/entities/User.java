package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("user_id")
    private String userId;
    private String fullname;
    private String username;
    private String email;
    private String password;

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public String getUserId() { return this.userId; }
    public String getFullname() { return this.fullname; }
    public String getUsername() { return this.username; }
    public String getEmail() {return this.email;}
    public String getPassword() {return this.password;}


}
