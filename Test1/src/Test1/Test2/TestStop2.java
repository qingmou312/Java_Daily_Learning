package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestStop2 {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable () {
            public void run() {
                int i = 0;
                while (true){
                    i++;
                    System.out.println(Thread.currentThread().getName()+" i="+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Thread-Stop-1");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}

