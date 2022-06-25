package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 递归反转整个链表.java
 * @Description TODO
 * @createTime 2022年06月23日 15:32:00
 */
public class 递归反转整个链表 {
    // 定义：输入一个单链表头结点，将该链表反转，返回新的头结点
    ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next = head;
//            todo nex=head.next  nex.next=head  我下个节点的后继后继节点为我自己  head->nex  ----> nex->head实现翻转

            head.next = null;
            return last;
    }
    ListNode reverse2(ListNode head) {
//        迭代

        ListNode curr=head;
        ListNode nex=head;
        ListNode pre=null;//前面节点和当前节点替换
        while (curr!=null){
            nex=curr.next;

            curr.next=pre;

            pre=curr;//前驱后移

            curr=nex;//当前节点后移

        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ListNode byArr = LinkedListUtil.createByArr(arr);
        ListNode byArr2 = LinkedListUtil.createByArr(arr);

        递归反转整个链表 digui = new 递归反转整个链表();

        ListNode root2 = digui.reverse2(byArr);
        ListNode root1 = digui.reverse(byArr2);

        LinkedListUtil.traverse(root1);
        System.out.println("0------0");
        LinkedListUtil.traverse(root2);

    }
}
