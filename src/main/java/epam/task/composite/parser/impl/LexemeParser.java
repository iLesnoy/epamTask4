package epam.task.composite.parser.impl;

import epam.task.composite.entity.Symbol;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextParser {

    private static final String LEXEME_REGEX = "\\S+";
    private static final String WORD_REGEX = "[a-zA-ZА-я\\w]+";
    private static final TextParser wordParser = new WordParser();
    private static final TextParser expParser = new ExpressionParser();

    @Override
    public TextComposite parse(String text) {

        TextComposite lexemeComposite = new TextComposite(TextElementType.LEXEME);
        Pattern pattern = Pattern.compile(LEXEME_REGEX);
        Matcher lexemes = pattern.matcher(text);

        while (lexemes.find()) {
            String lexeme = lexemes.group();
            if (lexeme.matches(WORD_REGEX)) {
                TextComponent word = wordParser.parse(lexeme);
                lexemeComposite.addElement(word);
            } else {
                String almostWord = lexeme.substring(0, lexeme.length() - 1);
                if (lexeme.matches(WORD_REGEX)) {

                    TextComponent wordComponent = wordParser.parse(almostWord);
                    lexemeComposite.addElement(wordComponent);
                    lexemeComposite.addElement(new Symbol(TextElementType.LEXEME, lexeme.charAt(almostWord.length())));

                }

            }
        }
        return lexemeComposite;
    }
}
