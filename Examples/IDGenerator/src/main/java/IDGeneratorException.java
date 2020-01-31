public class IDGeneratorException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public IDGeneratorException(String msg) {
        super(msg);
    }

    public IDGeneratorException() {
        super();
    }

}