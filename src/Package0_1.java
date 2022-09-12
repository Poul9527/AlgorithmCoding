import java.util.Arrays;

public class Package0_1 {

    public void wei_bag_problem() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        // ��ʼ��
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) { // ������Ʒ
            for (int j = bagWeight; j >= weight[i]; j--) { // ������������
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 4};
        int[] value = {10, 15, 20, 30};
        int w = 5;
        new Bag01().wei_bag_problem(weight, value, w);
    }

    void test_2_wei_bag_problem1() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        // ��ά����
        int[][] dp = new int[weight.length + 1][bagWeight + 1];

        // ��ʼ��
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }

        // weight����Ĵ�С ������Ʒ����
        for (int i = 1; i < weight.length; i++) { // ������Ʒ
            for (int j = 0; j <= bagWeight; j++) { // ������������
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }

            }
        }

        System.out.println(dp[weight.length - 1][bagWeight]);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == (amount + 1)) ? -1 : dp[amount];
    }


}


