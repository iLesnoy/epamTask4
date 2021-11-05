package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomExeption;
import epam.task.composite.parser.TextParser;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParagraphParserTest {

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
        TextParser sentenceParser = new SentenceParser();
        TextComposite afterSentenceParce = sentenceParser.parse(textComponent.transformText());
        assertEquals(2,afterSentenceParce.getChildren().size());
    }
}