package com.yefeng.coding.model.dataStructure.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 填充每个节点的下一个右侧节点指针.java
 * @Description TODO
 * @createTime 2022年06月22日 22:08:00
 */
public class 填充每个节点的下一个右侧节点指针 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {

            if (root==null)return null;

            traverse(root.left,root.right);

//            System.out.println(root.next);
//            System.out.println(root.left.next.val);


            return root;
        }
        void traverse(Node root){
//            迭代发

        }
        void traverse(Node node1,Node node2){
//            递归发
            if (node1==null||node2==null){
                return;
            }

            node1.next=node2;

//            相同父节点链接
            traverse(node1.left,node1.right);
            traverse(node2.left,node2.right);

//            跨父节点链接 node1的 右 连接 node2 的左2
            traverse(node1.right,node2.left);
        }
        Node buildNodeByArry(Integer[] arr){
            if(arr.length == 0){
                return null;
            }
            Node root = new Node(arr[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            boolean isLeft = true;//是左子树
            for(int i = 1; i< arr.length; i++){
                Node node = queue.peek(); //peek()获取第一个元素，不移除
                assert node != null;
                if(isLeft){
                    if(arr[i] != null){
                        node.left = new Node(arr[i]);
                        queue.offer(node.left); //offer(E e) 在队列尾部添加一个元素，并返回是否成功
                    }
                    isLeft = false;
                } else {
                    if(arr[i] != null){
                        node.right = new Node(arr[i]);
                        queue.offer(node.right);
                    }
                    //右节点加入队列尾部，删除第一个元素，保证队列里保存的是根节点
                    queue.poll(); //poll()  删除队列中第一个元素，并返回该元素的值,
                    isLeft = true;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new 填充每个节点的下一个右侧节点指针().new Solution();

        Node root = solution.buildNodeByArry(new Integer[]{1, 2, 3, 4, 5, 6, 7});


        Node connect = solution.connect(root);

        Queue<Node> queue=new LinkedList<>();

        queue.add(connect);

        while (!queue.isEmpty()){
            int size=queue.size();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                System.out.print(curr.val+" ");
//                System.out.printf(curr.next.val);
                if (curr.next==null){
                    System.out.print("# ");
                }
                if (curr.left!=null){
                    queue.offer(curr.left);
                }
                if (curr.right!=null){
                    queue.offer(curr.right);
                }

            }

        }

    }



}
