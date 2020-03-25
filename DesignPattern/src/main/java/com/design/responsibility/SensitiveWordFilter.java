package com.design.responsibility;

public class SensitiveWordFilter implements WordFilter {
    @Override
    public boolean doFilter(String word) {
        // 模拟过滤敏感词汇
        return !"政府".equals(word);
    }
}
