package epam.task.composite.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextCompositeTest {

    TextComposite letterComposite = new TextComposite(TextElementType.LETTER);
    TextComponent letterComponent;

    @Test
    @BeforeEach
    void add(){
        letterComponent = new TextComposite(TextElementType.LETTER);
        int sizeBeforeAdd = letterComposite.getChildren().size();
        letterComponent.add(letterComponent);
        assertNotEquals(letterComponent.getChildren().size(),sizeBeforeAdd);
    }


    @Test
    void remove() {
        letterComponent.remove(letterComponent);
        assertTrue(letterComponent.getChildren().isEmpty());
    }

    @Test
    void getElementType() {
        String actual = letterComponent.getElementType().toString();
        String expectedElemType = "LETTER";
        assertEquals(expectedElemType, actual);
    }

    @Test
    void getChildren() {
        List<TextComponent> actualChildrenList = letterComponent.getChildren();
        assertEquals(1, actualChildrenList.size());

    }
}