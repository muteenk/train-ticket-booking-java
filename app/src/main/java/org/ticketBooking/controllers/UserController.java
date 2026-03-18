package org.ticketBooking.controllers;

import org.ticketBooking.entities.User;
import org.ticketBooking.services.UserService;
import org.ticketBooking.utils.InputUtil;
import org.ticketBooking.utils.ValidatorUtil;

import java.util.HashMap;
import java.util.Optional;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
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
        HashMap<String, String> inputs = new HashMap<>();
        inputs.put("email", InputUtil.strInput("Email Address"));
        inputs.put("password", InputUtil.strInput("Password"));

        userService.login(inputs.get("email"), inputs.get("password"));
    }

    public void profileController(){
        Optional<User> userOptional = userService.getAuthenticatedUser();
        if (userOptional.isEmpty()){
            System.out.println("\n\nUSER NOT LOGGED IN!\n\n");
            return;
        }
        User user = userOptional.get();
        System.out.println("\nPROFILE DETAILS: \n");
        System.out.printf("- Username: %s\n- Email Address: %s\n\n", user.getUsername(), user.getEmail());
    }

    public boolean isUserAuthenticated(){
        return userService.isAuthenticated();
    }


}
