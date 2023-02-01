package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 爱吃香蕉的珂珂 _875_爱吃香蕉的珂珂.java
 * @createTime 2022-07-23 17:59:49
 */
//爱吃香蕉的珂珂 -- koko-eating-bananas
public class _875_AiChiXiangJiaoDeKeKe {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1, r = 0, mid;
//            for (int pile : piles) {
//                r = Math.max(r, pile);
//            }

            r = 1000000000 + 1;

            while (l < r) {
                mid = l + (r - l) / 2;
                int ans = fun(piles, mid);
                if (ans > h) {
                    l = mid + 1;
                }
                if (ans < h) {
                    r = mid;
                }
                if (ans == h) {
                    r = mid;
                }
            }
            return l;
        }

        // 用k的速度（根/h）吃掉所有香蕉需要多少个小时 k越小，时间越久才能吃完，所有单调递减
        public int fun(int[] piles, int k) {
            int sum = 0;
            for (int pile : piles) {
                sum += pile / k;
                if (pile % k > 0) sum++;//有余数的情况，向上取整
            }
            return sum;//在h小时内吃完所有香蕉
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _875_AiChiXiangJiaoDeKeKe().new Solution();
        System.out.println(solution.minEatingSpeed(
                ArrayUtil.createByArg(
                        805306368, 805306368, 805306368
                ),
                1000000000
        ));
    }
}

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一
 * 小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= piles.length <= 10⁴
 * piles.length <= h <= 10⁹
 * 1 <= piles[i] <= 10⁹
 * <p>
 * Related Topics数组 | 二分查找
 * <p>
 * 👍 413, 👎 0
 */
