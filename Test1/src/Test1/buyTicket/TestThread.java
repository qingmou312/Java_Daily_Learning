package Test1.buyTicket;

/**
 * Author:lidan
 * Created:2019/2/22
 */
public class TestThread {
    public static void main(String[] args) {
        MyThread myThread =new MyThread();
        Thread A=new Thread (myThread,"用户A");
        Thread B=new Thread (myThread,"用户B");
        Thread C=new Thread (myThread,"用户C");
        A.setPriority(Thread.MIN_PRIORITY);
        B.setPriority(Thread.MAX_PRIORITY);
        C.setPriority(Thread.MAX_PRIORITY);
        A.start();
        B.start();
        C.start();
    }

}
class MyThread implements Runnable {
    private int ticket = 10;
    //同步方法
    @Override
    public synchronized void run() {
        while (this.ticket > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买完票，剩余" + --this.ticket + "张票");
            }
    }
//    //同步代码块
//    @Override
//    public void run() {
//        while (this.ticket > 0) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (this.ticket > 0) {
//                synchronized (this) {//在同一时刻，只能是一个线程进入到代码块中处理
//                    System.out.println(Thread.currentThread().getName() + "买完票，剩余" + --this.ticket + "张票");
//                }
//            }
//        }
//    }
}
