package com.design.responsibility;

public class DirtyWordFilter implements WordFilter {
    @Override
    public boolean doFilter(String word) {
        // 模拟过滤脏词
        return !"尼玛".equals(word);
    }
}
