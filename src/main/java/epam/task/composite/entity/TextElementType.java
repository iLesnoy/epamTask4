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


    private String splitter;

    TextElementType(String splitter) {
        this.splitter = splitter;
    }

    public String getSplitter() {
        return splitter;
    }

}
