package Test1.Test2;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class TestStop1 {
    public static void main(String[] args) {
        MyStop myStop1 = new MyStop();
        myStop1.setName("Thread-Stop-1");
        myStop1.start();
        MyStop myStop2 = new MyStop();
        myStop2.setName("Thread-Stop-2");
        myStop2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myStop2.setFlag(false);
    }
}
class MyStop extends Thread{
    //判断线程是否停止
    private volatile  boolean flag=true;
    public void run() {
        int i=0;
        while (flag){
            i++;
            System.out.println(Thread.currentThread().getName()+" i="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


