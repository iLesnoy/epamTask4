package epam.task.composite.entity;

public enum TextElementType {
    PARAGRAPH("\n\t"),
    SENTENCE(""),
    LEXEME("\s"),
    WORD(""),
    LETTER(""),
    SYMBOL(""),
    EXPRESSION(""),
    PUNCTUATION("");

    private String elementType;

    private String splitter;

    TextElementType(String type) {
        this.elementType = type;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getSplitter() {
        return splitter;
    }

    public void setSplitter(String splitter) {
        this.splitter = splitter;
    }
}
