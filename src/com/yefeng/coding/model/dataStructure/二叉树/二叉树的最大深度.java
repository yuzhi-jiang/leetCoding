package com.yefeng.coding.model.dataStructure.二叉树;

import com.yefeng.coding.publicBean.TreeNode;
import com.yefeng.coding.util.BinaryTreeUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 二叉树的最大深度.java
 * @Description TODO
 * @createTime 2022年06月22日 19:45:00
 */

/**
 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的最大深度 {

    class Solution {

        int depth=0;
        int res=0;
        int maxDepth(TreeNode root) {
            traverse(root);
            return res;
        }
        void traverse(TreeNode root){
            if(root == null)return;

            depth++;

            res=Math.max(res,depth);
            traverse(root.left);
            traverse(root.right);

            depth--;
        }
    };


    public static void main(String[] args) {
        Solution solution = new 二叉树的最大深度().new Solution();
        int i = solution.maxDepth(BinaryTreeUtil.createBT(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(i);
    }
}
