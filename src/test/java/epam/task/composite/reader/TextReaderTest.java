package epam.task.composite.reader;

import epam.task.composite.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextReaderTest {

    String filepath = "resources/Text.txt";

    @Test
    void readText() throws CustomException {
        String actualText =  TextReader.readText(filepath);
        assertEquals(actualText.length(),550);
    }
}