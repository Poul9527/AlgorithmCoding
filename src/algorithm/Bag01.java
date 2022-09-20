package algorithm;

/**
 * n����Ʒ��1��������ÿ����Ʒi��Ӧ������Ϊwi����ֵΪvi������������ΪW��
 * ÿ����Ʒֻ��һ����Ҫôװ�룬Ҫô��װ�룬���ɲ�֡�
 * ���ѡȡ��Ʒװ�뱳����ʹ������װ�����Ʒ���ܼ�ֵ���
 */

public class Bag01 {

    public void wei_bag_problem(int[] weight, int[] value, int w) {

        // ��ʼ��
        int[] dp = new int[w + 1];
        dp[0] = 0;
        // ������Ʒ
        for (int i = 0; i < weight.length; i++) {
            // ������������
            for (int j = w; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[w]);
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int w = 4;
        new Bag01().wei_bag_problem(weight,value,w);
    }

}
