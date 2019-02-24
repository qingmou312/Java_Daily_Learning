package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestJoin {
    public static void main(String[] args) {
        //main线程开始执行
        System.out.println(Thread.currentThread().getName()+"开始执行");
        //自定义线程
        Thread myJoin = new Thread(new MyJoin(),"Thread-myJoin");
        myJoin.start();
        try {
            myJoin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }

}
class MyJoin implements Runnable {
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始执行");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束执行");
    }
}