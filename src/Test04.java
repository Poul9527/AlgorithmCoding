import java.util.regex.Pattern;

public class Test04 {

    public static int a(String str) {
        int result = 0;
        char[] sarr = str.toCharArray();
        int b = 0;
        int c = 0;
        boolean flag = false;
        for (char a : sarr) {
            if (Character.isDigit(a)) {
                b = a;
                flag = true;
            } else if (Character.isLetter(a)) {
                flag = false;
                continue;
            } else {
                b = b * (-1);
            }
            if (flag) {
                result = result + b;
            }
        }
        return result;
    }

    private static int add(int result, int b, boolean flag) {
        if (flag) {
            result = result + b;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "23ads32ads-23";

        Integer a = 12;
        int b = 12;
        Integer c = 12;
        Integer d = new Integer(12);
        Integer e = new Integer(12);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(d == e);
        System.out.println(d.equals(e));
//        true
//        true
//        false
//        false
//        true
        System.out.println(s);
    }
}
