package algorithm;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;      // i=0,j=arr.length 13
        j = high;
        //temp���ǻ�׼λ
        temp = arr[low];    // arr[0] 10

//        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        while (i < j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp <= arr[j] && i < j) {
                j--;    //12
            }
            //�ٿ���ߣ��������ҵ���
            while (temp >= arr[i] && i < j) {
                i++;    //1
            }
            //������������򽻻�
            if (i < j) {
                t = arr[j];     //9
                arr[j] = arr[i];    //7
                arr[i] = t;     //9
            }

        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���

        arr[low] = arr[i];
        arr[i] = temp;
        //�ݹ�����������
        quickSort(arr, low, j - 1);
        //�ݹ�����Ұ�����
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int[] arr = {1, 86, 29, 19};
//        int[] arr = {1, 7, 6, 8, 4};
        quickSort(arr, 0, arr.length - 1);
/*        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        Arrays.stream(arr).forEach(ss ->System.out.print(ss + ","));
        //������
        Thread thread = Thread.currentThread();
        AtomicReference atomicReference = new AtomicReference();
        while (!atomicReference.compareAndSet(null, thread)) { }    //cas����
        atomicReference.compareAndSet(thread, null);    //cas����

        System.out.println(System.currentTimeMillis() - start + "----" + arr.length);
    }
}

