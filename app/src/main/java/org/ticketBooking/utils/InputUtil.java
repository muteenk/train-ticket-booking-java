package org.ticketBooking.utils;
import java.util.Scanner;
import java.util.function.Predicate;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // To take whole string input (including spaces)
    public static String validatedStrInput(
            String fieldName,
            Predicate<String> validationFunction
    ){
        String inputState = "";
        boolean isValidInput = false;
        while(!isValidInput){
            System.out.printf("\n\n%s : ", fieldName);
            inputState = scanner.nextLine();

            isValidInput = validationFunction.test(inputState);
            if (!isValidInput) System.out.printf("\nInvalid %s\n\n", fieldName);
        }
        return inputState;
    }

    // To take input without space
    public static String validatedSingleStrInput(
            String fieldName,
            Predicate<String> validationFunction
    ){
        String inputState = "";
        boolean isValidInput = false;
        while(!isValidInput){
            System.out.printf("\n\n%s : ", fieldName);
            inputState = scanner.next();
            scanner.nextLine();

            isValidInput = validationFunction.test(inputState);
            if (!isValidInput) System.out.printf("\nInvalid %s\n\n", fieldName);
        }
        return inputState;
    }

//    public static String singleInput(){
//
//    }
}
