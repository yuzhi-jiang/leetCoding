package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 子集 II _90_子集 II.java
 * @createTime 2022-07-11 21:26:25
 */
//子集 II -- subsets-ii
public class _90_ZiJiII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int start) {
            res.add(new ArrayList<>(track));

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                //选
                track.add(nums[i]);

                backtrack(nums, i + 1);

                //撤销
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _90_ZiJiII().new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(ArrayUtil.createByArg(1, 2, 2));
        lists.forEach(System.out::println);
    }
}

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 

 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 

 
 
 

 示例 1： 

 
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 

 示例 2： 

 
输入：nums = [0]
输出：[[],[0]]
 

 

 提示： 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 
 
 
 Related Topics位运算 | 数组 | 回溯 

 👍 874, 👎 0 

*/
