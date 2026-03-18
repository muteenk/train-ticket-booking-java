package org.ticketBooking.controllers;

import org.ticketBooking.repository.UserRepository;
import org.ticketBooking.services.UserService;
import org.ticketBooking.utils.InputUtil;
import org.ticketBooking.utils.ValidatorUtil;

import java.util.HashMap;

public class UserController {
    private final UserRepository userRepository = new UserRepository();
    private final UserService userService = new UserService(userRepository);

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

    public boolean isUserAuthenticated(){
        return userService.isAuthenticated();
    }


}
