package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.model.dataStructure.数组.删除有序数组中的重复项;
import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 删除排序链表中的重复元素.java
 * @Description TODO 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 https://leetcode.cn/problems/remove-duplicates-from-sorted-list/submissions/
 * @createTime 2022年06月25日 15:12:00
 */
public class 删除排序链表中的重复元素 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode fast = head, slow = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }
            slow.next=null;//todo 结束
            return head;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        Solution solution = new 删除排序链表中的重复元素().new Solution();
//        删除有序数组中的重复项.Solution solution = new 删除有序数组中的重复项().new Solution();
        ListNode head = LinkedListUtil.createByArr(arr);
        ListNode listNode = solution.deleteDuplicates(head);

        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
    }
}
