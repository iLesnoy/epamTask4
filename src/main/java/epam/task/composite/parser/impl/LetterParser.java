package epam.task.composite.parser.impl;

import epam.task.composite.entity.Element;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;

public class LetterParser implements TextParser {

    private static final String LETTER_REGEX = "";
    private static TextComponent letterComponent;

    @Override
    public TextComposite parse(String text) {

        TextComposite letterComposite = new TextComposite(TextElementType.LETTER);
        String[] symbols = text.split(LETTER_REGEX);

        for (String symbol : symbols) {
            letterComponent = new Element(TextElementType.LETTER, symbol.charAt(0));
            letterComposite.addElement(letterComponent);
        }

        return letterComposite;
    }
}
