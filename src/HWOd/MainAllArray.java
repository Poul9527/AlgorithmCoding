package HWOd;

/**
 * @author skpeng
 * @version 1.0
 * @description 对字母AGSYBUOQPIL全排列，返回排列总数，I、S、O不能两两相连，Q不能在第五个位置，A必须在第五个位置
 * 1706400
 * @date 2022/9/22
 */
public class MainAllArray {

    public static int result = 0;

    public static void main(String[] args) {
        char[] letters = {'A', 'G', 'S', 'Y', 'B', 'U', 'O', 'Q', 'P', 'I', 'L'};

        getPermutationsCount(letters, 0, letters.length - 1);
        System.out.println(result);
    }

    public static void getPermutationsCount(char[] letters, int start, int end) {
        if (start == end) {
            String s = new String(letters);
            if (letters[1] == 'A' && letters[4] != 'Q') {
                if (s.indexOf("IS") < 0 && s.indexOf("SI") < 0 && s.indexOf("IO") < 0 && s.indexOf("OI") < 0 && s.indexOf("SO") < 0 && s.indexOf(
                        "OS") < 0) {
                    result++;
                }
            }
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(letters, start, i);
            getPermutationsCount(letters, start + 1, end);
            swap(letters, start, i);
        }

    }

    public static void swap(char[] letters, int i, int j) {
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }

}
