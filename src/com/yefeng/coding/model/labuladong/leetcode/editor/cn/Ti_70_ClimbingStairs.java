package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

/**
 * @author 夜枫
 * 2022-11-06 23:25:36
 * 爬楼梯
 */
public class Ti_70_ClimbingStairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int climbStairs(int n) {
            if (n <= 2) return n;

//            System.out.println("res-> "+solve1(n));
            return solve2(n);
        }

        public int solve2(int n) {
            int dp_i_1;
            int dp_i_2;
            int dp_i = 3;

            dp_i_1 = 1;
            dp_i_2 = 2;
            for (int i = 2; i < n; ++i) {
                dp_i = dp_i_1 + dp_i_2;
                dp_i_1 = dp_i_2;
                dp_i_2 = dp_i;
            }
            return dp_i;
        }

        public int solve1(int n) {

            memo = new int[n + 1];
            return dp(n);
        }

        public int dp(int n) {
            if (n <= 2) return n;
            if (memo[n] > 0) return memo[n];

            int sum = dp(n - 1) + dp(n - 2);
            memo[n] = sum;
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Ti_70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(4));
    }
}

