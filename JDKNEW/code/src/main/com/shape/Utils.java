package src.main.com.shape;
public class Utils {
    
    /**
    * 判断是否是正方形
    */
    public static boolean isSquare(Shape shape) {
        if (shape instanceof Shape.Rectangle rect) {
            return (rect.length() == rect.width());
        }
        return (shape instanceof Shape.Square);
    }

    /**
     * 展示了如何使用具有模式匹配能力的 switch，来判断一个对象是不是正方形
     * 具有模式匹配能力的 switch，提升了 switch 的数据类型匹配能力。
     * switch 要匹配的数据，现在可以是整形的原始类型（数字、枚举、字符串），或者引用类型。
     */
    
    public static boolean isSquareNew(Shape shape) {
        // switch 表达式需要穷举出所有的情景
        /*
        * 如果使用 switch 的处理方式，每一个情景，也要至少对应一个 case 语句。
        * 但是，寻找匹配情景时，switch 并不需要按照 case 语句的顺序执行。
        * 对于 switch 的处理方式，找到匹配的情景的时间复杂度是 O(1)。
        * 也就是说，switch 寻找匹配情景的时间复杂度和需要处理的情景数量关系不大。
        *
        * 一般来说，只有我们能够确信，待匹配类型的升级，不会影响 switch 表达式的逻辑的时候，
        * 我们才能考虑使用缺省选择情景
        *
        * 注：switch 的模式匹配这个特性，在 JDK 17 还是预览版。
        * 你可以现在开始学习这个特性，但是暂时不要把它用在严肃的产品里，直到正式版发布。
        */
        return switch (shape) {
            case null, Shape.Circle c -> false;
            case Shape.Square s -> true;
            case Shape.Rectangle s -> (s.length() == s.width()); 
        };
    }
}
