package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestSleep {
    public static void main(String[] args) {
        Runnable runnable =new Runnable (){
            public void run (){
                for(int i = 0;i<5;i++){
                    try {
                        Thread.sleep(1000);//线程休眠
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" i="+i);
                }
            }
        };
        new Thread(runnable,"Thread-1").start();
        new Thread(runnable,"Thread-2").start();
        new Thread(runnable,"Thread-3").start();
    }
}
