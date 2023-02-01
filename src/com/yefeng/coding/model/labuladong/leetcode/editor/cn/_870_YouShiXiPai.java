package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 优势洗牌 _870_优势洗牌.java
 * @createTime 2022-07-25 13:25:51
 */
//优势洗牌 -- advantage-shuffle
public class _870_YouShiXiPai {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            PriorityQueue<int[]> num2queue = new PriorityQueue<>(
                    (a, b) -> (b[1] - a[1]));
            for (int i = 0; i < nums2.length; i++) {
                num2queue.add(new int[]{i, nums2[i]});
            }
            ///升序
            Arrays.sort(nums1);
            //最小值
            int left = 0;
            int right = nums1.length - 1;//最大值

            while (!num2queue.isEmpty()) {
                int[] num2 = num2queue.poll();
                int index = num2[0];//index是nums2的下标
                int maxVal = num2[1];//maxVal是nums2的值,即nums2的最大值
                if (nums1[right] > maxVal) {//自己比较大
                    res[index] = nums1[right];
                    right--;
                } else {
                    res[index] = nums1[left];
                    left++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _870_YouShiXiPai().new Solution();
        int[] res = solution.advantageCount(
                ArrayUtil.createByArg(
                        12, 24, 8, 32
                ),
                ArrayUtil.createByArg(
                        13, 25, 32, 11
                )
        );
        System.out.println(Arrays.toString(res));
    }
}

/**
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来
 * 描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length <= 10⁵
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10⁹
 * <p>
 * Related Topics贪心 | 数组 | 排序
 * <p>
 * 👍 194, 👎 0
 */
