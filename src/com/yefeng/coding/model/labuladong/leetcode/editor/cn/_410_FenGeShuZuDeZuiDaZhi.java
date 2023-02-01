package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 分割数组的最大值 _410_分割数组的最大值.java
 * @createTime 2022-07-23 17:15:26
 */
//分割数组的最大值 -- split-array-largest-sum
public class _410_FenGeShuZuDeZuiDaZhi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            int left = 0, right = 0;
            for (int num : nums) {
                left = Math.max(left, num);//最小分,必须能单独拆最大的那个,分数越少分的越多
                right += num;//最大分
            }

            //左闭右闭区间
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (check(nums, mid) > m) {//分数太小了，分的越多
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }


        //最大score分数下能分割的数组的个数 分数越少分的越多，单调递减
        public int check(int[] nums, int score) {
            int count = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum > score) {
                    sum = num;
                    count++;
                }
            }
            return count + 1;//最后一次不会超过score 要加上
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _410_FenGeShuZuDeZuiDaZhi().new Solution();
        System.out.println(
                solution.splitArray(
                        ArrayUtil.createByArg(
                                1, 4, 4
                        ),
                        3
                ));
    }
}

/**
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * <p>
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。
 * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10⁶
 * 1 <= m <= min(50, nums.length)
 * <p>
 * Related Topics贪心 | 数组 | 二分查找 | 动态规划
 * <p>
 * 👍 709, 👎 0
 */
