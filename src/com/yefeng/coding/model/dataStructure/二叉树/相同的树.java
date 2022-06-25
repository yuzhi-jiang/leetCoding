package com.yefeng.coding.model.dataStructure.二叉树;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 相同的树.java
 * @Description TODO
 * @createTime 2022年06月22日 18:02:00
 */


/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 链接：<a>https://leetcode.cn/problems/same-tree/<a/>
 */
public class 相同的树 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) return false;

            //对比其他节点
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new 相同的树().new Solution();

        TreeNode p = BinaryTreeUtil.createBT(new Integer[]{1, 2});
        TreeNode q = BinaryTreeUtil.createBT(new Integer[]{1, null, 2});
        boolean sameTree = solution.isSameTree(p, q);
        System.out.println(sameTree);
    }

}
