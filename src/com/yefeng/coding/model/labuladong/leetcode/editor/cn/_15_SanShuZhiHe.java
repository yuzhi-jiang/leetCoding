package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 三数之和 _15_三数之和.java
 * @createTime 2022-07-22 15:12:47
 */
//三数之和 -- 3sum
public class _15_SanShuZhiHe {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            nSum nSum = new nSum();
            return nSum.solveNSum(nums, 3, 0, 0);
        }


        class nSum {
            private List<List<Integer>> twoSumTarget(
                    int[] nums, int start, int target) {
                // 左指针改为从 start 开始，其他不变
                ArrayList<List<Integer>> res = new ArrayList<>();
                int lo, hi;
                lo = start;
                hi = nums.length - 1;
                while (lo < hi) {
                    int left = nums[lo], right = nums[hi];
                    if (nums[lo] == target - nums[hi]) {
                        ArrayList<Integer> tem = new ArrayList<>(2);

                        while (lo < hi && nums[lo] == left) lo++;
                        while (lo < hi && nums[hi] == right) hi--;

                        tem.add(left);
                        tem.add(right);
                        res.add(tem);

                    } else if (nums[lo] < target - nums[hi]) {
                        while (lo < hi && nums[lo] == left) lo++;
                    } else if (nums[lo] > target - nums[hi]) {
                        while (lo < hi && nums[hi] == right) hi--;

                    }
                }
                return res;

            }


            public List<List<Integer>> solveNSum(int[] arr, int n, int start, int target) {
                Arrays.sort(arr);
                return nSumToTarget(arr, n, start, target);
            }

            private List<List<Integer>> nSumToTarget(int[] arr, int n, int start, int target) {

                ArrayList<List<Integer>> res = new ArrayList<>();
                int len = arr.length;
                if (n < 2 || len < n) return res;
                double min, max, count;
                if (n == 2) {
                    return twoSumTarget(arr, start, target);
                }

//       todo 遍历第一个数
                for (int i = start; i <= len - n; i++) {

                    // todo find the min or max if max < target 或者 min > target then continue
                    min = max = 0;
                    count = 0;
                    for (int t = i; t < len && count < n; ++t, ++count) {
                        min += arr[t];
                    }
                    if (min > target) {
                        continue;
                    }

                    count = 0;
                    for (int it = 1; it <= n; it++) {
                        max += arr[len - it];
                    }
                    if (max < target) {
                        continue;
                    }


                    //todo
                    List<List<Integer>> sub = nSumToTarget(arr, n - 1, i + 1, target - arr[i]);


//            for (int it = 0; it < sub.size(); it++) {
//                List<Integer> item=sub.get(it);
//                System.out.println(arr[i]);
//                sub.get(it).add(arr[i]);
//                res.add(item);
//            }
                    for (List<Integer> item : sub) {
                        // (n-1)Sum 加上 nums[i] 就是 nSum
                        item.add(arr[i]);
                        res.add(item);
                    }
                    while (i < len - n && arr[i] == arr[i + 1]) i++;
                }

                return res;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _15_SanShuZhiHe().new Solution();
        List<List<Integer>> lists = solution.threeSum(ArrayUtil.createByArg(0));
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的
 * 三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 3000
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * Related Topics数组 | 双指针 | 排序
 * <p>
 * 👍 5011, 👎 0
 */
