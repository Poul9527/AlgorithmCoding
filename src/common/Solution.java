package common;

import java.util.*;


public class Solution {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * @param words string�ַ���һά����
     * @return string�ַ���
     */
    public String longestWord(String[] words) {
        // write code here
        //�ҳ������г�����ĵ��ʣ�����������������϶���
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
