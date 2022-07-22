package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 打家劫舍 II _213_打家劫舍 II.java
 * @createTime 2022-07-22 14:00:31
 */
//打家劫舍 II -- house-robber-ii
public class _213_DaJiaJieSheII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            return solve1(nums);
//            return funDp(nums,0,nums.length-1);
        }

        public int solve1(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(
                    funDp(nums, 0, nums.length - 2),//0到倒数第二
                    funDp(nums, 1, nums.length - 1)//1到倒数第一
            );
        }

        //偷在nums[start, end]的值//策略默认是偷最后一家房子
        public int funDp(int[] nums, int start, int end) {//左闭右开
            int dp_i;
            int dp_i_1;
            int dp_i_2;
            dp_i = 0;
            dp_i_1 = 0;
            dp_i_2 = 0;
            for (int i = end; i >= start; i--) {
                dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _213_DaJiaJieSheII().new Solution();
        int rob = solution.rob(ArrayUtil.createByArg(1));
        System.out.println(rob);
    }
}

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
 * 装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * Related Topics数组 | 动态规划
 * <p>
 * 👍 1103, 👎 0
 */
