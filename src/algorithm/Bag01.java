package algorithm;
/**
 * n个物品和1个背包，每个物品i对应的重量为wi，价值为vi，背包的容量为W。
 * 每个物品只有一件，要么装入，要么不装入，不可拆分。
 * 如何选取物品装入背包，使背包所装入的物品的总价值最大？
 */

/**
 * dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
 * 1、 确定dp数组的定义
 * 在一维dp数组中，dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
 * 2、一维dp数组的递推公式
 * dp[j]为 容量为j的背包所背的最大价值
 * dp[j]可以通过dp[j - weight[i]]推导出来，dp[j - weight[i]]表示容量为j - weight[i]的背包所背的最大价值。
 * dp[j - weight[i]] + value[i] 表示 容量为 j - 物品i重量 的背包 加上 物品i的价值。（也就是容量为j的背包，放入物品i了之后的价值即：dp[j]）
 * 此时dp[j]有两个选择，一个是取自己dp[j]，一个是取dp[j - weight[i]] + value[i]，指定是取最大的
 * 所以递归公式为：
 * dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
 * <p>
 * 3、一维dp数组初始化
 * dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]，那么dp[0]就应该是0，因为背包容量为0所背的物品的最大价值就是0。
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
        new Bag01().wei_bag_problem(weight, value, w);
    }

}
