package org.ticketBooking.controllers;

import org.ticketBooking.repository.UserRepository;
import org.ticketBooking.services.UserService;

import java.util.Scanner;

public class UserController {
    private final UserRepository userRepository = new UserRepository();
    private final UserService userService = new UserService(userRepository);
    private final Scanner input;

    public UserController(Scanner input){
        this.input = input;
    }

    public void signupController(){
        String username = "";
        while(username.length() < 2) {
            System.out.println("\n\n Username (Min. 2 letters required): ");
            username = this.input.nextLine();
        }

        String email = "";
        System.out.println("\n\n Email Address : ");
        email = this.input.nextLine();

        System.out.println("\n\n Password : ");
        String password = this.input.nextLine();
    }

    public boolean isUserAuthenticated(){
        return userService.isAuthenticated();
    }


}
