package epam.task.composite.action.impl;

import epam.task.composite.action.TextAction;
import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextElementType;

import java.util.*;
import java.util.stream.Collectors;

public class TextActionImpl implements TextAction {


    private static final String VOWELS_REGEX = "(?iu:[aouieyаоэуыеяёюи])";
    private static final String CONSONANTS_REGEX = "(?iu:[b-zб-ь&&[^еёиоуыeiouy]])";

    @Override
    public List<TextComponent> paragraphSort(TextComponent textComposite) {
        return textComposite.getChildren().stream().flatMap(a -> a.getChildren().stream())
                .flatMap(a -> a.getChildren().stream()).filter(n -> n.getElementType()
                        .equals(TextElementType.SENTENCE)).toList()
                .stream().sorted(Comparator.comparingInt(b -> b.getChildren().toArray().length)).toList();
    }

    @Override
    public int longestWord(TextComponent textComposite) {
        TextComponent textComponent = textComposite.getChildren().stream().flatMap(a -> a.getChildren().stream())
                .toList().stream().flatMap(b -> b.getChildren().stream()).toList().stream()
                .filter(n -> n.getElementType().equals(TextElementType.WORD)).toList()
                .stream().max(Comparator.comparingInt(f -> f.toString().length())).get();
        return textComponent.toString().length();
    }

    @Override
    public List<TextComponent> longestWordSentence(TextComponent component) {
        int longetsWord = longestWord(component);
        return component.getChildren().stream().flatMap(p -> p.getChildren().stream())
                .toList().stream().filter(s -> s.getChildren().stream()
                .anyMatch(l -> l.getElementType().equals(TextElementType.WORD) && l.toString().length() == longetsWord)).toList();
    }

    @Override
    public List<TextComponent> deleteSentences(TextComponent component, int number) {
        return component.getChildren().stream().flatMap(a -> a.getChildren().stream())
                .toList().stream().filter(b -> b.getChildren().stream()
                        .filter(d -> d.getElementType().equals(TextElementType.WORD))
                        .count() > number).toList();
    }

    @Override
    public int sameWordsCount(TextComponent component) {
        Map<String, Long> resultMap = component.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .toList().stream().filter(l -> l.getElementType().equals(TextElementType.WORD))
                .collect(Collectors.groupingBy(w -> w.toString().toLowerCase(), Collectors.counting()));
        resultMap.entrySet().removeIf(w -> w.getValue() == 1);
        return resultMap.size();
    }

    @Override
    public long consonantsCount(TextComponent component) {
        return component.getChildren().stream()
                .flatMap(l -> l.getChildren().stream()).toList().stream()
                .flatMap(w -> w.getChildren().stream()).toList().stream()
                .filter(l -> l.toString().matches(CONSONANTS_REGEX)).count();
    }

    @Override
    public long vowelsCount(TextComponent component) {
        return component.getChildren().stream()
                .flatMap(l -> l.getChildren().stream()).toList().stream()
                .flatMap(w -> w.getChildren().stream()).toList().stream()
                .filter(l -> l.toString().matches(VOWELS_REGEX)).count();
    }
}
