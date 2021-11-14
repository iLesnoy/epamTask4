package epam.task.composite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private TextElementType elementType;
    private final List<TextComponent> textComponents = new ArrayList<>();


    public TextComposite() {
    }

    public TextComposite(TextElementType element) {
        this.elementType = element;
    }

    @Override
    public void addElement(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void removeElement(TextComponent textComponent) {
      textComponents.remove(textComponent);
    }

    @Override
    public TextElementType getElementType() {
        return elementType;
    }

    @Override
    public List<TextComponent> getChildren() {
        return textComponents.stream().toList();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (TextComponent textComponent : textComponents) {
            string.append(textComponent).append(elementType.getSplitter());
        }
        return string.toString();
    }
}
