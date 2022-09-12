package thread;

/**
 * ����Э��
 * �̷ܳ����������������ģʽ
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
            System.out.println("������" + i + "ֻ��");
            System.out.println("container�м�������-->" + container.count);
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
            System.out.println("������-->" + container.pop().id + "ֻ��");
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

        //֪ͨ����
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            //�ȴ������������������ߵȴ�
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //����
        count--;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }

}
