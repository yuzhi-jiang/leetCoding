package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 买卖股票的最佳时机 II _122_买卖股票的最佳时机 II.java
 * @createTime 2022-07-18 21:55:50
 */
//买卖股票的最佳时机 II -- best-time-to-buy-and-sell-stock-ii
public class _122_MaiMaiGuPiaoDeZuiJiaShiJiII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return solve2(prices);
        }

        public int solve1(int[] prices) {
            //原始版本
            int n = prices.length;
            int dp[][] = new int[n][2];
//        dp[-1][k][0]=0;
//        dp[-1][k][1]=Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
//            dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]); k~=k-1所以可以不计入k
//            dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                if (i == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];//第一天买入，利润为负price[0]
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }

        //方法二：动态规划，空间复杂度O(1)
        public int solve2(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0;
            int dp_i_1 = -prices[0];
            for (int i = 1; i < n; i++) {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
            }
            return dp_i_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _122_MaiMaiGuPiaoDeZuiJiaShiJiII().new Solution();
        System.out.println(solution.maxProfit(ArrayUtil.createByArg(1, 2, 3, 4, 5)));
    }
}

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 3 * 10⁴
 * 0 <= prices[i] <= 10⁴
 * <p>
 * Related Topics贪心 | 数组 | 动态规划
 * <p>
 * 👍 1764, 👎 0
 */
