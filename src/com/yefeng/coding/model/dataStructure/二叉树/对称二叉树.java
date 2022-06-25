package com.yefeng.coding.model.dataStructure.二叉树;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 对称二叉树.java
 * @Description TODO
 * @createTime 2022年06月22日 18:06:00
 */

/**
 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 https://leetcode.cn/problems/symmetric-tree/
 */
public class 对称二叉树 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {

            if(root==null)
                return true;

            return  check(root.left,root.right);

        }
        boolean check(TreeNode left,TreeNode right){
            //有为空
            if(left==null||right==null)
                return left==right;

            if(left.val!=right.val)
                return false;
            return check(left.left,right.right)&&check(left.right,right.left);
        }


    }

    public static void main(String[] args) {
        Solution solution = new 对称二叉树().new Solution();
        boolean symmetric = solution.isSymmetric(BinaryTreeUtil.createBT(new Integer[]{1,2,2,null,3,null,3}));
        System.out.println(symmetric);
    }

}
