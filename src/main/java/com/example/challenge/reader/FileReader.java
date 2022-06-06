package com.example.challenge.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author German Magana
 *
 * This class reads any file and prints out the data on the console
 */
public class FileReader {

    public static void printWelcome(String fileName) {

        try {

            File myObj = new File(fileName);

            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
