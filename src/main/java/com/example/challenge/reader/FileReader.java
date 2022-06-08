package com.example.challenge.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author German Magana
 * <p>
 * This class reads any file and prints out the data on the console
 */
final public class FileReader {

    private FileReader() {
    }

    public static List<String> read(String fileName) throws FileNotFoundException {

        List<String> lines = new ArrayList<>();

        File myObj = new File(fileName);

        Scanner myReader = new Scanner(myObj);

        try {
            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
        } finally {
            if (Objects.nonNull(myReader)) {
                myReader.close();
            }
        }

        return lines;
    }


}
