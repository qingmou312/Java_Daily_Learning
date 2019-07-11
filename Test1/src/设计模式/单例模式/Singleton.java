package 设计模式.单例模式;

/**
 * Author:lidan
 * Created:2019/6/20
 */
//public class 设计模式.单例模式.Singleton {
//    private static volatile 设计模式.单例模式.Singleton singleton;
//
//    private 设计模式.单例模式.Singleton() {
//    }
//
//    public static 设计模式.单例模式.Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (设计模式.单例模式.Singleton.class) {
//                if (singleton == null) {
//                    singleton = new 设计模式.单例模式.Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}

public class Singleton {
    private final static Singleton singleton = new Singleton();

    private Singleton() {
    }

    private static Singleton getInstance() {
        return singleton;
    }
}