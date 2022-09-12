package thread;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask {
    @Override
    protected Object compute() {
        ForkJoinTest task1 = new ForkJoinTest();
        task1.fork();


        return null;


    }
}

class test {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0L; i <= 1000; i++) {
            sum += i;
        }
        System.out.println(sum + "---" + (System.currentTimeMillis() - start));
        StringBuffer res = new StringBuffer();
        res.reverse();

    }
}
