import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param words string字符串一维数组
     * @return string字符串
     */
    public String longestWord(String[] words) {
        // write code here
        //找出数组中长度最长的单词，单词由其它单词组合而成
        String result = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > result.length()) {
                result = word;
            } else if (word.length() == result.length()) {
                list.clear();
                list.add(word);
                list.add(result);
            }
        }
        if (list.size() > 1) {
            Collections.sort(list);
            result = list.get(0);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "goodman","hoodman"};
        System.out.println(new Solution().longestWord(arr));
    }
}
