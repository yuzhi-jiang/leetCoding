package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 打家劫舍 _198_打家劫舍.java
 * @createTime 2022-07-22 13:31:37
 */
//打家劫舍 -- house-robber
public class _198_DaJiaJieShe {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {

            return solve3(nums);
        }

        public int solve3(int[] nums) {
            int len = nums.length;

            int dp_i;
            int dp_i_1;
            int dp_i_2;

            dp_i = 0;
            dp_i_1 = 0;
            dp_i_2 = 0;
            for (int i = len - 1; i >= 0; i--) {
                dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }

        public int solve2(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return nums[0];
            }
            if (len == 2) {
                return Math.max(nums[0], nums[1]);
            }

            int[] dp = new int[len + 2];//初始化dp数组0
            //自底向上的动态规划
            for (int i = len - 1; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], //不偷当前房子
                        dp[i + 2] + nums[i]);//偷当前房子
            }
            return dp[0];

        }

        public int solve1(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int[] memo = new int[nums.length];
            Arrays.fill(memo, -1);//原理还是for循环，但是这样写更简洁
            return dp(nums, 0, memo);
        }

        public int dp(int[] nums, int start, int[] memo) {
            if (start >= nums.length) {
                return 0;
            }
            if (memo[start] != -1) {//如果已经计算过，就直接返回
                return memo[start];
            }
            int res = Math.max(
                    dp(nums, start + 1, memo),//不偷当前房子
                    dp(nums, start + 2, memo) + nums[start]);//偷当前房子
            memo[start] = res;//记录结果
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _198_DaJiaJieShe().new Solution();
//        int rob = solution.rob(ArrayUtil.createByArg(1,2,3,1));
        int rob = solution.rob(ArrayUtil.createByArg(114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240));
        System.out.println(rob);
    }
}

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小
 * 偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * Related Topics数组 | 动态规划
 * <p>
 * 👍 2214, 👎 0
 */
