package com.example.challenge.exceptions;

import java.io.IOException;

public class ConsoleReadException extends RuntimeException {
    public ConsoleReadException(String message, IOException e) {
    }
}
