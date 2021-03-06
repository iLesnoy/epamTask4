package epam.task.composite.parser.impl;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;
import epam.task.composite.parser.TextParser;


public class ParagraphParser implements TextParser {

    private static final String PARAGRAPH_REGEX = "\\n";
    private final TextParser sentenceParser = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(TextElementType.PARAGRAPH);
        String[] paragraphs = text.split(PARAGRAPH_REGEX);

        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = sentenceParser.parse(paragraph);
            paragraphComposite.addElement(paragraphComponent);
        }

        return paragraphComposite;
    }
}
