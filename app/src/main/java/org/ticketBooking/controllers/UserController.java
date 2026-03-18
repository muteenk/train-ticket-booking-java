package org.ticketBooking.controllers;

import org.ticketBooking.repository.UserRepository;
import org.ticketBooking.services.UserService;
import org.ticketBooking.utils.InputUtil;
import org.ticketBooking.utils.ValidatorUtil;

import java.util.HashMap;
import java.util.Scanner;

public class UserController {
    private final UserRepository userRepository = new UserRepository();
    private final UserService userService = new UserService(userRepository);
    private final Scanner input;

    public UserController(Scanner input){
        this.input = input;
    }

    public void signupController(){
        HashMap<String, String> inputs = new HashMap<>();

        inputs.put("username", InputUtil.validatedStrInput(
                "Username (Min. 2 Characters required)",
                (input) -> input.length() >= 2
        ));
        inputs.put("email", InputUtil.validatedSingleStrInput(
                "Email Address",
                ValidatorUtil::emailValidator
        ));
        inputs.put("password", InputUtil.validatedStrInput(
                "Password (Min. 8 Characters)",
                (input) -> input.length() >= 8
        ));

        userService.signup(
                inputs.get("username"),
                inputs.get("email"),
                inputs.get("password")
        );
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
