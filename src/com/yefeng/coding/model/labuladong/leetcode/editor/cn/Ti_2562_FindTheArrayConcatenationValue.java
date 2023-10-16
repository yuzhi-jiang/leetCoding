package com.yefeng.coding.model.labuladong.leetcode.editor.cn;


import com.yefeng.coding.util.ArrayUtil;

/**
 * [2562]找出数组的串联值
 *
 * @author 夜枫
 * 2022-11-06 23:05:19
 */
public class Ti_2562_FindTheArrayConcatenationValue {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            int left, rigth;
            left = 0;
            rigth = nums.length - 1;
            long sum = 0;
            while (left < rigth) {
                int a = nums[left++];
                int b = nums[rigth--];
                sum += (long) a * Math.pow(10, (int) Math.log10(b) + 1) + b;
            }
            return left == rigth ? (sum + nums[left]) : sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Ti_2562_FindTheArrayConcatenationValue().new Solution();
        long theArrayConcVal = solution.findTheArrayConcVal(ArrayUtil.createByArg(5, 14, 13, 8, 12));
        System.out.printf(String.valueOf(theArrayConcVal));
    }
}

