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

    private String type;

    private String splitter;

    TextElementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSplitter() {
        return splitter;
    }

    public void setSplitter(String splitter) {
        this.splitter = splitter;
    }
}
