package com.yefeng.coding.util;

import com.yefeng.coding.publicBean.ListNode;

import javax.xml.crypto.dsig.Transform;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName LinkedListUtil.java
 * @Description TODO
 * @createTime 2022年06月23日 10:29:00
 */
public class LinkedListUtil {
    public static ListNode createByArr(int[] arr){
        if (arr.length==0)return null;

        ListNode root = new ListNode(arr[0]);
        ListNode p = root;
//        System.out.print(p.val+" ");
        for (int i = 1; i < arr.length; i++) {
            p.next= new ListNode(arr[i]);
            p=p.next;//后移动，指向当前
//            System.out.print(p.val+" ");
        }
//        System.out.println();
        return root;
    }
    public static void traverse(ListNode root){
        ListNode temp=root;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    private static ListNode reversalByIterate(ListNode head){
        ListNode curr=head;
        ListNode nex=head;
        ListNode pre=null;//前面节点和当前节点替换
        while (curr!=null){
            nex=curr.next;

            curr.next=pre;

            pre=curr;//前驱后移

            curr=nex;//当前节点后移

        }
        return pre;
    }

    private static ListNode reversalByrRecursion(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reversalByrRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * @param head 头
     * @return {@link ListNode }
     * @title reversal
     * @author yefeng
     * @description TODO 迭代逆转链表
     * @updateTime 2022/06/24
     */
    public static ListNode reversal(ListNode head){
        return reversalByIterate(head);
    }

    /**
     * @param head 头
     * @param k    k
     * @return {@link ListNode }
     * @throws
     * @title kthToLast 倒数第K个的节点
     * @author yefeng
     * @description TODO 保证k有效(k<n)
     * @updateTime 2022/06/23
     */
    public static ListNode kthToLast(ListNode head,int k){

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
        return p2;
    }



    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4};
        ListNode byArr = createByArr(arr);
        traverse(byArr);
    }

}
