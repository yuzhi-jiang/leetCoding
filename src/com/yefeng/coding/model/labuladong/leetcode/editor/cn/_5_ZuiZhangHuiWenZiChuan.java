package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 最长回文子串 _5_最长回文子串.java
 * @createTime 2022-07-12 17:13:02
 */
//最长回文子串 -- longest-palindromic-substring
public class _5_ZuiZhangHuiWenZiChuan {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {

                String s1 = palindrome(s, i, i + 1);
                String s2 = palindrome(s, i, i);

                if (s1.length() > res.length()) {
                    res = s1;
                }
                if (s2.length() > res.length()) {
                    res = s2;
                }
            }
            System.out.println(res);
            return res;
        }

        public String palindrome(String s, int l, int r) {

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
            }
            //这个时候，l和r 指向的是不等的  ->  s[l]!=s[r]  所以 s[l+1]=s[r-1];
//            while (l>0&&r<s.length()){
//                if (s.charAt(l)!=s.charAt(r)){
//                    break;
//                }
//                --l;
//                ++r;
//            }
            return s.substring(l + 1, r);//左闭右开
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _5_ZuiZhangHuiWenZiChuan().new Solution();
        solution.longestPalindrome("babad");
//        String str="babad";
//        System.out.println(str.substring(0, 2));
    }
}

/*
  给你一个字符串 s，找到 s 中最长的回文子串。

  示例 1：
  输入：s = "babad"
  输出："bab"
  解释："aba" 同样是符合题意的答案。

  示例 2：

  输入：s = "cbbd"
  输出："bb"


  提示：

  1 <= s.length <= 1000
  s 仅由数字和英文字母组成

  Related Topics字符串 | 动态规划

  👍 5443, 👎 0
 */
