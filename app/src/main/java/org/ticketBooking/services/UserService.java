package org.ticketBooking.services;

import java.io.File;
import java.util.List;
import org.ticketBooking.entities.User;

public class UserService {
    private static final String USERS_PATH = "../datastore/users.json";
    private JsonService jsonService = new JsonService(USERS_PATH);

    private User userSession;

    public void signup(
        String fullname,
        String username,
        String email,
        String password
    ){


    }
}
