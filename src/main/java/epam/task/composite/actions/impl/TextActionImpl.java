package epam.task.composite.actions.impl;

import epam.task.composite.actions.TextAction;
import epam.task.composite.comparator.ParagraphComparator;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;
import epam.task.composite.entity.TextElementType;

import java.util.List;

public class TextActionImpl implements TextAction {


    @Override
    public List<TextComponent> paragraphSort(TextComposite textComposite) {
        return textComposite.getChildren().stream().sorted(new ParagraphComparator()).toList();
    }

    @Override
    public List<TextComponent> longestWordSentence(TextComposite textComposite) {
        return null;
    }

    @Override
    public List<TextComponent> deleteSentences(TextComposite textComposite, int number) {
        return textComposite.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .toList().stream()
                .filter(s -> s.getChildren().stream()
                        .filter(l -> l.getElementType().equals(TextElementType.WORD)).count() >= number).toList();
    }

    @Override
    public Integer identicalWords(TextComponent component) {
        return null;
    }

    @Override
    public Integer vowelsAndConsonants(TextComponent textComponent) {
        return null;
    }
}
