import java.util.Scanner;

/**
 * 荣耀笔试题
 * A,B,C,D,E五件商品，价格分别为1，3，7，11，13
 * 第一行输入每种商品的件数（0~1000）
 * 第二行输入一个正整数x，为钱数（1<x<=10000）
 * 输出最少需要选取的商品件数
 * 例：1 2 3 4 5
 * 30
 * 输出：4
 * 13*2+3*1+1*1=30
 */
public class Honor02 {

    public static int productCount(int acount, int bcount, int ccount, int dcount, int ecount, int money) {
        int aprice = 1;
        int bprice = 3;
        int cprice = 7;
        int dprice = 11;
        int eprice = 13;

        int productCount = 0;

        int mtemp = 0;
        mtemp = money / eprice;
        if (mtemp > 0) {

        }

        while (money >= eprice && ecount > 0) {
            money = money - eprice;
            productCount++;
            ecount--;
        }
        while (money >= dprice && dcount > 0) {
            money = money - dprice;
            productCount++;
            dcount--;
        }
        while (money >= cprice && ccount > 0) {
            money = money - cprice;
            productCount++;
            ccount--;
        }
        while (money >= bprice && bcount > 0) {
            money = money - bprice;
            productCount++;
            bcount--;
        }
        while (money >= aprice && acount > 0) {
            money = money - aprice;
            productCount++;
            acount--;
        }
        return productCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int e = in.nextInt();
            int m = in.nextInt();
            System.out.println(productCount(a, b, c, d, e, m));
        }
    }
}
