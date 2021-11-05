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
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
      textComponents.remove(textComponent);
    }

    @Override
    public TextElementType getElementType() {
        return elementType;
    }

    @Override
    public List<TextComponent> getChildren() {
        return List.copyOf(textComponents);
    }

    @Override
    public String transformText() {
        StringBuilder sb = new StringBuilder();
        String delimiter = elementType.getDelimiter();
        for (TextComponent textComponent : textComponents) {
            sb.append(textComponent.toString()).append(delimiter);
        }
        return sb.toString();
    }
}
