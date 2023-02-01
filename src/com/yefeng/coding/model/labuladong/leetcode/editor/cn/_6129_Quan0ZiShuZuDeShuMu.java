package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 全 0 子数组的数目 _6129_全 0 子数组的数目.java
 * @createTime 2022-07-24 18:55:20
 */
//全 0 子数组的数目 -- number-of-zero-filled-subarrays
public class _6129_Quan0ZiShuZuDeShuMu {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long count = 0L;
            int cnt = 0;//第几个0，第n个0可以和前面的0组成组成n个子数组,也就是贡献了n
            for (int num : nums) {
                if (num != 0) {
                    cnt = 0;
                } else {
                    cnt++;
                    count += cnt;
                }
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _6129_Quan0ZiShuZuDeShuMu().new Solution();
        System.out.println(solution.zeroFilledSubarray(
                ArrayUtil.createByArg(1, 3, 0, 0, 2, 0, 0, 4)
        ));
    }
}

/*
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 * <p>
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,0,0,2,0,0,4]
 * 输出：6
 * 解释：
 * 子数组 [0] 出现了 4 次。
 * 子数组 [0,0] 出现了 2 次。
 * 不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,2,0,0]
 * 输出：9
 * 解释：
 * 子数组 [0] 出现了 5 次。
 * 子数组 [0,0] 出现了 3 次。
 * 子数组 [0,0,0] 出现了 1 次。
 * 不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,10,2019]
 * 输出：0
 * 解释：没有全 0 子数组，所以我们返回 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * 👍 2, 👎 0
 */
