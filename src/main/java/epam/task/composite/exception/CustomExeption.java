package epam.task.composite.exception;

public class CustomExeption extends Exception{

    public CustomExeption() {
        super();
    }

    public CustomExeption(String message) {
        super(message);
    }

    public CustomExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomExeption(Throwable cause) {
        super(cause);
    }
}
