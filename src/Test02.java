import java.util.BitSet;
import java.util.Scanner;

public class Test02 {

    /*
     *  ��Ŀ����һ���������ֽ�������
     *  �����������ܹ���������������������
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("������Ҫ�ֽ�����������������");
        int numInput = in.nextInt();
        factor(numInput);
    }

    //�ֽ�������
    public static void factor(int num) {
        System.out.print("�ֽ�Ľ��Ϊ��");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.print(i + "*");
                num /= i;
                i--;
            }

        }
        System.out.println(num);
        BitSet set = new BitSet();
    }
}
