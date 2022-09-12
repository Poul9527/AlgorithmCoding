package thread;

/**
 * 并发协作
 * 管程法解决生产者消费者模式
 */
public class PC1 {
    public static void main(String[] args) {
        SyncContainer syncContainer = new SyncContainer();
        new Productor(syncContainer).start();
        new Thread(new Consumer(syncContainer)).start();
    }
}

class Productor extends Thread {
    SyncContainer container;

    public Productor(SyncContainer syncContainer) {
        this.container = syncContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
            System.out.println("container中鸡的数量-->" + container.count);
        }
    }
}

class Consumer implements Runnable {
    SyncContainer container;

    public Consumer(SyncContainer syncContainer) {
        this.container = syncContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + container.pop().id + "只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SyncContainer {
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void push(Chicken chicken) {
        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;
        count++;

        //通知消费
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //消费
        count--;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }

}
