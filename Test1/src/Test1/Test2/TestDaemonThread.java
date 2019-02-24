package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestDaemonThread {
    public static void main(String[] args) {
        //1.创建一个守护线程
        Thread threadA = new Thread(new MyRunnableDamon(), "Thread-A");
        //!!! 设置是否是守护线程，方法一定要在start方法之前执行
        threadA.setDaemon(true);
        threadA.start();

        //2.创建一个用户线程（非守护）
        Thread threadB = new Thread(new MyRunnableDamon(), "Thread-B");
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();
    }

}

class MyRunnableDamon implements Runnable {
    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                i++;
                System.out.println(Thread.currentThread().getName() + " i = " + i + " 是否是守护线程:" + Thread.currentThread().isDaemon());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " 发生中断");
        }
    }
}

