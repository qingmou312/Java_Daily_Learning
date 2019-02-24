package PC;

import java.util.Queue;

/**
 * 消费者
 * Author:lidan
 * Created:2019/2/23
 */
public class Customer implements Runnable {
    private final Queue<Goods> queue;

    public Customer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (queue) {
            if (queue.isEmpty()) {
                queue.notifyAll();
            } else {
                Goods goods = queue.poll();
                System.out.println(Thread.currentThread().getName() + "消费" + goods);
            }
        }
    }
}
