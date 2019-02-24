package Thread.MyThread;

/**
 * Author:lidan
 * Created:2019/2/19
 */
public class MyThread_1 {
    public static void main(String[] args) {
        //MyThread2 myThread1 = new MyThread2("thread1") ;
        //MyThread2 myThread2 = new MyThread2("thread2") ;
        //MyThread2 myThread3 = new MyThread2("thread3") ;
        //new Thread(myThread1).start();
        //new Thread(myThread2).start();
        //new Thread(myThread3).start();

        //方法1使用匿名内部类进行Runnable对象的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();
        //方法2使用lamdba表达式进行Runnable对象的创建
        Runnable runnable = ()->System.out.println("hello world!");
        new Thread(runnable).start();
    }
}
class MyThread2 implements Runnable{
    private String title;
    public MyThread2(String title){
        this.title=title;
    }
    public void run (){
        for (int i = 0;i<5;i++){
            System.out.println(this.title+" i="+i);
        }

    }
}
