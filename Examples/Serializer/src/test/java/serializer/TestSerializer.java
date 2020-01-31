package serializer;
import impls.StringSerializer;
import org.junit.Test;

public class TestSerializer {
    @Test
    public void test() {
        StringSerializer serializer = new StringSerializer();
        String str = "Hello World!!!";
        byte[] bytes = new byte[100];
        serializer.serialize(str, bytes, 0 , bytes.length);
        int len = serializer.size(str);
        System.out.println("序列化后长度为" + len);
        String deStr = serializer.deSerialize(bytes, 0 , len);
        System.out.println("反序列化后的字符串为" + deStr);
    }
}
