package com.github.qingmou312.everything.core.common;

import com.github.qingmou312.everything.core.model.FileType;
import com.github.qingmou312.everything.core.model.Thing;

import java.io.File;

/**
 * 将file对象转换成thing对象
 * Author:lidan
 * Created:2019/3/19
 */
public final class FileConvertThing {
    private FileConvertThing() {
    }

    public static Thing convert(File file) {
        Thing thing = new Thing();
        thing.setName(file.getName());
        thing.setPath(file.getAbsolutePath());
        thing.setDepth(computeFileDepth(file));
        thing.setFileType(computeFileType(file));
        return thing;
    }

    private static int computeFileDepth(File file) {
        String[] segments = file.getAbsolutePath().split("\\\\");
        return segments.length;
    }

    private static FileType computeFileType(File file) {
        if (file.isDirectory()) {
            return FileType.OTHER;
        }
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        if (index != -1 && index < fileName.length() - 1) {
            String extend = fileName.substring(index + 1);
            return FileType.lookup(extend);
        } else {
            return FileType.OTHER;
        }
    }
}
