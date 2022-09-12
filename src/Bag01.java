/**
 * n个物品和1个背包，每个物品i对应的重量为wi，价值为vi，背包的容量为W。
 * 每个物品只有一件，要么装入，要么不装入，不可拆分。
 * 如何选取物品装入背包，使背包所装入的物品的总价值最大？
 */

public class Bag01 {

    public void wei_bag_problem(int[] weight, int[] value, int w) {

        // 初始化
        int[] dp = new int[w + 1];
        dp[0] = 0;
        // 遍历物品
        for (int i = 0; i < weight.length; i++) {
            // 遍历背包容量
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
