package com.github.qingmou312.everything.cmd;

import com.github.qingmou312.everything.config.EverythingConfig;
import com.github.qingmou312.everything.core.DAO.DataSourceFactory;
import com.github.qingmou312.everything.core.EverythingManager;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;

import java.util.List;
import java.util.Scanner;


/**
 * Author:lidan
 * Created:2019/3/15
 */
public class EverythingCmdApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //解析用户参数
        parseParams(args);

        //欢迎
        welcome();

        //统一调度器
        EverythingManager manager = EverythingManager.getInstance();

//        //启动后台清理线程
//        manager.startClearThread();

        //交互式
        interactive(manager);

    }

    private static void parseParams(String[] args) {
        EverythingConfig config = EverythingConfig.getInstance();
        /**
         * 如果用户指定的参数格式不对，使用默认值即可
         */
        for (String parm : args) {
            String maxReturnParem = "--maxReturn=";
            if (parm.startsWith(maxReturnParem)) {
                int index = parm.indexOf("=");
                String maxReturnStr = parm.substring(index + 1);
                try {
                    config.setMaxReturn(Integer.parseInt(maxReturnStr));
                } catch (NumberFormatException e) {

                }
            }
            String deptOrderByAscParem = "--deptOrderByAsc=";
            if (parm.startsWith(deptOrderByAscParem)) {
                int index = parm.indexOf("=");
                String deptOrderByAscStr = parm.substring(index + 1);
                config.setDeptOrderAsc(Boolean.parseBoolean(deptOrderByAscStr));
            }
            String includepathParem = "--includePath=";
            if (parm.startsWith(includepathParem)) {
                int index = parm.indexOf("=");
                String includepathParemStr = parm.substring(index + 1);
                String[] includePaths = includepathParemStr.split(";");
                if (includePaths.length > 0) {
                    EverythingConfig.getInstance().getIncludePath().clear();
                }
                for (String p : includePaths) {
                    config.getIncludePath().add(p);
                }
            }

            String excludePathParem = "--excludePath=";
            if (parm.startsWith(excludePathParem)) {
                int index = parm.indexOf("=");
                String excludePathParemStr = parm.substring(index + 1);
                String[] excludePaths = excludePathParemStr.split(";");
                EverythingConfig.getInstance().getIncludePath().clear();
                for (String p : excludePaths) {
                    config.getExcludePath().add(p);
                }
            }
        }

    }

    private static void interactive(EverythingManager manager) {
        while (true) {
            help();
            System.out.print("everything>>");
            String input = scanner.nextLine();
            //优先处理search
            if (input.startsWith("search")) {
                String[] values = input.split(" ");
                if (values.length >= 2) {
                    if (!values[0].equals("search")) {
                        help();
                        continue;
                    }
                    Condition condition = new Condition();
                    String name = values[1];
                    condition.setName(name);
                    if (values.length >= 3) {
                        String fileType = values[2];
                        condition.setFileType(fileType.toUpperCase());
                    }
                    search(manager, condition);
                    continue;
                } else {
                    help();
                    continue;
                }
            }
            switch (input) {
                case "help":
                    help();
                    break;
                case "quit":
                    quit();
                    break;
                case "index":
                    index(manager);
                    break;
                default:
                    help();
            }
        }
    }

    private static void search(EverythingManager manager, Condition condition) {

        condition.setLimit(EverythingConfig.getInstance().getMaxReturn());
        condition.setOrderByAsc(EverythingConfig.getInstance().getDeptOrderAsc());
         List<Thing> thingList = manager.search(condition);
        for (Thing thing : thingList) {
            System.out.println(thing.getPath());
        }
    }

    private static void index(EverythingManager manager) {
        DataSourceFactory.initDatabase();
        System.out.println("Rebuild File System Index ...");
        Thread buildIndexThread = new Thread(manager::buildIndex);
        buildIndexThread.setDaemon(false);
        buildIndexThread.start();
    }

    private static void quit() {
        System.out.println("欢迎使用，再见");
        System.exit(0);
    }

    private static void help() {
        System.out.println("命令列表：");
        System.out.println("退出：quit");
        System.out.println("帮助：help");
        System.out.println("索引：index");
        System.out.println("搜索：search <name> [<file-Type> img | doc | bin | archive | other]");
    }

    private static void welcome() {
        System.out.println("欢迎使用，Everything");
    }

}
