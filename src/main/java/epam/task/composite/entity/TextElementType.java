package epam.task.composite.entity;

public enum TextElementType {
    PARAGRAPH("\n\t"),
    SENTENCE(""),
    LEXEME(" "),
    WORD(""),
    LETTER(""),
    SYMBOL(""),
    EXPRESSION("");

    private String delimiter;
    private String type;

    TextElementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
