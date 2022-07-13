package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 最小覆盖子串 _76_最小覆盖子串.java
 * @createTime 2022-07-13 23:12:30
 */
//最小覆盖子串 -- minimum-window-substring
public class _76_ZuiXiaoFuGaiZiChuan {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int left = 0;
            int right = 0;
            int start = 0;
            int len = Integer.MAX_VALUE;
            int valid = 0;//有效的个数，，满足题目要求的个数
            HashMap<Character, Integer> windows = new HashMap<>();//记录我有的(一定是需要里的)
            HashMap<Character, Integer> need = new HashMap<>();//记录需要的

            for (int i = 0; i < t.length(); i++) {
                need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
            }

            while (right < s.length()) {
                char c = s.charAt(right);//即将放进去的字符
                right++;//窗口扩大

                //扩大后逻辑

                if (need.containsKey(c)) {//是题目要求的
                    //跟新数据
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c).equals(need.get(c))) {//一个字符的个数已经达到题目要求，如题目要aac,我有aab,则a符合，此时符合个数加一
                        valid++;
                    }
                }


                //是否需要缩小窗口,有效个数已经达到题目要求，（找到了一个解，但是不最小最优解）
                while (valid == need.size()) {
                    //找到一个解，需要判断是否比当前优
                    int temp = right - left;
                    if (temp < len) {
                        start = left;
                        len = temp;
                    }
                    c = s.charAt(left);//取出
                    left++;

                    //看看移除的是否是需要的
                    if (need.containsKey(c)) {
                        if (windows.get(c).equals(need.get(c))) {//是否原本符合 题目
                            valid--;
                        }
                        windows.put(c, windows.get(c) - 1);//我有的那个字符的个数减一（可能不只一个）
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _76_ZuiXiaoFuGaiZiChuan().new Solution();
        String str = solution.minWindow("a", "a");
        System.out.println(str);
    }
}

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length, t.length <= 10⁵
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics哈希表 | 字符串 | 滑动窗口
 * <p>
 * 👍 1984, 👎 0
 */
