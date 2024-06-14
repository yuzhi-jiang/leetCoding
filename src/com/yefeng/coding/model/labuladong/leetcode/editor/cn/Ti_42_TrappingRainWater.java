package com.yefeng.coding.model.labuladong.leetcode.editor.cn;


/**
 * [42]接雨水
 * @author 夜枫
 * 2022-11-06 23:05:19
 */
public class Ti_42_TrappingRainWater {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        return trap_solution(height);
    }

    public int trap_solution(int[] height) {
        //height=min(l_max,r_max) - height
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];

        l_max[0] = height[0];
        r_max[height.length - 1] = height[height.length - 1];

        int res_sum=0;
        for (int i = 1; i < height.length; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--){
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int min_max = Math.min(l_max[i], r_max[i]);
            res_sum=res_sum+(min_max-height[i]);
        }
        return res_sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)




    public static void main(String[] args) {
        Solution solution = new Ti_42_TrappingRainWater().new Solution();
        //todo call solution
    }
}

/*

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 5189, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


*/