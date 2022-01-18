package src.main.com.nullway;

public class FullNameTest {
    /*
    * 我们希望返回值的检查是强制性的。如果不检查，就没有办法得到返回值指代的真实对象。
    * 实现的思路，就是使用封闭类和模式匹配。
    * 使用封闭类，返回值得种类可数，按照switch匹配模式，就会强制要求处理每一个反回值
    */
    private static boolean hasMiddleName(FullName fullName, String middleName) {
        return switch (fullName.middleName()) {
            case Returned.Undefined undefined -> false;
            case Returned.ReturnValue rv -> {
                String returnedMiddleName = (String)rv.returnValue();
                yield returnedMiddleName.equals(middleName);
            }
        };
    }

    public static void main(String[] args) {
        FullName fullName = new FullName("jian", "piye", "blnlf");
        System.out.println(hasMiddleName(fullName, "piye"));
    }
}

