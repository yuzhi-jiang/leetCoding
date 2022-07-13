package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 找到字符串中所有字母异位词 _438_找到字符串中所有字母异位词.java
 * @createTime 2022-07-13 23:43:50
 */
//找到字符串中所有字母异位词 -- find-all-anagrams-in-a-string
public class _438_ZhaoDaoZiFuChuanZhongSuoYouZiMuYiWeiCi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> findAnagrams(String s, String p) {
            int l = 0, r = 0;
            int len = Integer.MAX_VALUE;
            int start = 0;
            int valid = 0;

            int pSize = p.length();

            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> windows = new HashMap<>();
            char c;
            for (int i = 0; i < pSize; i++) {
                c = p.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            while (r < s.length()) {
                c = s.charAt(r);
                r++;

                if (need.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                while (r - l >= pSize) {
                    if (valid == need.size()) {
                        //找到一个结果 ,不返回，直接加入结果，后续继续缩容操作
                        res.add(l);
                    }
                    c = s.charAt(l);
                    l++;//缩容
                    if (need.containsKey(c)) {
                        if (windows.get(c).equals(need.get(c))) {
                            valid--;
                        }
                        windows.put(c, windows.get(c) - 1);
                    }
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _438_ZhaoDaoZiFuChuanZhongSuoYouZiMuYiWeiCi().new Solution();
        List<Integer> list = solution.findAnagrams("abab", "ab");

        System.out.println(list);
    }
}

/*
  给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

  异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

  示例 1:

  输入: s = "cbaebabacd", p = "abc"
  输出: [0,6]
  解释:
  起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
  起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。


  示例 2:


  输入: s = "abab", p = "ab"
  输出: [0,1,2]
  解释:
  起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
  起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
  起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。




  提示:


  1 <= s.length, p.length <= 3 * 10⁴
  s 和 p 仅包含小写字母

  Related Topics哈希表 | 字符串 | 滑动窗口

  👍 941, 👎 0
 */
