package HWOd;

import java.util.LinkedList;
import java.util.List;

/**
 * @author skpeng
 * @version 1.0
 * @description 给定一个的字符数组chars ，
 * 返回其所有可能的排列组合 ，重复的排列只返回一个。
 * 用例1，输入：chars = {'a', 'b', 'c'}，输出：{{'a', 'b', 'c'},{ 'a', 'c', 'b'},{ 'c', 'a', 'b'},{ 'b', 'a', 'c'},{ 'b', 'c', 'a'},{ 'c', 'b', 'a'}}
 * 用例2，输入：chars = {'a', 'b', 'a'}，输出：{{'a', 'b', 'a'}, { 'a', 'a', 'b'},{ 'b', 'a', 'a'}}
 * 用例3，输入: chars = {'a', 'b'}，输出：{{'a', 'b'},{ 'b', 'a'}}
 * 用例4：输入：chars = {'a'}，输出：{{'a'}}
 * @date 2022/9/26
 */
public class Permutation2 {

    static List result = new LinkedList<>();

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'c', 'd'};
        permutation(chars, 0, chars.length - 1);
        result.stream().forEach(System.out::println);
    }

    public static void permutation(char[] chars, int start, int end) {

        if (start == end) {
            String str = new String(chars);
            if (!result.contains(str)) {
                result.add(str);
            }
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(chars, start, i);
            permutation(chars, start + 1, end);
            swap(chars, start, i);
        }
    }

    /**
     * 交换
     */
    public static void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

}




