public class MatrixMultiply {

/*   现有a数组长度为100，b数据长度为1000000，请编写一种或者多种代码请求b 和 a矩阵相乘的总和,
并阐述自己代码的时间复杂度，空间复杂度，以及编写这种代码的优缺点。
举例 b [ 1, 2, 3] , a[1,2]  结果为 1*1 + 1* 2 + 2 * 1 + 2 * 2 + 3*1 + 3 * 2 = 18.
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
