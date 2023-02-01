package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 去除重复字母 _316_去除重复字母.java
 * @createTime 2022-07-27 13:31:09
 */
//去除重复字母 -- remove-duplicate-letters
public class _316_QuChuZhongFuZiMu {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public String solve1(String s) {
            Stack<Character> stack = new Stack<>();
            byte[] count = new byte[26];//每个字符的个数
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            boolean[] visited = new boolean[26];//栈里面是否已经有了这个字符
            for (char c : s.toCharArray()) {
                count[c - 'a']--;//当前个数减1
                if (visited[c - 'a']) {
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > c) {
                    if (count[stack.peek() - 'a'] == 0) {
                        break;//当前元素的个数为0,不能再出栈
                    }
                    visited[stack.pop() - 'a'] = false;//因为栈里面没有相同元素,所以pop后,viisited里面的元素也要改为false
                }
                stack.push(c);
                visited[c - 'a'] = true;
            }


            StringBuilder sbRes = new StringBuilder();//接收出栈结果
            while (!stack.isEmpty()) {
                sbRes.append(stack.pop());
            }
            return sbRes.reverse().toString();

        }

        public String removeDuplicateLetters(String s) {
            Stack<Byte> stack = new Stack<>();
            int[] count = new int[26];//每个字符的个数
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            boolean[] visited = new boolean[26];//栈里面是否已经有了这个字符
            for (char c : s.toCharArray()) {
                count[c - 'a']--;//当前个数减1
                if (visited[c - 'a']) {
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > (c - 'a')) {
                    if (count[stack.peek()] == 0) {
                        break;//当前元素的个数为0,不能再出栈
                    }
                    visited[stack.pop()] = false;//因为栈里面没有相同元素,所以pop后,viisited里面的元素也要改为false
                }

                stack.push((byte) (c - 'a'));
                visited[c - 'a'] = true;
            }


//            StringBuilder sbRes = new StringBuilder();//接收出栈结果
            char[] res = new char[stack.size()];//接收出栈结果
            int rIndex = stack.size() - 1;
            while (!stack.isEmpty()) {
                res[rIndex--] = (char) (stack.pop() + 'a');

//                sbRes.append((char)(stack.pop()+'a'));
//                sbRes.append(stack.pop());
            }
//            return sbRes.reverse().toString();
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _316_QuChuZhongFuZiMu().new Solution();

        System.out.println(solution.removeDuplicateLetters("bcabc"));
    }
}

/*
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 

 

 示例 1： 

 
输入：s = "bcabc"
输出："abc"
 

 示例 2： 

 
输入：s = "cbacdcbc"
输出："acdb" 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 由小写英文字母组成 
 

 

 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-
characters 相同 
 Related Topics栈 | 贪心 | 字符串 | 单调栈 

 👍 776, 👎 0 

*/
