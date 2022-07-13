package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 反转字符串 _344_反转字符串.java
 * @createTime 2022-07-12 17:00:48
 */
//反转字符串 -- reverse-string
public class _344_FanZhuanZiFuChuan {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int l = 0;
            int r = s.length - 1;

            //左右指针相向而行 ，相互替换
            while (l < r) {//没有必要相等，相等即自己交换自己
                char t = s[l];
                s[l] = s[r];
                s[r] = t;
                ++l;
                --r;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _344_FanZhuanZiFuChuan().new Solution();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};

        System.out.println(s);
        solution.reverseString(s);
        System.out.println(s);
    }
}

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] 都是 ASCII 码表中的可打印字符
 * <p>
 * Related Topics递归 | 双指针 | 字符串
 * <p>
 * 👍 619, 👎 0
 */
