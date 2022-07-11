import com.yefeng.coding.util.ArrayUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName _55_跳跃游戏.java
 * @createTime 2022-07-10 15:19:23
 */
//跳跃游戏 -- jump-game
public class _55_跳跃游戏 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int max = 0;//最远点
            for (int i = 0; i < len - 1; ++i) {  //len-1 是最后一个必定能到它自己
                max = Math.max(max, i + nums[i]);

                if (max <= i) {//最远点小于等于当前点（等于意外着当前节点遇到0这个老六过不去）
                    return false;
                }
            }

            // 判断一下最远点是否到n-1（最后这个节点下标） >=  大于即超过
            return (max >= len - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _55_跳跃游戏().new Solution();
        boolean b = solution.canJump(ArrayUtil.createByArg(2, 3, 1, 1, 4));
        System.out.println(b);
    }
}

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * 0 <= nums[i] <= 10⁵
 * <p>
 * Related Topics贪心 | 数组 | 动态规划
 * <p>
 * 👍 1909, 👎 0
 */
