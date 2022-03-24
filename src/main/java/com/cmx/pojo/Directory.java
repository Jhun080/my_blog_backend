package com.cmx.pojo;

import java.util.List;

/**
 * 用于记录七牛云文件目录信息
 */
public class Directory {
    private String mainDirectory;//主目录
    private List<String> childrenDirectory;//子目录

    public Directory(String mainDirectory, List<String> childrenDirectory) {
        this.mainDirectory = mainDirectory;
        this.childrenDirectory = childrenDirectory;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "mainDirectory='" + mainDirectory + '\'' +
                ", childrenDirectory=" + childrenDirectory +
                '}';
    }

    public String getMainDirectory() {
        return mainDirectory;
    }

    public void setMainDirectory(String mainDirectory) {
        this.mainDirectory = mainDirectory;
    }

    public List<String> getChildrenDirectory() {
        return childrenDirectory;
    }

    public void setChildrenDirectory(List<String> childrenDirectory) {
        this.childrenDirectory = childrenDirectory;
    }

    public Directory() {
    }
}
