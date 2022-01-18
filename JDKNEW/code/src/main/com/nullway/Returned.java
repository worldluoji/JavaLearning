package src.main.com.nullway;

public sealed interface Returned<T> {
    Returned.Undefined UNDEFINED = new Undefined();

    record ReturnValue<T>(T returnValue) implements Returned {
    }

    record Undefined() implements Returned {
    }
}