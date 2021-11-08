package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomException;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunctuationParserTest {

    private String actualText;
    private TextComposite textComposite;

    @BeforeEach
    void ServiceFilereading() throws CustomException {
        String filepath = "resources/Text.txt";
        actualText = TextReader.readText(filepath);
    }

    @Test
    void parse() {
        PunctuationParser punctuationParser = new PunctuationParser();
        textComposite = punctuationParser.parse(actualText);
        assertEquals(28,textComposite.getChildren().size());

    }
}