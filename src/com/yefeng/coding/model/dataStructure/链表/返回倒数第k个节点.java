package com.yefeng.coding.model.dataStructure.链表;

import com.yefeng.coding.publicBean.ListNode;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 返回倒数第k个节点.java
 * @Description TODO 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
 *   注意：本题相对原题稍作改动
 * @createTime 2022年06月23日 13:17:00
 */
public class 返回倒数第k个节点 {
    class Solution {
        public int kthToLast(ListNode head, int k) {
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
            return p2.val;
        }
    }
}
