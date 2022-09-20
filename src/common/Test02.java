package common;

import java.util.BitSet;
import java.util.Scanner;

public class Test02 {

    /*
     *  题目：将一个正整数分解质因数
     *  质因数就是能够被该正整数整除的质数
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要分解质因数的正整数：");
        int numInput = in.nextInt();
        factor(numInput);
    }

    //分解质因数
    public static void factor(int num) {
        System.out.print("分解的结果为：");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.print(i + "*");
                num /= i;
                i--;
            }

        }
        System.out.println(num);
        BitSet set = new BitSet();
    }
}
