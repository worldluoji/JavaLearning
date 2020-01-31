package exceptions;

public class SerializeException extends RuntimeException {
    public SerializeException() {
        super();
    }
    public SerializeException(String msg) {
        super(msg);
    }
}
