package org.ticketBooking.services;

import org.ticketBooking.controllers.UserController;

import java.util.Scanner;

public class SystemService {
    private static final Scanner input = new Scanner(System.in);
    private final UserController userController = new UserController(input);

    private void header(){
        System.out.println("\n--------------------------------");
        System.out.println("\nTRAIN TICKET BOOKING SERVICES : \n");
        System.out.println("\n--------------------------------\n\n");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void mainMenu(){
        System.out.println("[1] Profile");
        System.out.println("[2] Show Available Journeys");
    }

    private void authMenu(){
        System.out.println("[1] Signup");
        System.out.println("[2] Login");
    }

    public void printMenu(){
        this.clearScreen();
        this.header();

        System.out.println("[0] EXIT");
        if (this.userController.isUserAuthenticated()){
            this.mainMenu();
        } else {
            this.authMenu();
        }
    }

    private void authRouter(String inp){
        switch (inp) {
            case "1" -> userController.signupController();
            case "2" -> userController.loginController();
        }
    }

    private void userRouter(String inp){

    }

    public boolean serve(){
        System.out.print("Choose >>> ");
        String inp = input.next();
        input.nextLine();

        if (inp.equals("0")) return true;
        if (this.userController.isUserAuthenticated()) this.userRouter(inp);
        else this.authRouter(inp);
        return false;
    }

}
