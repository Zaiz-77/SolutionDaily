package com.solutionDiary;

/*
2022/2/12
用两种方法实现对链表的反转
反转：将各自的后继设置为自己的前驱
例如：对于链表 1 → 2 → 3
反转前：1 → 2 → 3
反转后：3 → 2 → 1
 */

public class LinkedListReverse {
    // 内部类 创建一个链表结点类
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 方法一：迭代法
    public static Node iterate(Node head) {
        Node prev = null, temp;
        Node curr = head;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            // 当前curr就是接下来要处理结点的prev结点
            // 而下一个结点应该是curr结点的next结点，我们存放在temp中
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // 方法二： 递归法
    public static Node recursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 第一次调用的时候已经调用head了，能进下一步肯定是它的后继结点
        Node new_head = recursion(head.next);
        // 进行反转
        head.next.next = head;
        head.next = null;
        return new_head;
    }

    // 主程序
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        // 把生成的结点存起来，拿到头结点就相当于拿到了链表
        Node prev1 = recursion(node1);
        Node prev2 = iterate(node1);
        System.out.println(" " + prev1 + prev2);
    }
}
