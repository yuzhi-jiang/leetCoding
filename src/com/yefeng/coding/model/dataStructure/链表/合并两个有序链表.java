package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 合并两个有序链表.java
 * @Description TODO 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 https://leetcode.cn/problems/merge-two-sorted-lists/
 * @createTime 2022年06月23日 10:10:00
 */
public class 合并两个有序链表 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            ListNode p1 = list1;//不改变原始数据
            ListNode p2 = list2;
            while (p1 != null && p2 != null) {//两个都不为空才比较，一方为空，则指针指向后面即可
                if (p1.val <= p2.val) {//取小的那个
                    p.next = p1;
                    p1 = p1.next;
                    p = p.next;
                    continue;
                }
                p.next = p2;
                p2 = p2.next;
                p = p.next;//p指针后移 指向当前指针
            }

            if (p1!=null)p.next=p1;
            if (p2!=null)p.next=p2;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode root1 = LinkedListUtil.createByArr(arr1);
        ListNode root2 = LinkedListUtil.createByArr(arr2);

        Solution solution = new 合并两个有序链表().new Solution();
        ListNode root = solution.mergeTwoLists(root1, root2);

        LinkedListUtil.traverse(root);
    }

}
