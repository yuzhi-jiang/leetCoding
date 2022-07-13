import java.util.HashMap;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 无重复字符的最长子串 _3_无重复字符的最长子串.java
 * @createTime 2022-07-14 00:30:42
 */
//无重复字符的最长子串 -- longest-substring-without-repeating-characters
public class _3_WuZhongFuZiFuDeZuiZhangZiChuan {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int len = 0;//边界值
            HashMap<Character, Integer> windows = new HashMap<>();//记录我有的(一定是需要里的)

            while (right < s.length()) {
                char c = s.charAt(right);//即将放进去的字符
                right++;//窗口扩大
                //扩大后逻辑
                //跟新数据
                windows.put(c, windows.getOrDefault(c, 0) + 1);

                while (windows.get(c) > 1) {//出现重复则缩容
                    char ans = s.charAt(left);
                    left++;
                    windows.put(ans, windows.get(ans) - 1);
                }
                //收缩后到这是 [left..right)是不重复的  r-l=len就是长度
                len = Math.max(right - left, len);
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _3_WuZhongFuZiFuDeZuiZhangZiChuan().new Solution();
        int len = solution.lengthOfLongestSubstring("");
        System.out.println(len);
    }
}

/*
  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
  
  
  
  示例 1:
  
  
  输入: s = "abcabcbb"
  输出: 3
  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
  
  
  示例 2:
  
  
  输入: s = "bbbbb"
  输出: 1
  解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
  
  
  示例 3:
  
  
  输入: s = "pwwkew"
  输出: 3
  解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
       请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
  
  
  
  
  提示：
  
  
  0 <= s.length <= 5 * 10⁴
  s 由英文字母、数字、符号和空格组成
  
  Related Topics哈希表 | 字符串 | 滑动窗口
  
  👍 7818, 👎 0
 */
