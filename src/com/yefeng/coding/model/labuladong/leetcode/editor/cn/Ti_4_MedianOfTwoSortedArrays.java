package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author 夜枫
 * 2022-10-08 21:40:27
 */

public class Ti_4_MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return solve2(nums1, nums2);
        }

        public double solve1(int[] nums1, int[] nums2) {
            int l, r;
            int len = nums1.length + nums2.length;
            int[] nums = new int[len];

            //合并两个数组并排序
            System.arraycopy(nums1, 0, nums, 0, nums1.length);
            System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

            Arrays.sort(nums);

            if (len % 2 == 0) {
                r = len / 2;
                l = r - 1;
            } else {
                r = len / 2;
                l = r;
            }
            return 1.0 * (nums[l] + nums[r]) / 2;
        }


        public double solve2(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int minIndex = (len1 + len2) >> 1;

            int as, bs;
            as = 0;
            bs = 0;

            int l, r;

            l = r = 0;

            //只将r需要遍历到中位数即可
            for (int i = 0; i <= minIndex; ++i) {
                l = r;

                //nums1比较小
                if (as < len1 && (bs >= len2 || nums1[as] < nums2[bs])) {
                    r = nums1[as++];
                }
                //nums2比较小
                else if (bs < len2 && (as >= len1 || nums2[bs] <= nums1[as])) {
                    r = nums2[bs++];
                }
            }

            //如果是偶数
            if (((len1 + len2) & 1) == 0) {
                return l + (r - l) / 2.0;
            }
            return r * 1.0;

        }


        /**
         * 从两个数组中获取第k小的数字
         *
         * @param nums1 数组一
         * @param nums2 数组二
         * @param k     第k小
         * @return 第k小的数
         */
        public int getKth(int[] nums1, int[] nums2, int k) {
            return -1;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Ti_4_MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(ArrayUtil.createByArg(0, 0, 0, 0, 0), ArrayUtil.createByArg(-1, 0, 0, 0, 0, 0, 1)));
    }


}

/*
  //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
  //
  // 算法的时间复杂度应该为 O(log (m+n)) 。
  //
  //
  //
  // 示例 1：
  //
  //
  //输入：nums1 = [1,3], nums2 = [2]
  //输出：2.00000
  //解释：合并数组 = [1,2,3] ，中位数 2
  //
  //
  // 示例 2：
  //
  //
  //输入：nums1 = [1,2], nums2 = [3,4]
  //输出：2.50000
  //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
  //
  //
  //
  //
  //
  //
  // 提示：
  //
  //
  // nums1.length == m
  // nums2.length == n
  // 0 <= m <= 1000
  // 0 <= n <= 1000
  // 1 <= m + n <= 2000
  // -10⁶ <= nums1[i], nums2[i] <= 10⁶
  //
  //
  // Related Topics数组 | 二分查找 | 分治
  //
  // 👍 5944, 👎 0
  //
  //
  //
  //
 */