package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestPriority {
    public static void main(String[] args) {
//        Thread thread=new Thread();
//        System.out.println("创建的线程的优先级"+thread.getPriority());
//        System.out.println("主线程的优先级"+Thread.currentThread().getPriority());

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getPriority());
                Thread son=new Thread (()->{
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getPriority());
                },"Thread-son");
                son.start();
            }
        };
        Thread threadParent=new Thread(runnable,"Thread-Parent");
        threadParent.setPriority(9);
        threadParent.start();
    }
}
