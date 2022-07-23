package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 重复的DNA序列 _187_重复的DNA序列.java
 * @createTime 2022-07-23 09:58:50
 */
//重复的DNA序列 -- repeated-dna-sequences
public class _187_ZhongFuDeDNAXuLie {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            return solve3(s);
        }

        private List<String> solve3(String s) {
            int R = 4;//进制
            int L = 10;//位数  目标字符串的长度
            int RL = (int) Math.pow(R, L - 1);//进制*位数

            int[] nums = new int[s.length()];//存储字符串的数字表示
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'A' -> nums[i] = 0;
                    case 'C' -> nums[i] = 1;
                    case 'G' -> nums[i] = 2;
                    case 'T' -> nums[i] = 3;
                }
            }

            HashSet<Integer> seen = new HashSet<>();
            HashSet<String> res = new HashSet<>();

            int windowHash = 0;//用四进制表示的窗口的hash值（字符串对应的hash）

            int right = 0, left = 0;
            while (right < s.length()) {


//                System.out.println("windowHash:"+windowHash);
                windowHash = windowHash * R + nums[right];
                right++;

                if (right - left == L) {
//                    System.out.println("10:--->windowHash:"+windowHash);
                    if (seen.contains(windowHash)) {
                        res.add(s.substring(left, right));
                    } else {
                        seen.add(windowHash);
                    }

                    windowHash -= nums[left] * RL;//移除左边的数字  如
                    left++;
                }


            }


            return new ArrayList<>(res);
        }

        private List<String> solve2(String s) {
            HashSet<String> sets = new HashSet<>();

            HashSet<String> res = new HashSet<>();

            for (int i = 0; i + 10 <= s.length(); i++) {
                String str = s.substring(i, i + 10);
                if (!sets.add(str)) {//如果已经存在,返回值位false，取反位true，则加入结果集
                    res.add(str);
                }
            }


            return new ArrayList<String>(res);

        }

        private List<String> solve1(String s) {
            HashMap<String, Integer> map = new HashMap<>();
            List<String> res = new ArrayList<>();

            for (int i = 0; i + 10 <= s.length(); i++) {
                String str = s.substring(i, i + 10);//左闭右开
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            map.forEach((k, v) -> {
                if (v > 1) {//如果重复了，则加入结果集
                    res.add(k);
                }
            });

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _187_ZhongFuDeDNAXuLie().new Solution();
        List<String> list = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(list);

    }

}
/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * <p>
 * 例如， "ACGAATTCCG" 是一个 DNA序列 。
 * <p>
 * <p>
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 10⁵
 * s[i]=='A'、'C'、'G' or 'T'
 * <p>
 * Related Topics位运算 | 哈希表 | 字符串 | 滑动窗口 | 哈希函数 | 滚动哈希
 * <p>
 * 👍 390, 👎 0
 */
