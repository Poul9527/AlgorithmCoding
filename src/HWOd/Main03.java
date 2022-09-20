package HWOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author skpeng
 * @version 1.0
 * @description 题目描述：骰子是一个立方体，每个面一个数字，初始为左 1，右 2，前 3（观察者方向），后 4，上 5，下 6，用 123456 表示这个状态，放置到平面上，可以向左翻转（用 L 表示向左翻转 1 次），可以向右翻转（用 R 表示向右翻转 1
 * 次），可以向前翻转（用 F 表示向前翻转 1
 * 次），可以向后翻转（用 B 表示向右翻转 1 次），可以逆时针旋转（用 A 表示逆时针旋转 90 度），可以顺时针旋转（用 C 表示逆时针旋转 90 度），现从初始状态开始，根据输入的动作序列，计算得到最终的状态。
 * 输入描述：
 * 初始状态为：123456
 * 输入只包含 LRFBAC 的字母序列，最大长度为 50，可重复
 * 输出描述：输出最终状态
 * 输入例子 : RA
 * 输出例子：436512
 * @date 2022/9/18
 */
public class Main03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        for (int i = 0; i < chars.length; i++) {
            run(String.valueOf(chars[i]), numbers);
        }
        System.out.println(numbers.stream().map(integer -> String.valueOf(integer)).collect(Collectors.joining("")));
    }

    public static void run(String str, List<Integer> numbers) {
        if (str.equals("L") || str.equals("R")) {
            int l = numbers.get(0);
            int r = numbers.get(1);
            int u = numbers.get(4);
            int d = numbers.get(5);

            if (str.equals("L")) {
                numbers.set(0, u);
                numbers.set(1, d);
                numbers.set(4, r);
                numbers.set(5, l);
            } else {
                numbers.set(0, d);
                numbers.set(1, u);
                numbers.set(4, l);
                numbers.set(5, r);
            }
        }

        if (str.equals("F") || str.equals("B")) {
            int f = numbers.get(2);
            int b = numbers.get(3);
            int u = numbers.get(4);
            int d = numbers.get(5);

            if (str.equals("F")) {
                numbers.set(2, u);
                numbers.set(3, d);
                numbers.set(4, b);
                numbers.set(5, f);
            } else {
                numbers.set(2, d);
                numbers.set(3, u);
                numbers.set(4, f);
                numbers.set(5, b);
            }
        }

        if (str.equals("A") || str.equals("C")) {
            int l = numbers.get(0);
            int rifht1 = numbers.get(1);
            int f = numbers.get(2);
            int b = numbers.get(3);

            if (str.equals("A")) {
                numbers.set(0, b);
                numbers.set(1, f);
                numbers.set(2, l);
                numbers.set(3, rifht1);
            } else {
                numbers.set(0, f);
                numbers.set(1, b);
                numbers.set(2, rifht1);
                numbers.set(3, l);
            }
        }
    }
}
