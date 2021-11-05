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

class LetterParserTest {

    String actualText;
    private TextComposite textComposite;

    @BeforeEach
    void serviceMethod() throws CustomExeption {
        String filepath = "resources/Text.txt";
        actualText = TextReader.readText(filepath);

        TextParser paragraphParser = new ParagraphParser();
        textComposite = paragraphParser.parse(actualText);
    }


    @Test
    void parse() {
        TextParser letterParser = new ParagraphParser();
        TextComposite actual = letterParser.parse(actualText);
        assertEquals(actual.getChildren().size(),4);
    }

    @Test
    void parseParagraph(TextComponent component) {
        TextParser letterParser = new SentenceParser();
        TextComposite actual = letterParser.parse(component.transformText());
        assertEquals(actual.getChildren().size(),2);
    }

    @Test
    void parseSentence(TextComponent component) {
        TextParser letterParser = new LexemeParser();
        TextComposite actual = letterParser.parse(component.transformText());
        assertEquals(actual.getChildren().size(),26);
    }
}