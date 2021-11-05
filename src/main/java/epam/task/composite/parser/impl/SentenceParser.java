package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {

    private static final String SENTENCE_REGEX = ".+?[.…?!](\\s?=|$)";
    private final TextParser lexemeParser = new LexemeParser();


    @Override
    public TextComposite parse(String text) {
        TextComposite sentenceComposite = new TextComposite(TextElementType.SENTENCE);
        Pattern sentence = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = sentence.matcher(text);

        while (matcher.find()){
            TextComponent sentenceComponent = lexemeParser.parse(matcher.group());
            sentenceComposite.add(sentenceComponent);
        }

        return sentenceComposite;
    }
}
