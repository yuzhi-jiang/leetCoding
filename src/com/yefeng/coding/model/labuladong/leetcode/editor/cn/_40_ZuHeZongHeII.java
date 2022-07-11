package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 组合总和 II _40_组合总和 II.java
 * @createTime 2022-07-11 21:25:15
 */
//组合总和 II -- combination-sum-ii
public class _40_ZuHeZongHeII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(candidates, target, 0);
            return res;
        }

        private void backtrack(int[] nums, int target, int start) {
            if (target == trackSum) {//目标值 base case
                res.add(new ArrayList<>(track));
                return;
            }
            if (trackSum > target) { //base case
                return;
            }

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 选择
                trackSum += nums[i];
                track.add(nums[i]);

                backtrack(nums, target, i + 1);

                //撤销
                trackSum -= nums[i];
                track.remove(track.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _40_ZuHeZongHeII().new Solution();
        List<List<Integer>> lists = solution.combinationSum2(ArrayUtil.createByArg(10, 1, 2, 7, 6, 1, 5), 8);
        lists.forEach(System.out::println);
    }
}

/*

给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 

 candidates 中的每个数字在每个组合中只能使用 一次 。 

 注意：解集不能包含重复的组合。 

 示例 1: 

 
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
] 

 示例 2: 

 
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
] 

 

 提示: 

 
 1 <= candidates.length <= 100 
 1 <= candidates[i] <= 50 
 1 <= target <= 30 
 
 Related Topics数组 | 回溯 

 👍 1026, 👎 0 

*/

