package src.main.com.shape;

public sealed interface Shape permits Shape.Circle, Shape.Rectangle, Shape.Square {
    /**
    * @since 1.0
    */
    record Circle(double radius) implements Shape {
        // blank
    }

    /**
    * @since 1.0
    */
    record Square(double side) implements Shape {
        // blank
    }

    /**
    * @since 2.0
    */
    record Rectangle(double length, double width) implements Shape {
        // blank
    }
}