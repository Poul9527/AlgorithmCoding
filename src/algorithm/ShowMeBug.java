package algorithm;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author skepng
 * @version 1.0
 * @description MoeGo在线笔试题
 * @date 2022/4/17
 */


/**
 * Q1: 实现一个加权随机算法
 * <p>
 * 给定一个长度为 N (< 10000) 的正整数(< 100)数组,
 * 调用 next() 返回任意一个该数组的下标, 即 [0, N)
 * 区间内的整数, 下标 i 被返回的概率为 数组的第 i 个
 * 元素的值 / 数组所有元素之和.
 * <p>
 * 要求: 空间复杂度不限, next() 方法的时间复杂度最优
 * <p>
 * 例: 给定一个数组 {4, 1, 3, 2}, 则 next() 函数可
 * 返回 0, 1, 2, 3 中的任意一个数字, 对应被返回的概率
 * 为 4/10, 1/10, 3/10, 2/10.
 */

class WeightedRand_V1_Me {
    public List<Integer> list;

    public WeightedRand_V1_Me(int[] input) {
        list = new ArrayList<Integer>();
        int lastKey = 0;
        for (int i : input) {
            lastKey += i;
            list.add(lastKey);
        }
    }

    public int next() {
        //随机数生成
        int randomWeight = (int) (this.list.get(list.size() - 1) * Math.random());
        //二分查找获取对应区间
        return binarySearch(0, list.size() - 1, randomWeight);
    }

    public int binarySearch(int start, int end, int target) {
        int middle = (start + end) / 2;
        if (target < list.get(middle)) {
            if (middle == 0) {
                return 0;
            } else if (target > list.get(middle - 1)) {
                return middle;
            } else {
                return binarySearch(start, middle, target);
            }
        } else {
            if (target < list.get(middle + 1)) {
                return middle + 1;
            } else {
                return binarySearch(middle, end, target);
            }
        }
    }
}

/**
 * Q2: 题目同上, 要求: 空间复杂度最优的前提下, 尽可能降低 next() 方法的时间复杂度
 */
class WeightedRand_V2_Me {
    public Deque<Integer> deque;

    public WeightedRand_V2_Me(int[] input) {
        deque = new LinkedList<Integer>();
        int lastKey = 0;
        for (int i : input) {
            lastKey += i;
            deque.push(lastKey);
        }
    }

    public int next() {
        //随机数生成
        int randomWeight = (int) (this.deque.peek() * Math.random());
        //链表便利查找获取对应区间
        return getLastKey(randomWeight);
    }

    public int getLastKey(int target) {
        int index = 0;
        for (int i = deque.size()-1; i >= 0; i--) {
            if (target < deque.getFirst()) {
                return index;
            }
            index++;

        }
/*        for (int i : deque) {
            if (target < i) {
                return index;
            }
            index++;
        }*/
        return 0;
    }
}


/**
 * Q3: 实现一个简单的多任务执行器, 其最多可以同时执行 capacity 个任务
 * <p>
 * 注意: 不可使用 JDK 提供的线程池相关接口.
 */
class ParallelTaskExecutor_Me {


    /**
     * @param capacity 最多可同时执行的任务个数
     */
    public ParallelTaskExecutor_Me(int capacity) {
        // show me your code here

        for (int i = 0; i < capacity; i++) {
            int finalI = i;
            // 创建任务
            Callable task = () -> finalI * 2;
            // 包装
            FutureTask futureTask = new FutureTask(task);
        }
    }

    /**
     * 异步执行任务, 返回 Future 对象
     *
     * @param callable 要执行的任务
     * @param <T>      任务的返回值类型
     * @return 返回一个 Future, 任务执行完成时其状态变更为 Done.
     */
    public <T> Future<T> submit(Callable<T> callable) {
        // show me your code here, please delete the following line.

        FutureTask futureTask = new FutureTask(callable);
        // 创建线程执行任务
        new Thread(futureTask).start();
        return futureTask;
    }

}


// 下面是测试代码


