package assignment6;

import java.util.InputMismatchException;

//Custom exception class for input mismatches
public class CustomInputMismatchException extends Exception {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}