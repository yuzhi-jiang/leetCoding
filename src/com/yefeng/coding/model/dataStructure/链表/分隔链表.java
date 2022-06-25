package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 分隔链表.java
 * @Description TODO
 * @createTime 2022年06月23日 11:17:00
 */

/**
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

        你应当 保留 两个分区中每个节点的初始相对位置。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/partition-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 分隔链表 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);

            ListNode p1=dummy1;
            ListNode p2=dummy2;

            ListNode p = head;

            while (p!=null){
                if (p.val<x){
                    p1.next=p;

                    p1=p1.next;

                    p=p.next;//必须要在null之前
                    p1.next=null;

                }else {
                    p2.next=p;

                    p2=p2.next;
                    p=p.next;
                    p2.next=null;
                }
            }

            p1.next=dummy2.next;
            return dummy1.next;
        }
    }
}
