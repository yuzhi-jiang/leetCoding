package com.yefeng.coding.model.dataStructure.二叉树;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 翻转二叉树.java
 * @Description TODO 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 https://leetcode.cn/problems/invert-binary-tree/
 * @createTime 2022年06月22日 20:10:00
 */


public class 翻转二叉树 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {

             traverse(root);

            return root;
        }

        void  traverse(TreeNode root){
            if (root==null)return;

            TreeNode temp;
            temp=root.left;
            root.left=root.right;
            root.right=temp;

            traverse(root.left);
            traverse(root.right);
        }

    }

    public static void main(String[] args) {
        Solution solution = new 翻转二叉树().new Solution();

        TreeNode treeNode = solution.invertTree(BinaryTreeUtil.createBT(new Integer[]{2,1,3}));

        BinaryTreeUtil.levelOrder(treeNode);
    }
}
