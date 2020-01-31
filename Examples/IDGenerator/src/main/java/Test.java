public class Test {
    public static void main(String[] args) {
        IDGenerator generator = new RandomIDGenerator();
        System.out.println(generator.generate());
    }
}