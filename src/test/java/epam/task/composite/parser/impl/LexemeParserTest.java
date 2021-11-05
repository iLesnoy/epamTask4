package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomExeption;
import epam.task.composite.parser.TextParser;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LexemeParserTest {

    String actualText;
    private TextComposite textComposite;

    @BeforeEach
    void serviceMethod() throws CustomExeption {
        String filepath = "resources/Text.txt";
        actualText = TextReader.readText(filepath);

        ParagraphParser paragraphParser = new ParagraphParser();
        textComposite = paragraphParser.parse(actualText);
    }

    @Test
    void parse(TextComponent textComponent) {
        TextParser paragraph = new ParagraphParser();
        textComposite = paragraph.parse(textComponent.transformText());

        assertEquals(124,textComposite.getChildren().size());

    }
}