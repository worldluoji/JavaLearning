package com.design.responsibility;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WordFilterChain {
    private List<WordFilter> filters = new ArrayList<>();
    public void addFilter(WordFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("filter不能为空");
        }
        filters.add(filter);
    }
    public boolean filter(String content) {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        for (WordFilter filter : filters) {
            if (!filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
}
