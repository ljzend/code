package com.ljz;

import java.util.Stack;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/11  20:44
 */

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}


public class Solution {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode first = new ListNode(-1);
        first.next = head;

        ListNode pre = first;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        resverListNode(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;

        return first.next;
    }

    private static void resverListNode(ListNode leftNode) {
        ListNode pre = null;
        ListNode cur = leftNode;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseBetween(head, 2, 4);
        Stack<Object> objects = new Stack<>();
    }
}