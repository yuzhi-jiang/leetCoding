package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.Random;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 按权重随机选择 _528_按权重随机选择.java
 * @createTime 2022-07-23 13:10:47
 */
//按权重随机选择 -- random-pick-with-weight
public class _528_AnQuanZhongSuiJiXuanZe {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] preSum;
        Random random = new Random();

        public Solution(int[] w) {
            preSum = new int[w.length + 1];
            for (int i = 0; i < w.length; i++) {
                preSum[i + 1] = preSum[i] + w[i];
            }
        }

        public int pickIndex() {
            int len = preSum.length;
            //生成1-preSum[len-1]的随机数  因为preSum[len-1]是不包含的   也就说1-sum(w)
            int randNum = random.nextInt(preSum[len - 1]) + 1;

            //二分查找
            return left_bound(preSum, randNum) - 1;

        }

        public int left_bound(int[] arr, int target) {
            if (arr.length == 0) return -1;

            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < target) {
                    left = mid + 1;
                }
                if (arr[mid] == target) {
                    right = mid;
                }
                if (arr[mid] > target) {
                    right = mid;
                }
            }
            //不需要判断不存在的情况
            return left;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        int[] w = {1, 3, 3, 3, 5};
        Solution solution = new _528_AnQuanZhongSuiJiXuanZe().new Solution(w);
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}

/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * <p>
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下
 * 标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3
 * ) = 0.75（即，75%）。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出：
 * [null,1,1,1,1,0]
 * 解释：
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
 * <p>
 * 由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * 诸若此类。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= w.length <= 10⁴
 * 1 <= w[i] <= 10⁵
 * pickIndex 将被调用不超过 10⁴ 次
 * <p>
 * Related Topics数学 | 二分查找 | 前缀和 | 随机化
 * <p>
 * 👍 258, 👎 0
 */
