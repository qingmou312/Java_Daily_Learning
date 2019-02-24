package Test1;

/**
 * Author:lidan
 * Created:2019/2/22
 */
public class TestThread {
    public static void main(String[] args) {
        MyThread myThread =new MyThread();
        new Thread (myThread,"用户A").start();
        new Thread (myThread,"用户B").start();
        new Thread (myThread,"用户C").start();
    }

}
class MyThread implements Runnable{
    private int ticket=10;
    @Override
    public void run() {
        while (this.ticket>0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"买完票，剩余"+this.ticket--+"张票");
        }
    }
}
