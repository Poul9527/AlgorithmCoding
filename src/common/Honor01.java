package common;

import java.util.Scanner;

/**
 * 荣耀笔试题
 * 0abcdefgh解析之后的大端字符串为hgfedcba,1abcdefgh解析之后的大端字符串为abcdefgh
 * 第一行输入一个数字，代表字符串有多少组编码
 * 第二行输入一个字符串，大端和小端，9个字符为一个编码组
 * 例输入
 * 2
 * 0abcdefgh1abcdefgh
 * 输出hgfedcba abcdefgh
 */
public class Honor01 {

    public static String getCodeArr(int count, String scode) {

        String[] arr = new String[count];
        String result = "";
        for (int i = 0; count > 0; count--) {
            arr[i] = scode.substring(i * 9, (i + 1) * 9);
            i++;
        }
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            String number = a.substring(0, 1);
            String code = a.substring(1, 9);
            if (number.equals("0")) {
                StringBuffer res = new StringBuffer();
                res.append(code);
                res.reverse();
                code = res.toString();
            }
            result = result + " " + code;
        }
        return result.substring(1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int count = in.nextInt();
            String scode = in.next();
            System.out.println(getCodeArr(count, scode));
        }
    }
}
