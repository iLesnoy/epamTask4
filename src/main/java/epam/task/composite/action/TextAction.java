package epam.task.composite.action;

import epam.task.composite.entity.TextComponent;

import java.util.List;

public interface TextAction {

    List<TextComponent>paragraphSort(TextComponent textComposite);

    List<TextComponent>longestWordSentence(TextComponent textComposite);

    List<TextComponent>deleteSentences(TextComponent textComposite,int number);
    Integer sameWordsCount(TextComponent component);
    long vowelsCount(TextComponent textComponent);
    long consonantsCount(TextComponent textComponent);


}
