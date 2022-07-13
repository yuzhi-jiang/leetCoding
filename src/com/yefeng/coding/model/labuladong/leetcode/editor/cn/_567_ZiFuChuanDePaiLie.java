import java.util.HashMap;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 字符串的排列 _567_字符串的排列.java
 * @createTime 2022-07-13 23:56:32
 */
//字符串的排列 -- permutation-in-string
public class _567_ZiFuChuanDePaiLie {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int left = 0;
            int right = 0;
            int start = 0;
            int len = Integer.MAX_VALUE;
            int valid = 0;

            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> windows = new HashMap<>();
            char c;
            for (int i = 0; i < s1.length(); i++) {
                c = s1.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);//need[c]++;
            }

            while (right < s2.length()) {//左闭右开
                c = s2.charAt(right);
                right++;

                if (need.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //缩容
                while (right - left >= s1.length()) {//每次窗口一到目标大小，就判断是否满足条件（此时满足，则必定为真）  这里写>=是编程习惯  严格来将是==
                    // 在这里判断是否找到了合法的子串
                    if (valid == need.size())
                        return true;
                    char d = s2.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (windows.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        windows.put(d, windows.get(d) - 1);//windows[c]--
                    }
                }

//            while (valid == need.size()) {
//                int temp = right - left;
//                if (temp < len) {
//                    start = left;
//                    len = temp;
//                }
//                if (len == s1.length()) {
//                    return true;
//                }
//                c = s2.charAt(left);
//                left++;
//                if (need.containsKey(c)) {
//                    if (windows.get(c).equals(need.get(c))) {
//                        valid--;
//                    }
//                    windows.put(c, windows.get(c) - 1);//windows[c]--
//                }
//            }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _567_ZiFuChuanDePaiLie().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidoooba"));

    }
}

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 10⁴
 * s1 和 s2 仅包含小写字母
 * <p>
 * Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口
 * <p>
 * 👍 719, 👎 0
 */
