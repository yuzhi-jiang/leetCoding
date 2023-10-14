package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName _72_编辑距离.java
 * @createTime 2022-07-10 15:17:17
 */
//编辑距离 -- edit-distance
public class _72_编辑距离 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
//     方法一
            return solve2(word1, word2);
        }

        private int solve2(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1]; //dp[i][j] word1（0..i）到word2(0..j)要的最少操作数
//        base case
            for (int i = 1; i <= len1; ++i) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= len2; ++j) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= len1; ++i) {
                for (int j = 1; j <= len2; ++j) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        // 什么都不做
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(
                                dp[i - 1][j - 1] + 1,//替换
                                dp[i - 1][j] + 1,//添加
                                dp[i][j - 1] + 1//删除
                        );
                    }
                }
            }
            return dp[len1][len2];
        }

        private int solve1(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();

            int[][] memo = new int[len1][len2];

            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            return dpf(word1, word2, len1 - 1, len2 - 1, memo);
        }

        public int dpf(String s1, String s2, int i, int j, int[][] memo) {
            if (i == -1) return j + 1;//添加
            if (j == -1) return i + 1;//删除
            if (memo[i][j] != -1) return memo[i][j];
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dpf(s1, s2, i - 1, j - 1, memo);//什么都不干，做下一步
            } else {//试错三部，增加，删除，修改 取最小
                memo[i][j] = min(dpf(s1, s2, i - 1, j - 1, memo) + 1,//替换
                        dpf(s1, s2, i - 1, j, memo) + 1,//删除
                        dpf(s1, s2, i, j - 1, memo) + 1//添加
                );

            }
            return memo[i][j];
        }

        private int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _72_编辑距离().new Solution();
        int len = solution.minDistance("horse", "ros");
        System.out.println(len);
    }
}

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * Related Topics字符串 | 动态规划
 * <p>
 * 👍 2468, 👎 0
 */
