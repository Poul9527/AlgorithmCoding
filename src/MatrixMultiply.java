public class MatrixMultiply {

/*   ����a���鳤��Ϊ100��b���ݳ���Ϊ1000000�����дһ�ֻ��߶��ִ�������b �� a������˵��ܺ�,
�������Լ������ʱ�临�Ӷȣ��ռ临�Ӷȣ��Լ���д���ִ������ȱ�㡣
���� b [ 1, 2, 3] , a[1,2]  ���Ϊ 1*1 + 1* 2 + 2 * 1 + 2 * 2 + 3*1 + 3 * 2 = 18.
*/

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {1, 2, 3};
        System.out.println(multiply(a, b));
    }

    public static int multiply(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int temp = a[i] * b[j];
                result += temp;
            }
        }
        return result;
    }

}
