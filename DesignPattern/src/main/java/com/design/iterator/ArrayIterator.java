package com.design.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> arrayList;
    public ArrayIterator(ArrayList arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        this.arrayList = arrayList;
        this.cursor = 0;
    }
    @Override
    public boolean hasNext() {
        return cursor < arrayList.size();
    }

    @Override
    public E next() {
        return arrayList.get(cursor++);
    }

    @Override
    public E currentItem() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }
}
