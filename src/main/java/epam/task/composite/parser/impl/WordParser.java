package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;

public class WordParser implements TextParser {

    private final TextParser letter = new LetterParser();

    @Override
    public TextComposite parse(String text) {

        TextComposite wordComposite = new TextComposite(TextElementType.WORD);
        TextComponent textComponent = letter.parse(text);
        wordComposite.addElement(textComponent);

        return wordComposite;
    }
}
