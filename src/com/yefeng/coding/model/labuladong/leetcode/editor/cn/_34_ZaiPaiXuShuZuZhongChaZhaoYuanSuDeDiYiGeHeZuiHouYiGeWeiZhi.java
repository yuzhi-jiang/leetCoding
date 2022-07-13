package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 在排序数组中查找元素的第一个和最后一个位置 _34_在排序数组中查找元素的第一个和最后一个位置.java
 * @createTime 2022-07-12 17:28:34
 */
//在排序数组中查找元素的第一个和最后一个位置 -- find-first-and-last-position-of-element-in-sorted-array
public class _34_ZaiPaiXuShuZuZhongChaZhaoYuanSuDeDiYiGeHeZuiHouYiGeWeiZhi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //两个边界
            return new int[]{left_bound(nums, target), right_bound2(nums, target)};
        }

        public int left_bound(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {//终止条件必是l>r(l=r+1),而r=min-1 所以nums[l]=nums[r+1]=nums[min]=target
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    r = mid - 1;
                }
                if (nums[mid] < target) {
                    l = mid + 1;
                }
                if (nums[mid] > target) {
                    r = mid - 1;
                }
            }
//            if(l==nums.length)return -1;
//            return nums[l]==target?l:-1;
            if (l >= nums.length || nums[l] != target) return -1;
            return l;
        }

        int right_bound(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int left = 0, right = nums.length;

            while (left < right) {//终止条件必是left==right  而因为left=min+1,所以nums[left-1]==target
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1; // 注意
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            //left==right >=0  0...len len超过范围
//            if (left==nums.length+1)return -1;
//            if (left>0&&nums[left-1]!=target)return -1;

            int t = left - 1;
            if (t < 0 || nums[t] != target) return -1;
            return left - 1; // 注意
        }

        int right_bound2(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;

            while (left <= right) {//终止条件必是left==right+1  而因为left=min+1,所以nums[min]==nums[right]=nums[left-1]==target
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1; // 注意
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            //left==right >=0  0...len len超过范围
//            if (left==nums.length+1)return -1;
//            if (left>0&&nums[left-1]!=target)return -1;
//            int t=left-1;
//            if (t<0||nums[t]!=target)return -1;
//            return left - 1; // 注意
            ////////////////上面逻辑可以转换下面逻辑方便记忆/////////////////
            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _34_ZaiPaiXuShuZuZhongChaZhaoYuanSuDeDiYiGeHeZuiHouYiGeWeiZhi().new Solution();
//        int [] res= solution.searchRange(ArrayUtil.createByArg(5,7,7,8,8,10), 11);
        int i = solution.right_bound2(ArrayUtil.createByArg(5, 7, 7, 8, 8, 10), 0);
        System.out.println(i);
//        System.out.println(Arrays.toString(res));
    }
}

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 * <p>
 * Related Topics数组 | 二分查找
 * <p>
 * 👍 1796, 👎 0
 */
