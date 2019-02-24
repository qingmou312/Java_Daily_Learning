package Thread.MyThread;

/**
 * Author:lidan
 * Created:2019/2/19
 */
public class MyThread {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("thread1");
        MyThread1 myThread2 = new MyThread1("thread2");
        MyThread1 myThread3 = new MyThread1("thread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
class MyThread1  extends Thread{//线程主体
    private String title;
    public MyThread1(String title){
        this.title= title;
    }
    public void run() {//所有的线程从此处开始执行
        for (int i = 0; i < 5; i++) {
            System.out.println(this.title + " i=" + i);
        }
    }
}

