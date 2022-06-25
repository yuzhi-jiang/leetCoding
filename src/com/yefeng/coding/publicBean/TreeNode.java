package com.yefeng.coding.publicBean;

/**
 * @author yefeng
 * @version 1.0.0
 * @className com.yefeng.coding.publicBean.TreeNode
 * @Description TODO
 * @createTime 2022/06/22
 * @SEE
 * @Doc 树节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public  TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }




}