package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/20
 */
public class TestThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        new Thread(myThread1).start();//开启线程，不设置名称
        new Thread (myThread1,"my1").start();//设置线程名称，并开启线程
    }
}
class MyThread implements Runnable{
    public void run(){
        for (int i = 0;i<3;i++){
            System.out.println("当前线程"+Thread.currentThread().getName()+" i="+i);//获取当前线程的名称
        }
    }
}
