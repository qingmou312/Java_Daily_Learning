package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/22
 */
public class TestPrint  {
    public static void main(String[] args) {
        Runnable runnable=new Runnable(){
            @Override
            public  void run() {
                synchronized (this) {
                    System.out.println("@#" + Thread.currentThread().getName());
                }
            }
        };
        for(int i=0;i<10;i++){
           Thread thread=new Thread (runnable,"Thread-"+i);
           thread.start();
        }
    }
}
