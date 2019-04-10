package Thread.MyThread;

/**
 * Author:lidan
 * Created:2019/2/19
 */
public class MyThread extends Thread {
//    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//    }

    private static int Piao = 10;

    //    Object obj =new Object();
    public void run() {//所有的线程从此处开始执行
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Piao > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售" + (Piao--));
                }
            }
        }
    }
}
//class MyThread  extends Thread{//线程主体
//    private String title;
//    public MyThread1(String title){
//        this.title= title;
//    }
//    public void run() {//所有的线程从此处开始执行
//        for (int i = 0; i < 5; i++) {
//            System.out.println(this.title + " i=" + i);
//        }
//    }

//    private static int Piao=100;
//    Object obj =new Object();
//    public void run() {//所有的线程从此处开始执行
//        while(true){
//         synchronized (obj){
//             if(Piao>0){
//                 try {
//                     Thread.sleep(100);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//                 System.out.println(Thread.currentThread().getName()+"正在出售"+(Piao--));
//             }
//         }
//        }
//    }
//}

