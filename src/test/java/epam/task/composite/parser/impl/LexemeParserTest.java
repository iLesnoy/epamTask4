package epam.task.composite.parser.impl;


import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomException;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LexemeParserTest {

    private String actualText;
    private TextComposite textComposite;

    @BeforeEach
    void ServiceFilereading() throws CustomException {
        String filepath = "resources/Text.txt";
        actualText = TextReader.readText(filepath);
    }


    @Test
    @DisplayName("LexemeParser")
    void lexemeParse() {
        LexemeParser lexemeParser = new LexemeParser();
        textComposite = lexemeParser.parse(actualText);
        assertEquals(91,textComposite.getChildren().size());

    }
}