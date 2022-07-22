package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 买卖股票的最佳时机 _121_买卖股票的最佳时机.java
 * @createTime 2022-07-16 10:37:20
 */


/*      k 指的是最大交易次数
dp[-1][...][0] = 0
解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0。

dp[-1][...][1] = -infinity
解释：还没开始的时候，是不可能持有股票的。
因为我们的算法要求一个最大值，所以初始值设为一个最小值，方便取最大值。

dp[...][0][0] = 0
解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0。

dp[...][0][1] = -infinity
解释：不允许交易的情况下，是不可能持有股票的。
因为我们的算法要求一个最大值，所以初始值设为一个最小值，方便取最大值。

---------------------------------------------------------------
base case：
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity

状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

 */
//买卖股票的最佳时机 -- best-time-to-buy-and-sell-stock
public class _121_MaiMaiGuPiaoDeZuiJiaShiJi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            // 力扣121.买卖股票的最佳时机
//            int[][] dp = new int[prices.length][2];
//        dp[-1][0] = 0;
//        dp[-1][1] = Integer.MIN_VALUE;

            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;

            for (int i = 0; i < prices.length; i++) {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }
//            for (int i = 0; i < prices.length; i++) {
//                if (i == 0) {
//                    dp[i][0] = 0;
//                    dp[i][1] = -prices[i];
//                    continue;
//                }
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//            }


//            return dp[prices.length - 1][0];
            return dp_i_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _121_MaiMaiGuPiaoDeZuiJiaShiJi().new Solution();
        int res = solution.maxProfit(ArrayUtil.createByArg(7, 1, 5, 3, 6, 4));
        System.out.println(res);
    }
}

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁴
 * <p>
 * Related Topics数组 | 动态规划
 * <p>
 * 👍 2446, 👎 0
 */
