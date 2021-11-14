package epam.task.composite.action.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.exception.CustomException;
import epam.task.composite.parser.TextParser;
import epam.task.composite.parser.impl.ParagraphParser;
import epam.task.composite.reader.TextReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextActionImplTest {

    TextActionImpl textAction;
    TextComposite textComposite;
    String filepath = "resources/Text.txt";

    @BeforeEach
    void serviceMethod() throws CustomException {
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
        int expectedSentence = 1;
        List<TextComponent> list = textAction.longestWordSentence(textComposite);
        int actualSentence = list.size();
        assertEquals(expectedSentence,actualSentence);
    }

    @Test
    void deleteSentences() {
        List<TextComponent> sentences = textAction.deleteSentences(textComposite,20);
        int expected = sentences.size();
        assertEquals(1,expected);
    }

    @Test
    void sameWordsCount() {
        long sameWordsCount= textAction.sameWordsCount(textComposite);
        assertEquals(18, sameWordsCount);
    }

    @Test
    void vowelsWords() {
        assertEquals(36,textAction.vowelsCount(textComposite));
    }

    @Test
    void consonantsWords() {
        assertEquals(31,textAction.consonantsCount(textComposite),7);
    }

}