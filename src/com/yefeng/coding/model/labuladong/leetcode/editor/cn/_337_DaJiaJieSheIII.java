package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

import java.util.HashMap;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 打家劫舍 III _337_打家劫舍 III.java
 * @createTime 2022-07-22 14:25:28
 */
//打家劫舍 III -- house-robber-iii
public class _337_DaJiaJieSheIII {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int rob(TreeNode root) {
            return new solve3().rob(root);
        }

        //会超时，因为有的节点会被重复访问
        private int solve1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int val = root.val;

            int left = solve1(root.left);
            int right = solve1(root.right);
            int resbutout = left + right;

            int restou = val;
            if (root.left != null) {
                restou += solve1(root.left.left) + solve1(root.left.right);
            }
            if (root.right != null) {
                restou += solve1(root.right.right) + solve1(root.right.left);
            }
            return Math.max(resbutout, restou);
        }

        //利用memo来记录计算过的节点，避免重复计算，达到剪枝的效果
        class solve2 {
            HashMap<TreeNode, Integer> memo = new HashMap<>();

            public int rob(TreeNode root) {
                return solve2Fun(root);
            }

            //利用memo来记录计算过的节点，避免重复计算，达到剪枝的效果
            private int solve2Fun(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                if (memo.containsKey(root)) {
                    return memo.get(root);
                }
                int val = root.val;
                int left = solve2Fun(root.left);
                int right = solve2Fun(root.right);
                int not_do = left + right;//不偷当前节点
                int do_it = val;//偷当前节点
                if (root.left != null) {
                    do_it += solve2Fun(root.left.left) + solve2Fun(root.left.right);
                }
                if (root.right != null) {
                    do_it += solve2Fun(root.right.right) + solve2Fun(root.right.left);
                }
                int res = Math.max(not_do, do_it);
                memo.put(root, res);
                return res;
            }
        }

        //通过修改函数返回值，来返回一颗树的偷和不偷的值，这样就不用记录计算过的节点了
        class solve3 {
            private int rob(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                int[] res;
                res = dp(root);
                return Math.max(res[0], res[1]);
            }

            //对于当前节点 产生偷和不偷两种情况 nums[0]表示不偷，nums[1]表示偷
            private int[] dp(TreeNode root) {
                if (root == null) {//base case
                    return new int[]{0, 0};
                }
                int[] nums = new int[2];

                int[] left = dp(root.left);
                int[] right = dp(root.right);

                //不偷当前节点
                int not_do = Math.max(left[0], left[1]) +//对于左子树,取其的不偷和偷的最大值
                        Math.max(right[0], right[1]);//对于右子树,取其的不偷和偷的最大值
                //偷当前节点
                int do_it = root.val + left[0] + right[0];//偷当前节点 加上左子树和右子树的不偷（左右子树不可偷了）

                nums[0] = not_do;//不偷当前节点
                nums[1] = do_it;//偷当前节点

                return nums;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _337_DaJiaJieSheIII().new Solution();
        System.out.println(solution.rob(BinaryTreeUtil.createBT(new Integer[]{3, 4, 5, 1, 3, null, 1})));
    }
}

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连
 * 的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * <p>
 * 树的节点数在 [1, 10⁴] 范围内
 * 0 <= Node.val <= 10⁴
 * <p>
 * Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树
 * <p>
 * 👍 1370, 👎 0
 */
