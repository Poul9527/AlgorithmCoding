package HWOd;

import java.util.Scanner;

/**
 * @author skpeng
 * @version 1.0
 * @description 非严格递增连续数字序列
 * 输入一个仅包含大小写字母和数字，求字符串中包含的最长的非严格递增连续数字序列的长度（比如12234属于非严格递增连续数字序列）。
 * 输入描述:输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符。
 * 输出描述:最长的非严格递增连续数字序列的长度
 * 示例
 * 输入：
 * abc2234019A334bc
 * 输出：4
 * 说明：
 * 2234为最长的非严格递增连续数字序列，所以长度为4
 * @date 2022/9/18
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str == null) {
            System.out.println(0);
            return;
        }
        char[] chars = str.toCharArray();
        if (chars.length == 1) {
            if (!Character.isLetter(chars[0])) {
                System.out.println(1);
                return;
            } else {
                System.out.println(0);
                return;
            }
        }
        int result = 0;
        int temp = 0;
        if (!Character.isLetter(chars[0])) {
            temp = 1;
        }
        for (int i = 1; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (temp > result) {
                    result = temp;
                }
                temp = 0;
                continue;
            }

            if (!Character.isLetter(chars[i - 1])) {
                if (chars[i] >= chars[i - 1]) {
                    temp += 1;
                } else {
                    if (temp > result) {
                        result = temp;
                    }
                    temp = 1;
                }
            } else {
                if (temp > result) {
                    result = temp;
                }
                temp = 1;
            }
        }
        System.out.println(result);
    }
}
