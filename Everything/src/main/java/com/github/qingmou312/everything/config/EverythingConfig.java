package com.github.qingmou312.everything.config;

import lombok.Getter;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:lidan
 * Created:2019/3/19
 */

@Getter
public class EverythingConfig {
    private static volatile EverythingConfig config;

    //建立索引的路径
    private Set<String> includePath = new HashSet<>();

    //排除索引文件的路径
    private Set<String> excludePath = new HashSet<>();

    //TODO 可配置的参数会在这里体现

    //H2数据库文件路径
    private String h2IndexPath = System.getProperty("user.dir") + File.separator + "Everything";

    private EverythingConfig() {
    }


    private void initDefaultPathConfig() {
        //获取文件系统
        FileSystem fileSystem = FileSystems.getDefault();

        //遍历的目录
        Iterable<Path> iterable = fileSystem.getRootDirectories();
        iterable.forEach(path -> config.getIncludePath().add(path.toString()));

        //排除的目录
        //Windows: C:\Windows C:\Program Files(x86)  C:\Program Files  C:\ProgramData
        //Linux:/tmp/etc/
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            config.getExcludePath().add("C:\\Windows");
            config.getExcludePath().add("C:\\Program Files(x86)");
            config.getExcludePath().add("C:\\Program Files");
            config.getExcludePath().add("C:\\ProgramData");
        } else {
            config.getExcludePath().add("/tmp");
            config.getExcludePath().add("/etc");
            config.getExcludePath().add("/root");

        }

    }

    public static EverythingConfig getInstance() {
        if (config == null) {
            synchronized (EverythingConfig.class) {
                if (config == null) {
                    config = new EverythingConfig();
                    config.initDefaultPathConfig();
                }
            }
        }
        return config;
    }
}
