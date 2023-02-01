package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 划分字母区间 _763_划分字母区间.java
 * @createTime 2022-07-24 18:05:40
 */
//划分字母区间 -- partition-labels
public class _763_HuaFenZiMuQuJian {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            return solve(s);
        }

        private List<Integer> solve2(String s) {
            LinkedList<Integer> res = new LinkedList<>();
            HashMap<Character, Integer> lastMap = new HashMap<>(26);
            for (int i = 0; i < s.length(); i++) {
//                last[s.charAt(i) - 'a'] = i;
                lastMap.put(s.charAt(i), i);
            }


            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int last = lastMap.get(s.charAt(i));
                if (i == last) {
                    res.add(last - start + 1);
                    start = i + 1;
                }
            }

            return res;
        }

        private List<Integer> solve(String s) {
            LinkedList<Integer> res = new LinkedList<>();
            int[] last = new int[26];

            for (int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);//最大的end
                if (i == end) {//当前i位置是最大end位置,即实习自己就是最大end位置
                    res.add(end - start + 1);
                    start = end + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _763_HuaFenZiMuQuJian().new Solution();
        System.out.println(solution.partitionLabels("caedbdedda"));
    }
}

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * Related Topics贪心 | 哈希表 | 双指针 | 字符串
 * <p>
 * 👍 777, 👎 0
 */
