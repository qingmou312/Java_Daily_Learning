package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestStop3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    i++;
                    boolean flag = Thread.currentThread().isInterrupted();
                    if(flag){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" i="+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        boolean bool =Thread.currentThread().isInterrupted();
                        System.out.println(bool);
                        return;
                    }
                }

            }
        };
        Thread thread = new Thread(runnable, "Thread-stop-3");
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
