package org.ticketBooking.controllers;

import org.ticketBooking.repository.UserRepository;
import org.ticketBooking.services.UserService;
import org.ticketBooking.services.ValidatorService;

import java.util.Scanner;

public class UserController {
    private final UserRepository userRepository = new UserRepository();
    private final UserService userService = new UserService(userRepository);
    private final Scanner input;

    public UserController(Scanner input){
        this.input = input;
    }

    public void signupController(){
        String[] userInputs = {"", "", ""};

        while(userInputs[0].length() < 2) {
            System.out.println("\n\n Username (Min. 2 Characters required): ");
            userInputs[0] = this.input.nextLine();
        }

        boolean validEmail = false;
        while(!validEmail){
            System.out.println("\n\n Email Address : ");
            userInputs[1] = this.input.next();
            this.input.nextLine();

            validEmail = ValidatorService.emailValidator(userInputs[1]);
            if (!validEmail) System.out.println("\nInvalid email address\n");
        }

        while(userInputs[2].length() < 8){
            System.out.println("\n\n Password (Min. 8 Characters): ");
            userInputs[2] = this.input.nextLine();
        }

        userService.signup(userInputs[0], userInputs[1], userInputs[2]);
    }

    public void loginController(){
        String[] userInputs = {"", ""};

        System.out.println("\n\n Email Address : ");
        userInputs[0] = this.input.next();

        System.out.println("\n\n Password (Min. 8 Characters): ");
        userInputs[1] = this.input.nextLine();

        userService.login(userInputs[0], userInputs[1]);
    }

    public boolean isUserAuthenticated(){
        return userService.isAuthenticated();
    }


}
