package algorithm;

/**
 * 1. дһ������������һ���ַ���
 * �����һ�γ��ֵģ�ֻ��һ�����ַ���
 * ����
 * ����abcdea
 * ���b
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
            // ÿ����ĸתascii��
            int tmp = arr[i];
            // ��Ӧ�ĵ�ascii��λ��ֵ+1
            hashArr[tmp]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (hashArr[arr[i]] == 1) {
                //�ҵ���һ������1��ascii��λ
                return String.valueOf(arr[i]);
            }
        }
        // ���û�У�����"null"��
        return result;
    }
}
