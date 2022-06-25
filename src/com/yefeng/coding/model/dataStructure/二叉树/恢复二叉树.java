package com.yefeng.coding.model.dataStructure.二叉树;


import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

/*
给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。

 

示例 1：


输入：root = [1,3,null,null,2]
输出：[3,1,null,null,2]
解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
示例 2：


输入：root = [3,1,4,null,null,2]
输出：[2,1,4,null,null,3]
解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 

提示：

树上节点的数目在范围 [2, 1000] 内
-231 <= Node.val <= 231 - 1
 

进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/recover-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

 /*
 * @author yefeng
 * @version 1.0.0
 * @ClassName 恢复二叉树.java
 * @Description TODO
 * @createTime 2022年06月22日 11:57:00
 */
public class 恢复二叉树 {



    class Solution{



        // 分别记录这两个被交换的节点
        TreeNode first = null, second = null;
        // 判断中序遍历的有序性
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
             first = null;
             second = null;
            prev.val=Integer.MIN_VALUE;
            inorderTraverse(root);

            first.val=first.val^second.val;
            second.val=first.val^second.val;
            first.val=first.val^second.val;
//            int temp = first.val;
//            first.val = second.val;
//            second.val = temp;
        }

        void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraverse(root.left);
            System.out.println("\nroot="+root.val);
            // 中序遍历代码位置，找出那两个节点
            if (root.val < prev.val) {//不会和 min对比
                System.out.println("\n"+root.val+" < "+ prev.val);
                // root 不符合有序性
                if (first == null) {
                    // 第一个错位节点是 prev
                    first = prev;
                    System.out.println("\n first="+first.val);
                }
                // 第二个错位节点是 root
                second = root;
            }
            prev = root;
            System.out.println("prev"+prev.val);
            inorderTraverse(root.right);
        }

    }

    public static void main(String[] args) {
        Integer[] root = {1, 3, null, null, 2};//前序，null为
        Integer[] root1 = {3,1,4,null,null,2};
        Integer[] root2 = {11,18,37,28};
        TreeNode treeNode = BinaryTreeUtil.createBT(root);
        TreeNode treeNode1 = BinaryTreeUtil.createBT(root1);
        TreeNode treeNode2 = BinaryTreeUtil.createBT(root2);


        Solution solution = new 恢复二叉树().new Solution();

        BinaryTreeUtil.traverse(treeNode, 0);
        solution.recoverTree(treeNode);
        System.out.println();
        BinaryTreeUtil.traverse(treeNode,0);

        System.out.println("\n-----------");

        BinaryTreeUtil.traverse(treeNode1, 0);
        solution.recoverTree(treeNode1);
        System.out.println();
        BinaryTreeUtil.traverse(treeNode1,0);

        System.out.println("\n-----------");

        BinaryTreeUtil.traverse(treeNode2, 0);
        solution.recoverTree(treeNode2);
        System.out.println();
        BinaryTreeUtil.traverse(treeNode2,0);




    }
}
