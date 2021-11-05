package epam.task.composite.comparator;

import epam.task.composite.entity.TextComponent;

import java.util.Comparator;
import java.util.List;

public class ParagraphComparator implements Comparator<TextComponent> {

    @Override
    public int compare(TextComponent component1, TextComponent component2) {
        return Integer.compare(component1.getChildren().size(), component2.getChildren().size());
    }
}
