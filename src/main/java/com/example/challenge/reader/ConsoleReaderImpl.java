package com.example.challenge.reader;

import java.util.Scanner;

/**
 * @author German Magana
 * <p>
 * This class is to read data from the console
 */
public class ConsoleReaderImpl implements ConsoleReader {

    /**
     * This method creates scanner object to read data from the console
     *
     * @return
     */
    @Override
    public Scanner createScanner() {
        return new Scanner(System.in);
    }
}
