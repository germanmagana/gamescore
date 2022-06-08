package com.example.challenge;

import com.example.challenge.reader.FileReader;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class FileReaderTest {

    @Test
    void shouldReadTxtFile() throws FileNotFoundException {
        List<String> lines = FileReader.read("src/test/resources/matches-test.txt");
        Assertions.assertTrue(CollectionUtils.isNotEmpty(lines));
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {

        FileNotFoundException fileNotFoundException =
            Assertions.assertThrows(FileNotFoundException.class, () -> {
                List<String> lines = FileReader.read("src/test/resources/matches");
            });

        Assertions.assertEquals(
            "src\\test\\resources\\matches (The system cannot find the file specified)",
            fileNotFoundException.getMessage());
    }
}
