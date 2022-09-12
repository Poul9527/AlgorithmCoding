package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock1 = new TestLock2();
        new Thread(testLock1, "线程1").start();
        new Thread(testLock1, "线程2").start();
        new Thread(testLock1, "线程3").start();

    }


}

class TestLock2 implements Runnable {

    int ticketNums = 1000;

    //lock
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums-- + Thread.currentThread().getName());
                } else {
                    break;
                }
            } finally {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }
}
