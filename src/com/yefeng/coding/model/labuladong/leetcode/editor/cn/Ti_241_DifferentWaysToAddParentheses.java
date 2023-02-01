package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夜枫
 * 2022-11-06 23:05:19
 */
public class Ti_241_DifferentWaysToAddParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> result = new ArrayList<>();
            int length = expression.length();
            for (int i = 0; i < length; i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (Integer l : left) {
                        for (Integer r : right) {
                            if (c == '+') result.add(l + r);
                            if (c == '-') result.add(l - r);
                            if (c == '*') result.add(l * r);
                        }
                    }
                }
            }
            //base case
            //如果 res 为空，说明算式是一个数字，没有运算符
            if (result.isEmpty()) {
                result.add(Integer.valueOf(expression));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Ti_241_DifferentWaysToAddParentheses().new Solution();
        List<Integer> integers = solution.diffWaysToCompute("2*3-4*5");
        integers.stream().forEach(System.out::println);
    }
}

/**
 * //给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * //
 * // 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：expression = "2-1-1"
 * //输出：[0,2]
 * //解释：
 * //((2-1)-1) = 0
 * //(2-(1-1)) = 2
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：expression = "2*3-4*5"
 * //输出：[-34,-14,-10,-10,10]
 * //解释：
 * //(2*(3-(4*5))) = -34
 * //((2*3)-(4*5)) = -14
 * //((2*(3-4))*5) = -10
 * //(2*((3-4)*5)) = -10
 * //(((2*3)-4)*5) = 10
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= expression.length <= 20
 * // expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * // 输入表达式中的所有整数值在范围 [0, 99]
 * //
 * //
 * // Related Topics递归 | 记忆化搜索 | 数学 | 字符串 | 动态规划
 * //
 * // 👍 764, 👎 0
 * //
 * //
 * //
 * //
 */