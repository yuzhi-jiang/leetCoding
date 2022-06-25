package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 相交链表.java
 * @Description TODO 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @createTime 2022年06月23日 13:58:00
 */
/**
 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
 **/
public class 相交链表 {
     class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode p1=headA,p2=headB;
            while (p1!=p2){//可能p1==p2==null
                p1=p1==null?headB:p1.next;
                p2=p2==null?headA:p2.next;
            }
            return p1;
        }
    }
}
