package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestYield {
    public static void main(String[] args) {
        Runnable runnable =new Runnable(){
            public void run (){
                for (int i= 0;i<5;i++){
                    Thread.yield();//交出CPU的时间不可控，当前线程回到就绪状态。
                    System.out.println(Thread.currentThread().getName()+" i="+i);
                }
            }
        };
        new Thread(runnable,"Thread-1").start();
        new Thread(runnable,"Thread-2").start();
        new Thread(runnable,"Thread-3").start();
    }
}
