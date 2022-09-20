package HWOd;

import java.util.Scanner;

/**
 * @author skpeng
 * @version 1.0
 * @description
 * @date 2022/9/18
 */
public class Main04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        Integer arr[] = {0, 1, 2, 3, 4, 5, 6};
        Integer temp[] = {0, 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < chars.length; i++) {
            String str1 = String.valueOf(chars[i]);
            if (str1.equals("L")) {
                temp[1] = arr[5];
                temp[2] = arr[6];
                temp[5] = arr[2];
                temp[6] = arr[1];
            } else if (str1.equals("R")) {
                temp[1] = arr[6];
                temp[2] = arr[5];
                temp[5] = arr[1];
                temp[6] = arr[2];

            } else if (str1.equals("F")) {
                temp[3] = arr[5];
                temp[5] = arr[4];
                temp[4] = arr[6];
                temp[6] = arr[3];
            } else if (str1.equals("B")) {
                temp[3] = arr[6];
                temp[4] = arr[5];
                temp[5] = arr[3];
                temp[6] = arr[4];
            } else if (str1.equals("A")) {
                temp[1] = arr[4];
                temp[4] = arr[2];
                temp[2] = arr[3];
                temp[3] = arr[1];
            } else if (str1.equals("C")) {
                temp[1] = arr[3];
                temp[3] = arr[2];
                temp[4] = arr[1];
                temp[2] = arr[4];

            }
            for (int j = 0; j < temp.length; j++) {
                arr[j] = temp[j];
            }
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
