package epam.task.composite.comparator;

import epam.task.composite.entity.TextComponent;

import java.util.Comparator;

public class SentenceComparator implements Comparator<TextComponent> {


    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}
