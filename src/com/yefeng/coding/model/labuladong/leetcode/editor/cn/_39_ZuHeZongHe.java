package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 组合总和 _39_组合总和.java
 * @createTime 2022-07-11 22:52:13
 */
//组合总和 -- combination-sum
public class _39_ZuHeZongHe {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        int targetSum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, target, 0);
            return res;
        }

        private void backtrack(int[] nums, int target, int start) {
            //start 从start开始，如果从0，就有很多重复，如2-3    3-2  然后又 2-3  直到sum>target而且会出现重复如：223  232 322
            if (target == targetSum) {
                res.add(new ArrayList<>(track));
                return;
            }
            if (target < targetSum) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                //选择
                track.add(nums[i]);

                targetSum += nums[i];


                backtrack(nums, target, i);
                track.remove(track.size() - 1);
                targetSum -= nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _39_ZuHeZongHe().new Solution();
        List<List<Integer>> lists = solution.combinationSum(ArrayUtil.createByArg(2, 3, 6, 7), 7);
        lists.forEach(System.out::println);
    }
}

/*
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所
有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 

 candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 

 

 示例 1： 

 
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。 

 示例 2： 

 
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]] 

 示例 3： 

 
输入: candidates = [2], target = 1
输出: []
 

 

 提示： 

 
 1 <= candidates.length <= 30 
 1 <= candidates[i] <= 200 
 candidate 中的每个元素都 互不相同 
 1 <= target <= 500 
 
 Related Topics数组 | 回溯 

 👍 2056, 👎 0 

*/
