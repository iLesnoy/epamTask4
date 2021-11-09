package epam.task.composite.action;

import epam.task.composite.entity.TextComponent;

import java.util.List;

public interface TextAction {

    List<TextComponent>paragraphSort(TextComponent textComposite);

    int longestWord(TextComponent component);
    List<TextComponent>longestWordSentence(TextComponent textComposite);

    List<TextComponent>deleteSentences(TextComponent textComposite,int number);
    int sameWordsCount(TextComponent component);
    long vowelsCount(TextComponent component);
    long consonantsCount(TextComponent component);


}