public class ShowMeBug {
    public static void main(String[] args) {
        try {
            System.out.println("Testing Q1...");
            testWeightedRand_V1();
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
        try {
            System.out.println("Testing Q2...");
            testWeightedRand_V2();
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
        try {
            System.out.println("Testing Q3...");
            testParallelTaskExecutor();
            System.out.println("PASSED!");
        } catch (Exception e) {
            System.out.println("FAILED: " + e.toString());
        }
    }

    private static void testWeightedRand_V1() throws Exception {
        int[] input = {4, 1, 3, 2};
        WeightedRand_V1_Me rand = new WeightedRand_V1_Me(input);
        int[] result = new int[input.length];
        int runCount = 1000 * input.length;
        for (int i = 0; i < runCount; i++) {
            int next = rand.next();
            if (next < 0 || next > input.length) {
                throw new Exception("unexpected rand value: " + next);
            }
            result[next]++;
        }

        int sum = 0;
        for (int j : input) {
            sum += j;
        }

        for (int i = 0; i < input.length; i++) {
            double realP = result[i] / (double) runCount;
            double expectedP = input[i] / (double) sum;
            if (realP - expectedP > 0.1 || realP - expectedP < -0.1) {
                throw new Exception("unexpected probability " + realP + " for value " + i + ", expected is " + expectedP);
            }
        }
    }


    private static void testWeightedRand_V2() throws Exception {
        int[] input = {4, 1, 3, 2};
        WeightedRand_V2_Me rand = new WeightedRand_V2_Me(input);
        int[] result = new int[input.length];
        int runCount = 1000 * input.length;
        for (int i = 0; i < runCount; i++) {
            int next = rand.next();
            if (next < 0 || next > input.length) {
                throw new Exception("unexpected rand value: " + next);
            }
            result[next]++;
        }

        int sum = 0;
        for (int j : input) {
            sum += j;
        }

        for (int i = 0; i < input.length; i++) {
            double realP = result[i] / (double) runCount;
            double expectedP = input[i] / (double) sum;
            if (realP - expectedP > 0.1 || realP - expectedP < -0.1) {
                throw new Exception("unexpected probability " + realP + " for value " + i + ", expected is " + expectedP);
            }
        }
    }


    /**
     * 系统开始执行时间
     */
    private static long startTime;

    /**
     * 创建一个虚拟的任务
     *
     * @param wait        指定任务耗时, 毫秒
     * @param shouldThrow 指定任务是否抛出异常, 如果为 true, 任务将抛出一个 Exception
     * @return 返回一个虚拟任务, 在开始执行后大约 wait 毫秒后执行完毕
     */
    private static Callable<Integer> createCallable(long wait, boolean shouldThrow) {
        return () -> {
            Thread.sleep(wait);
            long costTime = (System.currentTimeMillis() - startTime);
            // 以 100 为单位向下取整, 屏蔽精度对结果的影响.
            long expectedCostTime = costTime - (costTime % 100);
            if (shouldThrow) {
                throw new Exception(Long.toString(expectedCostTime));
            }
            return (int) expectedCostTime;
        };
    }

    private static void testParallelTaskExecutor() throws Exception {
        ParallelTaskExecutor_Me pool = new ParallelTaskExecutor_Me(2);
        List<String> expectedResults = Arrays.asList(
                "RETURN: 100",
                "RETURN: 200",
                "THROW: java.lang.Exception: 300",
                "RETURN: 400",
                "RETURN: 600",
                "RETURN: 700"
        );

        List<String> actualResults = new ArrayList<>();

        startTime = System.currentTimeMillis();
        List<Future<Integer>> futureList = new ArrayList<>();
        futureList.add(pool.submit(createCallable(101, false)));
        futureList.add(pool.submit(createCallable(202, false)));
        futureList.add(pool.submit(createCallable(203, true)));
        futureList.add(pool.submit(createCallable(204, false)));
        futureList.add(pool.submit(createCallable(305, false)));

        for (Future<Integer> future : futureList) {
            try {
                Integer v = future.get();
                actualResults.add("RETURN: " + v.toString());
            } catch (Exception e) {
                actualResults.add("THROW: " + e.getMessage());
            }
        }

        Future<Integer> anotherTask = pool.submit(createCallable(106, false));
        try {
            actualResults.add("RETURN: " + anotherTask.get().toString());
        } catch (Exception e) {
            actualResults.add("THROW: " + e.getMessage());
        }

        for (int i = 0; i < expectedResults.size(); i++) {
            if (!expectedResults.get(i).equals(actualResults.get(i))) {
                throw new Exception(
                        String.format("Unexpected \"%s\" for task %d, expected is \"%s\"",
                                actualResults.get(i), i, expectedResults.get(i))
                );
            }
        }
    }
}


