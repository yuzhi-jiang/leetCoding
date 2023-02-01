package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 在 D 天内送达包裹的能力 _1011_在 D 天内送达包裹的能力.java
 * @createTime 2022-07-23 16:42:47
 */
//在 D 天内送达包裹的能力 -- capacity-to-ship-packages-within-d-days
public class _1011_ZaiDTianNeiSongDaBaoGuoDeNengLi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 0;
            //left是最小的重量,确保一条船能单独运最大的包裹，right是最大的重量,最大的重量是weights的和
            for (int weight : weights) {
                right += weight;
                left = Math.max(left, weight);
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (fun(weights, mid) > days) {//如果这个重量的船能运包裹的天数大于days,那么这个重量的船不能运
                    left = mid + 1;
                } else {
                    right = mid;//左边界
                }
            }
            return left;
        }


        //用weight中的轮船需要多少天能运完全部包裹
        public int fun(int[] arr, int weight) {//单调递减的数组
            int sum = 0;
            int days = 0;//天数
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > weight) {
                    sum = arr[i];
                    days++;
                }
            }
            return days + 1;//最后一天不会超载，还要运完
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _1011_ZaiDTianNeiSongDaBaoGuoDeNengLi().new Solution();
        System.out.println(
                solution.shipWithinDays(
                        ArrayUtil.createByArg(
                                1, 2, 3, 1, 1
                        ),
                        4
                ));
    }
}

/*
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运
 * 载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10)
 * 是不允许的。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= days <= weights.length <= 5 * 10⁴
 * 1 <= weights[i] <= 500
 * <p>
 * Related Topics数组 | 二分查找
 * <p>
 * 👍 481, 👎 0
 */
