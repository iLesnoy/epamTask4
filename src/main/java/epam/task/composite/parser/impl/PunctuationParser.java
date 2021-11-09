package epam.task.composite.parser.impl;

import epam.task.composite.entity.Element;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationParser implements TextParser {

    private static final String PUNCTUATION_REGEX = "(\\p{Punct})";

    @Override
    public TextComposite parse(String text) {

        TextComposite punctuationComposite = new TextComposite(TextElementType.PUNCTUATION);
        Pattern pattern = Pattern.compile(PUNCTUATION_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            String word = matcher.group();
            TextComponent punctComponent = new Element(TextElementType.PUNCTUATION, word.charAt(0));
            System.out.println(punctComponent);
            punctuationComposite.addElement(punctComponent);
        }
        return punctuationComposite;
    }
}
