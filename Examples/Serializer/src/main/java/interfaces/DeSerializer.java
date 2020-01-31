package interfaces;

public interface DeSerializer<T> {
    /**
     * 反序列化对象
     * @param bytes 存放序列化数据的字节数组
     * @param offset 数组的偏移量，从这个位置开始写入序列化数据
     * @param length 对象序列化后的长度
     * @return 反序列化之后生成的对象
     */
    T deSerialize(byte[] bytes, int offset, int length);
}
