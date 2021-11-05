package epam.task.composite.parser.impl;

import epam.task.composite.entity.Symbol;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;

public class LetterParser implements TextParser {

    private static final String LETTER_REGEX = "";


    @Override
    public TextComposite parse(String text) {
        TextComposite letterComposite = new TextComposite(TextElementType.LETTER);
        String[] symbols = text.split(LETTER_REGEX);
        for (String symbol : symbols) {
            TextComponent letterComponent = new Symbol(Character.isLetter(symbol.charAt(0)) ? TextElementType.LETTER : TextElementType.SYMBOL, symbol.charAt(0));
            letterComposite.add(letterComponent);
        }
        return letterComposite;
    }
}
