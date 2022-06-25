package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 反转链表II.java
 * @Description TODO
 * @createTime 2022年06月24日 12:14:00
 */
public class 反转链表II {
    //    1,2,3,4,5   2,4  1,3   3,2,1,4,5
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) return reverseN2(head, right);

            head.next = reverseBetween(head.next, left - 1, right - 1);//head.next=newHead
            return head;
        }

        //    todo 迭代逆转前N个 题目保证n<=length
        ListNode reverseN2(ListNode head, int n) {
            if (n == 1) return head;
            ListNode curr = head;
            for (int i = 0; i < n && curr != null; i++) {
                curr = curr.next;
            }
            ListNode pre = curr;//前驱应该是第四个
            curr = head;
            ListNode nex = head;

            while ((n--) > 0 && curr != null) {
//            if (head==null)break;
                nex = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nex;
            }

            return pre;
        }
    }


    public static void main(String[] args) {
        Solution solution = new 反转链表II().new Solution();

        ListNode head = LinkedListUtil.createByArr(new int[]{1, 2, 3, 4, 5});
        ListNode root = solution.reverseBetween(head, 3, 4);
//        ListNode root = solution.reverseN2(head,  4);
        System.out.println("head");
        LinkedListUtil.traverse(head);

        System.out.println(",,,,,,,,,,,,\nroot:");
        LinkedListUtil.traverse(root);
    }
}
