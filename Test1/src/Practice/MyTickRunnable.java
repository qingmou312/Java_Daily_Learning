package Practice;

/**
 * Author:lidan
 * Created:2019/2/22
 */
public class MyTickRunnable implements Runnable {

    private int tick = 10;

//    @Override
//    public void run() {
//        //1.同步块
//        while (this.tick > 0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized(this) {
//                if (this.tick > 0) {
//                    this.tick--;
//                    System.out.println(Thread.currentThread().getName() + " 买票， 剩余 " + this.tick);
//                }
//            }
//        }
//    }

    //2.同步方法
    @Override
    public synchronized void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.tick--;
            System.out.println(Thread.currentThread().getName() + " 买票， 剩余 " + this.tick);
        }
    }


    public static void main(String[] args) {
        Runnable target = new MyTickRunnable();
        new Thread(target, "黄牛A").start();
        new Thread(target, "黄牛B").start();
        new Thread(target, "黄牛C").start();

    }
}

