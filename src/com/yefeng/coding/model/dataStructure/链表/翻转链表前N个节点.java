package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 翻转链表前N个节点.java
 * @Description TODO 这个还没理解完
 * @createTime 2022年06月23日 16:07:00
 */

//1 2 3 4
public class 翻转链表前N个节点 {
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }


//    todo 迭代逆转前N个 题目保证n<=length
    ListNode reverseN2(ListNode head, int n) {
        if (n==1)return head;
        ListNode curr=head;
        for (int i = 0; i < n&&curr!=null; i++) {
            curr=curr.next;
        }
        ListNode pre=curr;//前驱应该是第四个
        curr=head;
        ListNode nex=head;

            while ((n--)>0&&curr!=null){
//            if (head==null)break;
                nex=curr.next;
                curr.next=pre;
                pre=curr;
                curr=nex;
            }

        return pre;
    }

    public static void main(String[] args) {
        翻转链表前N个节点 fan = new 翻转链表前N个节点();
        ListNode head = LinkedListUtil.createByArr(new int[]{1, 2, 3, 4, 5});

        ListNode root1 = fan.reverseN(head, 4);
        LinkedListUtil.traverse(root1);




        System.out.println("head");
        LinkedListUtil.traverse(head);

        System.out.println(",,,,,,,,,,,,\nroot1:");
        LinkedListUtil.traverse(root1);
    }
}
