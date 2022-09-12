import com.sun.scenario.effect.Merge;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {

//        int i = 1;
//        int j = 2;
//        System.out.println(i ^ j);
        int[] arr = {5, 2, 3, 1, 4};
        System.out.println(Arrays.toString(MySort(arr)));
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode movnode = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                movnode.next = list2;
                list2 = list2.next;
            } else {
                movnode.next = list1;
                list1 = list1.next;
            }
            movnode = movnode.next;
        }
        if (list1 != null) {
            movnode.next = list1;
        }
        if (list2 != null) {
            movnode.next = list2;
        }
        return head.next;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public static int[] MySort(int[] arr) {
        // write code here
        int[] arrb = new int[arr.length];
        arrb[0] = arr[0];
        for (int j = 0; j < arrb.length; j++) {
            arrb[j] = arr[j];
            int temp = arrb[j];
            for (int i = 0; i < arr.length; i++) {
                if (temp > arr[i]) {
                    temp = arr[i];
                }
            }
            arrb[j] = temp;
        }
        Integer.toHexString(11).toUpperCase(); //A
        Integer.toBinaryString(11);//二进制
        Integer.toOctalString(1);// 返回进制
        return arrb;
    }
}
