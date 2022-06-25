package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;
import com.yefeng.coding.util.LinkedListUtil;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName K个一组翻转链表.java
 * @Description TODO
 * @createTime 2022年06月24日 14:33:00
 */
public class K个一组翻转链表 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head==null){
                return null;
            }
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                if (b==null)return head;//不用翻转
                b=b.next;
            }
            ListNode newHead=reverseN(a, b);
            a.next=reverseKGroup(b,k);// todo a是尾部
            return newHead;
        }
        //    todo 迭代逆转
        ListNode reverseN(ListNode a, ListNode b) {
            ListNode curr=a;
            ListNode pre=null;

            ListNode nex=a;
           while (curr!=b){
               nex=curr.next;
               curr.next=pre;
               pre=curr;
               curr=nex;
           }
           return pre;
        }
    }

    public static void main(String[] args) {
        Solution solution = new K个一组翻转链表().new Solution();

        int[] arr={1,2,3,4,5};
        ListNode node = LinkedListUtil.createByArr(arr);

        ListNode listNode = solution.reverseKGroup(node, 2);

        LinkedListUtil.traverse(listNode);
    }
}
