package com.basictype;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
* BigDecimal 有 scale 和 precision 的概念，scale 表示小数点右边的位数，而 precision 表示精度，也就是有效数字的长度
* */
public class BigDecimalDemo {
    public static void main(String[] args) {
        // 使用 BigDecimal 表示和计算浮点数，且务必使用字符串的构造方法来初始化 BigDecimal
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("1.00");
        //如果一定要用 Double 来初始化 BigDecimal 的话，可以使用 BigDecimal.valueOf 方法，以确保其表现和字符串形式的构造方法一致，这也是官方文档更推荐的方式
        BigDecimal b3 = BigDecimal.valueOf(1.0);
        // 如果我们希望只比较 BigDecimal 的 value，可以使用 compareTo 方法
        System.out.println(b1.equals(b2));
        System.out.println(b1.compareTo(b2) == 0);
        System.out.println(b1.equals(b3));


        // 即使通过 DecimalFormat 来精确控制舍入方式，double 和 float 的问题也可能产生意想不到的结果
        // 所以浮点数避坑第二原则：浮点数的字符串格式化也要通过 BigDecimal 进行。
        double num1 = 3.35;
        float num2 = 3.35f;
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.DOWN); // 使用舍入方式
        System.out.println(format.format(num1));
        format.setRoundingMode(RoundingMode.DOWN);
        System.out.println(format.format(num2));
    }
}
