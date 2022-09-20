package HWOd;

import java.util.Scanner;

public class Main20 {

    public static int changeIpv4(String str) {
        String result = "";
        String[] sarr = str.split("#");
        for (int i = 0; i < sarr.length; i++) {
            int num = Integer.valueOf(sarr[i]);
            int count = 8;
            if (i == 0) {
                count = 7;
            }
            String numStr = "";
            while (count > 0) {
                numStr = num % 2 + numStr;
                num = num / 2;
                count--;
            }
            result = result + numStr;
        }
        return Integer.parseInt(result, 2);
    }


    public static boolean validate(String s) {
        boolean flag = true;
        if (s == null || s.equals("")) {
            return flag = false;
        }
        String[] sarr = s.split("#");
        if (sarr.length < 4) {
            return flag = false;
        } else if (Integer.valueOf(sarr[0]) < 1 || Integer.valueOf(sarr[0]) > 128) {
            return flag = false;
        } else {
            for (int i = 1; i < sarr.length; i++) {
                int a = Integer.valueOf(sarr[i]);
                if (a < 0 || a > 255) {
                    return flag = false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        boolean flag = validate(s);
        if (!flag) {
            System.out.println("invalid IP");
        } else {
            System.out.println(changeIpv4(s));
        }
    }
}
