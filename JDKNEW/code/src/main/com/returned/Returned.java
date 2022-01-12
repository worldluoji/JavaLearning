package src.main.com.returned;


public sealed interface Returned<T> {
    record ReturnValue<T>(T returnValue) implements Returned {
    }
    
    record ErrorCode(Integer errorCode) implements Returned {
    }
}    