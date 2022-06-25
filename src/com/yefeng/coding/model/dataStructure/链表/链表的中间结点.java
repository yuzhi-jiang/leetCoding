package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 链表的中间结点.java
 * @Description TODO 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *              TODO 如果有两个中间结点，则返回第二个中间结点。
 *
 *              todo 解法：快慢指针
 * @createTime 2022年06月23日 13:33:00
 */
public class 链表的中间结点 {
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast=head,slow=head;

            while (fast!=null&&fast.next!=null){
                fast=fast.next.next;//走两布，且因为fast.next不为空，所以不会空指针异常
                slow=slow.next;
            }
            return slow;
        }
    }
}
