package com.github.qingmou312.everything.cmd;

import com.github.qingmou312.everything.core.DAO.DataSourceFactory;
import com.github.qingmou312.everything.core.EverythingManager;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadFactory;

import static jdk.nashorn.internal.objects.NativeString.search;
import static jdk.nashorn.internal.runtime.ScriptObject.setGlobalObjectProto;

/**
 * Author:lidan
 * Created:2019/3/15
 */
public class EverythingCmdApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //欢迎
        welcome();

        //统一调度器
        EverythingManager manager = EverythingManager.getInstance();

        //启动后台清理线程
        manager.startClearThread();

        //交互式
        interactive(manager);

    }

    private static void interactive(EverythingManager manager) {
        while (true) {
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
        //统一调度器中的search
        List<Thing> thingList = manager.search(condition);
        thingList.forEach((t) -> System.out.println(t.getPath()));
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
