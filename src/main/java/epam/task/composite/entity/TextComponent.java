package epam.task.composite.entity;

import java.util.List;

public interface TextComponent {

    void addElement(TextComponent textComponent);

    void removeElement(TextComponent textComponent);

    TextElementType getElementType();

    List<TextComponent>getChildren();

    String transformText();
}
