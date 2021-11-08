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
        return textComponents.stream().toList();
    }

    @Override
    public String transformText() {
        StringBuilder string = new StringBuilder();
        String split = elementType.getSplitter();
        for (TextComponent textComponent : textComponents) {
            string.append(textComponent).append(split);
        }
        return string.toString();
    }
}
