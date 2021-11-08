package epam.task.composite.entity;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTest {

    TextComposite letterComposite = new TextComposite(TextElementType.LETTER);
    TextComponent letterComponent;

    @Test
    void add(){
        char a = 10;
        letterComponent = new Symbol(TextElementType.LETTER,a);
        int sizeBeforeAdd = letterComposite.getChildren().size();
        letterComponent.add(letterComponent);
        assertNotEquals(letterComponent.getChildren().size(),sizeBeforeAdd);
    }

}