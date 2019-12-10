package com.zl.github;

import java.util.List;

/**
 * @Author zl
 * @Date 2019-12-10
 * @Des 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class two_sum_1 {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.setNext(node2);
        node3.setNext(node4);
        Node value = addSum(node,node3);
        System.out.println("########################");
    }


    /**
     * 大致分为三种情况
     * 1:  l1=[0,1]，l2=[0,1,2]
     * 2:  l1=[]，l2=[0,1]
     * 3:  l1=[9,9]，l2=[1]
     *
     * @param p
     * @param q
     * @return
     */
    public static Node addSum(Node l1, Node l2) {
        Node head = new Node(0);
        Node p = l1, q = l2, curr = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.value : 0;
            int y = (q != null) ? q.value : 0;
            int sum = carry + x + y;//需要判断是否进位
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return head.next;
    }


    static class Node {
        private Node next;

        private Integer value;

        public Node() {
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node(Integer value) {
            this.value = value;
        }
    }
}
