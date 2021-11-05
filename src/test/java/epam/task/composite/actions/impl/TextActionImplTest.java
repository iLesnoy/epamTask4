package epam.task.composite.actions.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomExeption;
import epam.task.composite.parser.TextParser;
import epam.task.composite.parser.impl.ParagraphParser;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextActionImplTest {

    TextActionImpl textAction;
    TextComposite textComposite;
    String filepath = "resources/Text.txt";

    @BeforeEach
    void serviceMethod() throws CustomExeption {
        String actualText =  TextReader.readText(filepath);
        TextParser textParser = new ParagraphParser();
        textComposite = textParser.parse(actualText);
        textAction = new TextActionImpl();
    }

    @Test
    void paragraphSort() {
        List<TextComponent> expectedSort = textAction.paragraphSort(textComposite);
        int actual = expectedSort.get(0).getChildren().size();
        assertEquals(actual,1);
    }

    @Test
    void longestWordSentence() {
    }

    @Test
    void deleteSentences() {
        List<TextComponent> sentences = textAction.deleteSentences(textComposite,2);
        int expected = sentences.size();
        assertEquals(4,expected);
    }

    @Test
    void identicalWords() {
    }

    @Test
    void vowelsAndConsonants() {
    }
}