package impls;

import interfaces.SerializationOperation;
import java.nio.charset.StandardCharsets;

public class StringSerializer implements SerializationOperation<String> {
    public int size(String entry) {
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        return entry.getBytes(StandardCharsets.UTF_8).length;
    }

    public Class<String> getSerializeClass() {
        return String.class;
    }

    public String deSerialize(byte[] bytes, int offset, int length) {
        if (bytes == null || offset < 0 || length <= 0) {
            throw new IllegalArgumentException();
        }
        return new String(bytes, offset, length, StandardCharsets.UTF_8);
    }

    public void serialize(String entry, byte[] bytes, int offset, int length) {
        if (entry == null || bytes == null || offset < 0 || length <= 0) {
            throw new IllegalArgumentException();
        }
        byte[] strBytes = entry.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(strBytes,0, bytes, offset, strBytes.length);
    }
}
