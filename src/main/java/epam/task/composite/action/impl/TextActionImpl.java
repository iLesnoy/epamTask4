package epam.task.composite.action.impl;

import epam.task.composite.action.TextAction;
import epam.task.composite.comparator.ParagraphComparator;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextElementType;

import java.util.*;
import java.util.stream.Collectors;

public class TextActionImpl implements TextAction {


    private static final String VOWELS_REGEX = "^(?i:[aeiouy]).*";
    private static final String CONSONANTS_REGEX = "(?iu)[a-zа-я&&[^aeiouyаеёионыэюя]]";

    @Override
    public List<TextComponent> paragraphSort(TextComponent textComposite) {
        return textComposite.getChildren().stream()
                .sorted(new ParagraphComparator()).toList();
    }


    @Override
    public List<TextComponent> longestWordSentence(TextComponent component) {
        int maxLength = longestWord(component);
        return component.getChildren().stream()
                .flatMap(p -> p.getChildren().stream()).toList().stream()
                .filter(s -> s.getChildren().stream()
                        .anyMatch(l -> l.getElementType().equals(TextElementType.WORD) && l.toString().length() == maxLength))
                .toList();
    }

    public int longestWord(TextComponent component){
        TextComponent textComponent = component.getChildren().stream().flatMap(a -> a.getChildren().stream())
                .toList().stream().flatMap(b->b.getChildren().stream()).toList().stream()
                .filter(n->n.getElementType().equals(TextElementType.WORD)).toList()
                .stream().max(Comparator.comparingInt(f->f.toString().length())).get();
        return textComponent.toString().length();
    }

    @Override
    public List<TextComponent> deleteSentences(TextComponent component, int number) {
        return component.getChildren().stream().flatMap(a -> a.getChildren().stream())
                .toList().stream().filter(b-> b.getChildren().stream()
                        .filter(d -> d.getElementType().equals(TextElementType.WORD))
                        .count() > number).toList();
    }

    @Override
    public long sameWordsCount(TextComponent component) {
        Map<String, Long> sameWords = component.getChildren().stream()
                .flatMap(a -> a.getChildren().stream())
                .flatMap(b -> b.getChildren().stream())
                .collect(Collectors.groupingBy(w -> w.toString().toLowerCase(), Collectors.counting()));
        return sameWords.entrySet().stream().filter(a->a.getValue() > 1).count();
    }

    @Override
    public long consonantsCount(TextComponent component) {
        return component.getChildren().stream()
                .flatMap(a -> a.getChildren().stream())
                .flatMap(b -> b.getChildren().stream()).filter(l -> l.toString().toUpperCase(Locale.ROOT).matches(CONSONANTS_REGEX))
                .count();
    }

    @Override
    public long vowelsCount(TextComponent component) {
        return component.getChildren().stream()
                .flatMap(a -> a.getChildren().stream())
                .flatMap(l -> l.getChildren().stream()).filter(l -> l.toString().toUpperCase(Locale.ROOT).matches(VOWELS_REGEX))
                .count();
    }
}
