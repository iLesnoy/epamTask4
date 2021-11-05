package epam.task.composite.entity;

import java.util.List;

public interface TextComponent {

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    TextElementType getElementType();

    List<TextComponent>getChildren();

    String transformText();

}
