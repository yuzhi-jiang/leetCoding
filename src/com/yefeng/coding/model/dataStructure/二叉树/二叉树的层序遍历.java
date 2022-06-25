package com.yefeng.coding.model.dataStructure.二叉树;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 二叉树的层序遍历.java
 * @Description TODO
 * @createTime 2022年06月22日 18:10:00
 */
/**
 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class 二叉树的层序遍历 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);// 每次计入一层
            while (!queue.isEmpty()) {
                //当前层有多少个，就是队列里有多少个元素
                int size = queue.size();
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    assert curr != null;
                    list.add(curr.val);
                    //加入左右子树
                    if (curr.left != null) queue.offer(curr.left);//需在队尾加入，因为前面的还没pop完
                    if (curr.right != null) queue.offer(curr.right);
                }
                res.add(list);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new 二叉树的层序遍历().new Solution();
        List<List<Integer>> lists = solution.levelOrder(BinaryTreeUtil.createBT(new Integer[]{3, 9, 20, null, null, 15, 7}));
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
