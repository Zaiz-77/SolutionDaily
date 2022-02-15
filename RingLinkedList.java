package com.solutionDiary;

/*
2022/2/15
给定一个链表，判断链表中是否有环
环：如果一个结点可由其next追踪到该结点，则链表有环
若有环，返回true，否则返回false
 */

public class RingLinkedList {
    // 内部类，帮助我们形成链表
    static class Node{
        int data;
        Node next;
        boolean visited;

        // 构造器
        public Node(int data, Node next, boolean visited){
            this.data = data;
            this.next = next;
            this.visited = visited;
        }
    }

    // 方法一：遍历 需要开辟新的属性visited
    public static boolean travel(Node cursor){
        // 先把该结点访问
        cursor.visited = true;
        // 如果有后继结点，则循环
        while (cursor.next != null){
            // 如果还没标记之前就已经被访问，说明有环
            if (cursor.next.visited) {
                return true;
                // 否则标记为被访问
            }else {
                cursor = cursor.next;
                cursor.visited = true;
            }
        }
        return false;
    }

    // 方法二：双指针 如果不是快慢指针，那两者以共同速度运行就不会相遇
    public static boolean doublePointer(Node cursor){
        Node slow = cursor;
        Node quick = cursor.next;
        while (slow != quick){
            if (quick.next.next == null){
                return false;
            }
            // 一个速度为1， 一个速度为2，如果进入环，那么俩肯定会相遇，慢的被快的追上
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    // 主程序
    public static void main(String[] args) {
        Node node5 = new Node(5,null,false);
        Node node4 = new Node(4,node5,false);
        Node node3 = new Node(3,node4,false);
        Node node2 = new Node(2,node3,false);
        Node node1 = new Node(1,node2,false);
        node5.next = node3;
        System.out.println(travel(node1));
        System.out.println(doublePointer(node1));
    }
}

