package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestDaemon {
    public static void main(String[] args) {
        //新建一个守护线程
        Thread threadA=new Thread(new MyRunnable(),"Thread-A");
        threadA.setDaemon(true);
        threadA.start();

        //创建一个用户线程
        Thread threadB=new Thread(new MyRunnable(),"Thread-B");
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();
    }


}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        int i=0;
        try {
            while(true){
                i++;
            Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" i=" +i+" 是否是守护线程："+Thread.currentThread().isDaemon());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"发生中断");
        }
    }
}