package org.ticketBooking.services;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.ticketBooking.entities.User;
import org.ticketBooking.repository.UserRepository;

public class UserService {
    UserRepository userRepository;
    private Optional<User> userSession;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(
        String fullname,
        String username,
        String email,
        String password
    ){


    }

    public void login(
            String email,
            String password
    ){
        Optional<User> userOptional = this.userRepository.getUserByEmail(email);
        if (userOptional.isEmpty()){
            System.out.printf("No user found with email %s !!\n", email);
            return;
        }
        User user = userOptional.get();
        if (!user.verifyPassword(password)){
            System.out.println("Invalid Password !!");
            return;
        }
        this.userSession = Optional.of(user);
        System.out.println("Login Successful.");
    }

    public void printUser() {
        if (this.userSession.isEmpty())
            System.out.println("User not logged in !");
        else {
            User user = userSession.get();
            System.out.printf(
                    "\nuser id: %s\nfullname: %s\nusername: %s\nemail: %s\n",
                    user.getUserId(), user.getFullname(), user.getUsername(), user.getEmail()
            );
        }
    }
}
