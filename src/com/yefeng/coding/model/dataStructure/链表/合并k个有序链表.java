package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 合并k个有序链表.java
 * @Description TODO 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @createTime 2022年06月23日 11:44:00
 */
public class 合并k个有序链表 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(lists.length,(a,b)->(a.val-b.val));//自定义初始化和比较强

            ListNode dummy = new ListNode(-1);
            ListNode p=dummy;

            for (ListNode list : lists) {
                if (list == null) {
                    continue;
                }
                pQueue.add(list);
            }

            while (!pQueue.isEmpty()){
                //取出最小值
                ListNode curr = pQueue.poll();
                p.next=curr;
                if (curr.next!=null)pQueue.add(curr.next);

                p=p.next;

            }

            return dummy.next;

        }
    }

    public static void main(String[] args) {

    }
}
