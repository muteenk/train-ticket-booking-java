package org.ticketBooking.repository;

import org.ticketBooking.entities.User;
import org.ticketBooking.services.JsonService;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final String USERS_PATH = "../datastore/users.json";
    private final JsonService<User> jsonService = new JsonService<>(USERS_PATH, User.class);

    public Optional<User> getUserByEmail(String email) {
        try {
            List<User> users = jsonService.getData();
            for (User user : users) {
                if (user.getEmail().equals(email)) return Optional.of(user);
            }
            return Optional.empty();
        } catch (Exception e){
            throw new RuntimeException("Failed to fetch user data !", e);
        }
    }
}
