package com.design.combine;

import java.io.File;

public class SingleFile extends FileSystemNode {
    public SingleFile(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        File f = new File(path);
        if (!f.exists()) {
            return 0;
        }
        return f.length();
    }
}
