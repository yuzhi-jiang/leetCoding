package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 回文链表.java
 * @Description TODO
 * @createTime 2022年06月24日 17:04:00
 */
public class 回文链表 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            return solve1(head);
        }

        public boolean solve(ListNode head){
            // todo 快慢指针找到中点，并将前半段链表翻转
            ListNode fast = head, slow = head;
            ListNode pre = null;
            ListNode nex = null;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                //todo 翻转且右移
                nex = slow.next;
                slow.next = pre;
                pre = slow;
                slow = nex;
            }
            if (fast!=null){
                slow=slow.next;//单数的话，后面的一个右移一位
            }
//            // todo 1,2,3,4,5,
            while (pre != null && slow != null) {
                if (pre.val!=slow.val)return false;
                pre=pre.next;
                slow=slow.next;
            }

            return true;
        }

        public boolean solve1(ListNode head){
            //todo 翻转后半部分

            ListNode firstNodeEnd=getMidNode(head);
            ListNode right=reversal(firstNodeEnd.next);

            ListNode left=head;

            while (left!=null&&right!=null){
                if (left.val!=right.val)return false;

                left=left.next;
                right=right.next;
            }
            return true;
        }

        public ListNode reversal(ListNode head){
            ListNode pre=null;
            ListNode curr=head;
            ListNode nex=head;

            while (curr!=null){
                nex=curr.next;
                curr.next=pre;
                pre=curr;
                curr=nex;
            }
            return pre;
        }
        public ListNode getMidNode(ListNode head){
            ListNode fast=head,slow=head;
            while (fast.next!=null&&fast.next.next!=null){  //偶数的时候指向左边那个
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
    }


    public static void main(String[] args) {

        ListNode root = LinkedListUtil.createByArr(new int[]{1, 2, 3, 4, 5});
        ListNode root1 = LinkedListUtil.createByArr(new int[]{1, 2, 3, 2, 1});
        Solution solution = new 回文链表().new Solution();
        System.out.println(solution.isPalindrome(root));
        System.out.println(solution.isPalindrome(root1));

    }
}
