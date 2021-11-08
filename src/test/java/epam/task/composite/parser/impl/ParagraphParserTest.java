package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomException;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ParagraphParserTest {

    private String actualText;
    private TextComposite textComposite;

    @BeforeEach
    void ServiceFilereading() throws CustomException {
        String filepath = "resources/Text.txt";
        actualText = TextReader.readText(filepath);
    }


    @Test
    @DisplayName("LexemeParser")
    void paragraphParse(){
        ParagraphParser paragraphParser = new ParagraphParser();
        textComposite = paragraphParser.parse(actualText);
        assertEquals(textComposite.getChildren().size(),4);
    }
}