package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName _46_全排列.java
 * @createTime 2022-07-10 15:11:51
 */
//全排列 -- permutations
public class _46_全排列 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();  //结果

        public List<List<Integer>> permute(int[] nums) {


            boolean[] used = new boolean[nums.length]; //是否使用过
            LinkedList<Integer> track = new LinkedList<>();//每条路径
            backtrack(nums, track, used);
            return res;
        }

        void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            //结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }
            // 做选择
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;              //存在该数
                }
                //做选择
                used[i] = true;
                track.addLast(nums[i]);
                //回溯
                backtrack(nums, track, used);
                //撤销选择
                track.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _46_全排列().new Solution();

        List<List<Integer>> lsit = solution.permute(ArrayUtil.createByArg(1, 2, 3));

    }
}


/*
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics数组 | 回溯 
//
// 👍 2099, 👎 0 
//
//
//
//

*/

