package HWOd;

import java.util.Scanner;

/**
 * @author skpeng
 * @version 1.0
 * @description
 * 题目
 * 给定一个随机的整数（可能存在正整数和负整数）数组 nums ，请你在该数组中找出两个数，
 * 其和的绝对值(|nums[x]+nums[y]|)为最小值，并返回这个两个数（按从小到大返回）以及绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 输入描述:
 * 一个通过空格分割的有序整数序列字符串，最多1000个整数，且整数数值范围是 [-65535, 65535]。
 * 输出描述:
 * 两数之和绝对值最小值
 * 示例1
 * 输入
 * -1 -3 7 5 11 15
 * 输出
 * -3 5 2
 * 说明
 * 因为 |nums[0] + nums[2]| = |-3 + 5| = 2 最小，所以返回 -3 5 2
 * @date 2022/9/18
 */
public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int a = 0;
        int b = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int ai = Integer.parseInt(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                int bj = Integer.parseInt(arr[j]);
                int temp = Math.abs(ai + bj);
                if (temp < result) {
                    result = temp;
                    if (ai < bj) {
                        a = ai;
                        b = bj;
                    } else {
                        a = bj;
                        b = ai;
                    }

                }
            }
        }
        System.out.println(a + " " + b + " " + result);
    }
}
