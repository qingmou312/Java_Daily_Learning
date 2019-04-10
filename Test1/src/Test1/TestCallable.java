package Test1;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Author:lidan
 * Created:2019/2/20
 */
public class TestCallable {
    public static void main(String[] args) throws InterruptedException,ExecutionException {
        //普通的函数接口
        Callable<String> callable  = new MyCallable();
        //通过FutureTask包装
        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();
        new Thread(task).start();
        try{
        System.out.println(task.get());
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable <String> {
    private int ticket=10;
    public String call() throws Exception{
        while(this.ticket>0){
            System.out.println("剩余票数"+this.ticket--);
        }
        return "票卖完了";
    }
}