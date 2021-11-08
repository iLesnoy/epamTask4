package epam.task.composite.comparator;

import epam.task.composite.entity.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {

    @Override
    public int compare(TextComponent paragraph1, TextComponent paragraph2) {
        return Integer.compare(paragraph1.getChildren().size(), paragraph2.getChildren().size());
    }
}
