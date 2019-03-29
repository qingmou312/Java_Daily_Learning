package com.github.qingmou312.everything.core.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件类型
 * Author:lidan
 * Created:2019/3/16
 */
public enum FileType {
    IMG("png", "jepg", "jpe", "gif", "jpg"),
    DOC("ppt", "docx", "pptx", "doc", "pdf"),
    BIN("exe", "sh", "jar", "msi"),
    ARTHIVE("zip", "rar"),
    OTHER("*");

    private Set<String> extend = new HashSet<>();//对应的文件类型的扩展名集合

    FileType(String... extend) {//可变参数
        this.extend.addAll(Arrays.asList(extend));
    }

    //根据文件的扩展名获取文件类型
    public static FileType lookupByExtend(String extend) {
        for (FileType fileType : FileType.values()) {
            if (fileType.extend.contains(extend)) {
                return fileType;
            }
        }
        return FileType.OTHER;
    }

    //根据文件类型获取文件扩展名
    public static FileType lookupByName(String name) {
        for (FileType fileType : FileType.values()) {
            if (fileType.name().equals(name)) {
                return fileType;
            }
        }
        return FileType.OTHER;
    }
}
