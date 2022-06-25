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
 * @ClassName 二叉树的锯齿型层序遍历.java
 * @Description TODO
 * @createTime 2022年06月22日 19:23:00
 */


/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * 基本思路
 * 这题和 102. 二叉树的层序遍历 几乎是一样的，只要用一个布尔变量 flag 控制遍历方向即可。
 * <p>
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */
public class 二叉树的锯齿型层序遍历 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);// 每次计入一层
            boolean isLeft = true;//从左往右
            while (!queue.isEmpty()) {
                //当前层有多少个，就是队列里有多少个元素
                int size = queue.size();
                LinkedList<Integer> list = new LinkedList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    assert curr != null;


                    //加入左右子树
                    if (isLeft) {
                        list.addLast(curr.val);//后来后到
                    } else {
                        list.addFirst(curr.val);//后来先到，把后面的加到前面的位置，即可实现从右边往左边加
                    }


                    if (curr.left != null) queue.offer(curr.left);//需在队尾加入，因为前面的还没pop完
                    if (curr.right != null) queue.offer(curr.right);

                }
                isLeft = !isLeft;
                res.add(list);

            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new 二叉树的锯齿型层序遍历().new Solution();

        List<List<Integer>> lists = solution.zigzagLevelOrder(BinaryTreeUtil.createBT(new Integer[]{1, 2, 3, 4, null, null, 5}));
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
