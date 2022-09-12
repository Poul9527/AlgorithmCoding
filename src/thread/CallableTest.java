package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        Mycallable mycallable = new Mycallable();
        FutureTask futureTask = new FutureTask(mycallable);
        new Thread(futureTask, "A").start();
        new Thread(new FutureTask(mycallable), "B").start();
        try {
            Integer a = (Integer) futureTask.get(); // 获取返回值
            System.out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}

class Mycallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
