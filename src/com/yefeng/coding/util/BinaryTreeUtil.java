package com.yefeng.coding.util;

import com.yefeng.coding.publicBean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BuildTree.java
 * @Description TODO
 * @createTime 2022年06月22日 12:05:00
 */
public class BinaryTreeUtil {
    public static TreeNode createBT(Integer[] arr, int i) // 初始时,传入的i==1
    {
        //TreeNode root = null; // 定义根节点

        if (i > arr.length) {// i >= arr.length 时,表示已经到达了根节点
            return null;
        }
        if(arr[i-1] == null){
            return null;
        }
        TreeNode root = new TreeNode(arr[i-1]); // 根节点
        root.left = createBT(arr, 2*i); // 递归建立左孩子结点
        root.right = createBT(arr, 2*i+1); // 递归建立右孩子结点

        return root;
    }


    public static TreeNode createBT(Integer[] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeft = true;//是左子树
        for(int i = 1; i< arr.length; i++){
            TreeNode node = queue.peek(); //peek()获取第一个元素，不移除
            assert node != null;
            if(isLeft){
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left); //offer(E e) 在队列尾部添加一个元素，并返回是否成功
                }
                isLeft = false;
            } else {
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                //右节点加入队列尾部，删除第一个元素，保证队列里保存的是根节点
                queue.poll(); //poll()  删除队列中第一个元素，并返回该元素的值,
                isLeft = true;
            }
        }
        return root;
    }

    //   遍历
   public static void traverse(TreeNode root,int index) {

       if (root == null) {
       //    System.out.print("null ");
            return;
        }
       if (index==1){
           System.out.print(root.val+" ");
       }
        // 前序位置
        traverse(root.left,index);
        // 中序位置
       if (index==0){
           System.out.print(root.val+" ");
       }


        traverse(root.right,index);
        // 后序位置
       if (index==-1){
           System.out.print(root.val+" ");
       }
    }


    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);// 每次计入一层
        while (!queue.isEmpty()) {
            //当前层有多少个，就是队列里有多少个元素
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                assert curr != null;
                System.out.print(curr.val+" ");
                //加入左右子树
                if (curr.left != null) queue.offer(curr.left);//需在队尾加入，因为前面的还没pop完
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        System.out.println();

    }
}
