package interfaces;

public interface SerializationOperation<T> extends Serializer<T>,DeSerializer<T> {
    /**
     * 计算对象序列化后的长度，主要用于申请存放序列化数据的字节数组
     * @param entry 待序列化的对象
     * @return 对象序列化后的长度
     */
    int size(T entry);

    /**
     * 返回序列化对象类型的Class对象。
     */
    Class<T> getSerializeClass();
}
