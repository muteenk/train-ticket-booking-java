package org.ticketBooking.services;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.ticketBooking.entities.User;
import org.ticketBooking.repository.UserRepository;

public class UserService {
    UserRepository userRepository;
    private User userSession;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(
        String username,
        String email,
        String password
    ){
        Optional<User> userOptional = this.userRepository.getUserByEmailOrUsername(email, username);
        if (userOptional.isPresent()) {
            System.out.printf("\nUser with username %s or email %s already exists\n", username, email);
            return;
        }
        User newUser = new User();
        newUser.create(username, email, password);
        boolean isSaved = this.userRepository.saveUser(newUser);
        if (!isSaved) {
            System.out.println("Error while saving user !");
            return;
        }
        this.userSession = newUser;
        System.out.println("Signup Successful.");
    }

    public void login(
            String email,
            String password
    ){
        Optional<User> userOptional = this.userRepository.getUserByEmail(email);
        if (userOptional.isEmpty()){
            System.out.printf("\nNo user found with email %s !!\n", email);
            return;
        }
        User user = userOptional.get();
        if (!user.verifyPassword(password)){
            System.out.println("Invalid Password !!");
            return;
        }
        this.userSession = user;
        System.out.println("Login Successful.");
    }

    public boolean isAuthenticated(){
        return this.userSession != null;
    }

    public Optional<User> getAuthenticatedUser() {
        return Optional.of(this.userSession);
    }
}
