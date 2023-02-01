package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 二叉树展开为链表 _114_二叉树展开为链表.java
 * @createTime 2022-07-28 11:36:40
 */
//二叉树展开为链表 -- flatten-binary-tree-to-linked-list
public class _114_ErChaShuZhanKaiWeiLianBiao {
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
        public void flatten(TreeNode root) {
            solve1(root);
        }

        private void solve2(TreeNode root) {


        }

        public void solve1(TreeNode root) {
            if (root == null) return;
            //先将左子树展开
            if (root.left != null) {
                flatten(root.left);
            }
            //再将右子树展开
            if (root.right != null) {
                flatten(root.right);
            }


            TreeNode right = root.right;

            root.right = root.left;
            root.left = null;

            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _114_ErChaShuZhanKaiWeiLianBiao().new Solution();
        TreeNode arrs = BinaryTreeUtil.createBTByArgs(1, 2, 5, 3, 4, null, 6);
        solution.flatten(arrs);
        BinaryTreeUtil.traverse(arrs, 1);

        Deque<Integer> stack = new LinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println();
        System.out.println(stack.pop());

    }
}

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * Related Topics栈 | 树 | 深度优先搜索 | 链表 | 二叉树
 * <p>
 * 👍 1252, 👎 0
 */
