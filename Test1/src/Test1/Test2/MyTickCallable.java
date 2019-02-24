package Test1.Test2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Author:lidan
 * Created:2019/2/20
 */
    public class MyTickCallable implements Callable<String> {

        private int tick = 10;

        @Override
        public synchronized String call() throws Exception {
            while (this.tick > 0) {
                this.tick--;
                System.out.println("剩余票的数量：" + this.tick);
            }
            return "票卖完啦";
        }
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            //1.普通的函数接口， call
            Callable<String> callable = new MyTickCallable();
            //2.通过FutureTask包装
            FutureTask<String> futureTask = new FutureTask<>(callable);

            Thread thread1 = new Thread(futureTask);
            Thread thread2 = new Thread(futureTask);
            Thread thread3 = new Thread(futureTask);

            thread1.start();
            thread2.start();
            thread3.start();

            //3.获取结果
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

