package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 删除链表的倒数第N个结点.java
 * @Description TODO 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * TODO https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @createTime 2022年06月23日 13:24:00
 */
public class 删除链表的倒数第N个结点 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            //先找到第导入n+1个 （如删除正数第3个需找到前一个）

            ListNode dummy = new ListNode(-1); //虚拟节
            dummy.next = head;

            ListNode x = kthToLast(dummy, n + 1);
            x.next=x.next.next;
            return dummy.next;//返回头节点
        }
        public  ListNode kthToLast(ListNode head,int k){
            //先走k步数
            ListNode p1=head;
            for (int i = 0; i < k; i++) {
                p1=p1.next;
            }
            ListNode p2=head;
            while (p1!=null){
                p1=p1.next;
                p2=p2.next;
            }
            return p2;
        }
    }
}
