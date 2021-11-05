package epam.task.composite.actions;

import epam.task.composite.entity.TextComponent;
import epam.task.composite.entity.TextComposite;

import java.util.List;

public interface TextAction {

    List<TextComponent>paragraphSort(TextComposite textComposite);
    List<TextComponent>longestWordSentence(TextComposite textComposite);
    List<TextComponent>deleteSentences(TextComposite textComposite,int number);
    Integer identicalWords(TextComponent component );
    Integer vowelsAndConsonants(TextComponent textComponent);


}
