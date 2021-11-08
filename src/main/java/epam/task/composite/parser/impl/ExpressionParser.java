package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;

public class ExpressionParser implements TextParser {

    private static final TextParser letterParser = new LetterParser();

    @Override
    public TextComposite parse(String text) {

        TextComposite expressionComposite = new TextComposite(TextElementType.EXPRESSION);
        TextComponent expressionComponent = letterParser.parse(text);
        expressionComposite.add(expressionComponent);

        return expressionComposite;
    }
}
