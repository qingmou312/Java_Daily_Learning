package Thread.MyThread;

/**
 * Author:lidan
 * Created:2019/4/3
 */
public class Test {
        public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
