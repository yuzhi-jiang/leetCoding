package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName _78_子集.java
 * @createTime 2022-07-11 19:45:45
 */
//子集 -- subsets
public class _78_子集 {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> track = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            res.add(new ArrayList<>(track));

            for (int i = start; i < nums.length; ++i) {
                //做选择
                track.add(nums[i]);
                backtrack(nums, i + 1);//i+1 而不是start+1  因为选择了i下一次就选择i+1
                //撤销
                track.remove(track.size() - 1);//移动的是下标
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

        Solution solution = new _78_子集().new Solution();

        List<List<Integer>> list = solution.subsets(ArrayUtil.createByArg(1, 2, 3));

        list.forEach(System.out::println);
    }
}

/*
  给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
  
  解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

  示例 1：

  输入：nums = [1,2,3]
  输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  
  示例 2：
  输入：nums = [0]
  输出：[[],[0]]

  提示：

  1 <= nums.length <= 10
  -10 <= nums[i] <= 10
  nums 中的所有元素 互不相同
  
  Related Topics位运算 | 数组 | 回溯
  
  👍 1704, 👎 0
 */
