package src.main.com.shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape.Rectangle(5, 5);
        System.out.println(Utils.isSquareNew(shape));
        shape = new Shape.Square(5);
        System.out.println(Utils.isSquareNew(shape));
        shape = new Shape.Circle(5);
        System.out.println(Utils.isSquareNew(shape));
        System.out.println(Utils.isSquareNew(null));
    }
}
