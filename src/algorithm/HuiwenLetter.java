package algorithm;

/**
 * @author skpeng
 * @version 1.0
 * @description 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * 提示：
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 * @date 2022/9/23
 */
public class HuiwenLetter {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        char[] temps = new char[chars.length];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    temps[j] = Character.toLowerCase(chars[i]);
                } else {
                    temps[j] = chars[i];
                }
                j++;
            }
        }
        System.out.println(temps);
        boolean result = true;
        for (int i = 0; i < j / 2; i++) {
            if (temps[i] != temps[j - i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
