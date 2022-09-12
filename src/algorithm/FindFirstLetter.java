package algorithm;

/**
 * 1. 写一个函数，输入一个字符串
 * 输出第一次出现的，只有一个的字符。
 * 比如
 * 输入abcdea
 * 输出b
 */
public class FindFirstLetter {
    public static void main(String[] args) {
        String s = "cbab";
        System.out.println(findFirst(s));
    }
    private static String findFirst(String s) {
        String result = "null";
        if (s == null) {
            return result;
        }
        char[] arr = s.toCharArray();
        int[] hashArr = new int[128];
        for (int i = 0; i < hashArr.length; i++) {
            hashArr[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            // 每个字母转ascii码
            int tmp = arr[i];
            // 对应的第ascii码位的值+1
            hashArr[tmp]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (hashArr[arr[i]] == 1) {
                //找到第一个等于1的ascii码位
                return String.valueOf(arr[i]);
            }
        }
        // 如果没有，返回"null"；
        return result;
    }
}
