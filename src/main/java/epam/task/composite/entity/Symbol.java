package epam.task.composite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;


public class Symbol implements TextComponent{

    private static final Logger logger = LogManager.getLogger(Symbol.class);
    private TextElementType elementType;
    private char symbol;

    public Symbol() {
    }

    public Symbol(TextElementType elementType, char symbol) {
        this.elementType = elementType;
        this.symbol = symbol;
    }

    @Override
    public void addElement(TextComponent textComponent) {
        logger.error("Unsupported add operation with symbol");
        throw new UnsupportedOperationException("Unsupported add operation with symbol");
    }

    @Override
    public void removeElement(TextComponent textComponent) {
        logger.error("Unsupported remove operation with symbol");
        throw new UnsupportedOperationException("Unsupported remove operation with symbol");
    }

    @Override
    public TextElementType getElementType() {
        logger.error("Unsupported getElementType operation with symbol");
        throw new UnsupportedOperationException("Unsupported getElementType operation with symbol");
    }

    @Override
    public List<TextComponent> getChildren() {
        logger.error("Unsupported getChildren operation with symbol");
        throw new UnsupportedOperationException("Unsupported getChildren operation with symbol");
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol && Objects.equals(elementType, symbol1.elementType);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (elementType != null ? elementType.hashCode() : 0);
        result = 31 * result + Character.hashCode(symbol);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

}
