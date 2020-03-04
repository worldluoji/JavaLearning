package com.design.combine;

import java.util.ArrayList;
import java.util.List;

public class DirNode extends FileSystemNode {

    private List<FileSystemNode> nodes = new ArrayList<>();

    public DirNode(String path) {
        super(path);
    }

    public void addNode(FileSystemNode node) {
        nodes.add(node);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode node: nodes) {
            numOfFiles += node.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeOfFiles = 0;
        for (FileSystemNode node: nodes) {
            sizeOfFiles += node.countSizeOfFiles();
        }
        return sizeOfFiles;
    }
}
