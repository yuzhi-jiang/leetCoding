package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 填充每个节点的下一个右侧节点指针 _116_java
 * @createTime 2022-07-28 11:14:10
 */
//填充每个节点的下一个右侧节点指针 -- populating-next-right-pointers-in-each-node
public class _116_TianChongMeiGeJieDianDeXiaYiGeYouCeJieDianZhiZhen {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
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
*/


    class Solution {

        public Node connect(Node root) {

            if (root == null) return null;

            traverse(root.left, root.right);

//            System.out.println(root.next);
//            System.out.println(root.left.next.val);


            return root;
        }

        void traverse(Node root) {
//            迭代发

        }

        void traverse(Node node1, Node node2) {
//            递归发
            if (node1 == null || node2 == null) {
                return;
            }

            node1.next = node2;

//            相同父节点链接
            traverse(node1.left, node1.right);
            traverse(node2.left, node2.right);

//            跨父节点链接 node1的 右 连接 node2 的左2
            traverse(node1.right, node2.left);
        }

        Node buildNodeByArry(Integer[] arr) {
            if (arr.length == 0) {
                return null;
            }
            Node root = new Node(arr[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            boolean isLeft = true;//是左子树
            for (int i = 1; i < arr.length; i++) {
                Node node = queue.peek(); //peek()获取第一个元素，不移除
                assert node != null;
                if (isLeft) {
                    if (arr[i] != null) {
                        node.left = new Node(arr[i]);
                        queue.offer(node.left); //offer(E e) 在队列尾部添加一个元素，并返回是否成功
                    }
                    isLeft = false;
                } else {
                    if (arr[i] != null) {
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
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _116_TianChongMeiGeJieDianDeXiaYiGeYouCeJieDianZhiZhen().new Solution();
        System.out.println(solution.connect(solution.buildNodeByArry(new Integer[]{1, 2, 3, 4, 5, 6, 7})));

    }
}

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
 * next 指针连接，'#' 标志着每一层的结束。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数量在 [0, 2¹² - 1] 范围内
 * -1000 <= node.val <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * Related Topics树 | 深度优先搜索 | 广度优先搜索 | 链表 | 二叉树
 * <p>
 * 👍 835, 👎 0
 */
