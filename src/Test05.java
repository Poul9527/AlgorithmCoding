import java.util.*;

public class Test05 {
//东进技术公司笔试

    public static void main(String[] args) {
        List<long[]> list = removNb(26);
        list.add(new long[]{21, 14});
        list.add(new long[]{3, 14});
        list.add(new long[]{21, 16});
        list.add(new long[]{5, 14});
        list.sort((long[] long1, long[] long2) -> {
            return long1[0] <= long2[0] ? -1 : 1;
        });
        Collections.sort(list, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return new Long(o1[0]).compareTo(new Long(o2[0]));
            }
        });
        // 转lambda表达式
        Collections.sort(list, (long[] o1, long[] o2) -> {
            return new Long(o1[0]).compareTo(new Long(o2[0]));
        });
//        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            long[] arr = list.get(i);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    // 请按你的实际需求修改参数
    public static List<long[]> removNb(long n) {
        List<long[]> list = new ArrayList();
        long[] arr = new long[2];
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n; j++) {
                if (i != j) {
                    long sumafter = sum - i - j;
                    long ij = i * j;
                    if (ij == sumafter) {
                        arr[0] = i;
                        arr[1] = j;
                        list.add(arr);
                    }
                }
            }
        }

        return list;
    }

}
