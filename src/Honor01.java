import java.util.Scanner;

/**
 * ��ҫ������
 * 0abcdefgh����֮��Ĵ���ַ���Ϊhgfedcba,1abcdefgh����֮��Ĵ���ַ���Ϊabcdefgh
 * ��һ������һ�����֣������ַ����ж��������
 * �ڶ�������һ���ַ�������˺�С�ˣ�9���ַ�Ϊһ��������
 * ������
 * 2
 * 0abcdefgh1abcdefgh
 * ���hgfedcba abcdefgh
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
