package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 买卖股票的最佳时机 III _123_买卖股票的最佳时机 III.java
 * @createTime 2022-07-18 22:07:14
 */
//买卖股票的最佳时机 III -- best-time-to-buy-and-sell-stock-iii
public class _123_MaiMaiGuPiaoDeZuiJiaShiJiIII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int max_k = 2;

            int[][][] dp = new int[n][max_k + 1][2];
//        dp[-1][..][0] = 0;
//        dp[-1][..][1] = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int k = 1; k <= max_k; k++) {
                    if (i == 0) {
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];//dp[i-1][k-1][0]-prices[i] ==== 0-prices[i]
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][max_k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _123_MaiMaiGuPiaoDeZuiJiaShiJiIII().new Solution();
        System.out.println(solution.maxProfit(ArrayUtil.createByArg(3, 3, 5, 0, 0, 3, 1, 4)));
    }
}

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：prices = [1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁵
 * <p>
 * Related Topics数组 | 动态规划
 * <p>
 * 👍 1175, 👎 0
 */
