package org.ticketBooking.repository;

import org.ticketBooking.entities.User;
import org.ticketBooking.services.JsonService;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final JsonService<User> jsonService;

    public UserRepository(
            JsonService<User> jsonService
    ){
        this.jsonService = jsonService;
    }

    public Optional<User> getUserByEmail(String email) {
        try {
            List<User> users = jsonService.getData();
            return users.stream().filter(
              user -> user.getEmail().equals(email)
            ).findFirst();
        } catch (Exception e){
            throw new RuntimeException("Failed to fetch user data !", e);
        }
    }

    public Optional<User> getUserByEmailOrUsername(String email, String username){
        try {
            List<User> users = jsonService.getData();
            return users.stream().filter(
                    user -> (user.getEmail().equals(email) || user.getUsername().equals(username))
            ).findFirst();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch user data !", e);
        }
    }

    public boolean saveUser(User user) {
        try {
            List<User> users = jsonService.getData();
            users.add(user);
            jsonService.saveData(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
