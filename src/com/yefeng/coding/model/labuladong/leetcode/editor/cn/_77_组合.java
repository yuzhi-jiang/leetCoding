package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName _77_组合.java
 * @createTime 2022-07-11 20:12:57
 */
//组合 -- combinations
public class _77_组合 {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>(2);

        public List<List<Integer>> combine(int n, int k) {
            backtrack(n, k, 1);
            return res;
        }

        private void backtrack(int n, int k, int start) {
            if (track.size() == k) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = start; i <= n; ++i) {
                //选择
                track.add(i);

                backtrack(n, k, i + 1);

                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _77_组合().new Solution();
        List<List<Integer>> lists = solution.combine(4, 2);
        lists.forEach(System.out::println);
    }
}

/*

  给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

  你可以按 任何顺序 返回答案。



  示例 1：


  输入：n = 4, k = 2
  输出：
  [
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
  ]

  示例 2：


  输入：n = 1, k = 1
  输出：[[1]]



  提示：


  1 <= n <= 20
  1 <= k <= n

  Related Topics回溯

  👍 1048, 👎 0
 */
