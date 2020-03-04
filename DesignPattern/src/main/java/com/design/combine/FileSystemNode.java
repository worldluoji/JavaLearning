package com.design.combine;

public abstract class FileSystemNode {
    protected String path;
    public FileSystemNode(String path) {
        this.path = path;
    }

    /**
    * 计算当前路径下有多少个文件
    * */
    public abstract int countNumOfFiles();
    /**
    * 计算当前路径下的文件占用多少字节
    * */
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
