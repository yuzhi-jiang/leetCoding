package com.yefeng.coding.model.labuladong.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

/**
 * [1896]反转表达式值的最少操作次数
 * @author 夜枫
 * 2022-11-06 23:05:19
 */
public class Ti_1896_MinimumCostToChangeTheFinalValueOfExpression {

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int minOperationsToFlip(String expression) {
        int n = expression.length();
        int[][][] dp = new int[n][2][2]; // dp[i][j][k]表示从i位置开始，目标值为j（0或1），在k状态（0表示'&'，1表示'|'）下的最少操作次数

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1; // 初始化为-1表示未计算
                }
            }
        }

        return Math.min(helper(expression, 0, 0, 1, dp), helper(expression, 0, 1, 0, dp)); // 返回取'1'和'0'的最小操作次数
    }

    private int helper(String expression, int start, int target, int state, int[][][] dp) {
        if (dp[start][target][state] != -1) {
            return dp[start][target][state];
        }

        char op = expression.charAt(start);
        if (op == '1') {
            dp[start][target][state] = (target == 1) ? 0 : 1;
        } else if (op == '0') {
            dp[start][target][state] = (target == 0) ? 0 : 1;
        } else if (op == '&') {
            if (state == 0) {
                dp[start][target][state] = Math.min(helper(expression, start + 1, target, 0, dp), helper(expression, start + 1, target, 1, dp));
            } else {
                dp[start][target][state] = helper(expression, start + 1, target, 1, dp);
            }
        } else if (op == '|') {
            if (state == 0) {
                dp[start][target][state] = helper(expression, start + 1, target, 0, dp);
            } else {
                dp[start][target][state] = Math.min(helper(expression, start + 1, target, 0, dp), helper(expression, start + 1, target, 1, dp));
            }
        }

        return dp[start][target][state];
    }
}

//leetcode submit region end(Prohibit modification and deletion)




    public static void main(String[] args) {
        Solution solution = new Ti_1896_MinimumCostToChangeTheFinalValueOfExpression().new Solution();
    }
}

/*



给你一个 有效的 布尔表达式，用字符串 expression 表示。这个字符串包含字符 '1'，'0'，'&'（按位 与 运算），'|'（按位 或 运算），'(' 和 ')' 。

比方说，"()1|1" 和 "(1)&()" 不是有效 布尔表达式。而 "1"， "(((1))|(0))" 和 "1|(0&(1))" 是 有效 布尔表达式。
你的目标是将布尔表达式的 值 反转 （也就是将 0 变为 1 ，或者将 1 变为 0），请你返回达成目标需要的 最少操作 次数。

比方说，如果表达式 expression = "1|1|(0&0)&1" ，它的 值 为 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1 。我们想要执行操作将 新的 表达式的值变成 0 。
可执行的 操作 如下：

将一个 '1' 变成一个 '0' 。
将一个 '0' 变成一个 '1' 。
将一个 '&' 变成一个 '|' 。
将一个 '|' 变成一个 '&' 。
注意：'&' 的 运算优先级 与 '|' 相同 。计算表达式时，括号优先级 最高 ，然后按照 从左到右 的顺序运算。

//给你一个 有效的 布尔表达式，用字符串 expression 表示。这个字符串包含字符 '1'，'0'，'&'（按位 与 运算），'|'（按位 或 运算），
//'(' 和 ')' 。 
//
// 
// 比方说，"()1|1" 和 "(1)&()" 不是有效 布尔表达式。而 "1"， "(((1))|(0))" 和 "1|(0&(1))" 是 有效 布尔表
//达式。 
// 
//
// 你的目标是将布尔表达式的 值 反转 （也就是将 0 变为 1 ，或者将 1 变为 0），请你返回达成目标需要的 最少操作 次数。 
//
// 
// 比方说，如果表达式 expression = "1|1|(0&0)&1" ，它的 值 为 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 
//1&1 = 1 。我们想要执行操作将 新的 表达式的值变成 0 。 
// 
//
// 可执行的 操作 如下： 
//
// 
// 将一个 '1' 变成一个 '0' 。 
// 将一个 '0' 变成一个 '1' 。 
// 将一个 '&' 变成一个 '|' 。 
// 将一个 '|' 变成一个 '&' 。 
// 
//
// 注意：'&' 的 运算优先级 与 '|' 相同 。计算表达式时，括号优先级 最高 ，然后按照 从左到右 的顺序运算。 
//
// 
//
// 示例 1： 
//
// 输入：expression = "1&(0|1)"
//输出：1
//解释：我们可以将 "1&(0|1)" 变成 "1&(0&1)" ，执行的操作为将一个 '|' 变成一个 '&' ，执行了 1 次操作。
//新表达式的值为 0 。
// 
//
// 示例 2： 
//
// 输入：expression = "(0&0)&(0&0&0)"
//输出：3
//解释：我们可以将 "(0&0)&(0&0&0)" 变成 "(0|1)|(0&0&0)" ，执行了 3 次操作。
//新表达式的值为 1 。
// 
//
// 示例 3： 
//
// 输入：expression = "(0|(1|0&1))"
//输出：1
//解释：我们可以将 "(0|(1|0&1))" 变成 "(0|(0|0&1))" ，执行了 1 次操作。
//新表达式的值为 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 10⁵ 
// expression 只包含 '1'，'0'，'&'，'|'，'(' 和 ')' 
// 所有括号都有与之匹配的对应括号。 
// 不会有空的括号（也就是说 "()" 不是 expression 的子字符串）。 
// 
//
// Related Topics栈 | 数学 | 字符串 | 动态规划 
//
// 👍 29, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


*/