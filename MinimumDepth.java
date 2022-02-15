package com.solutionDiary;

/*
2022/2/15
给定一个二叉树，找出二叉树的最小深度
深度：根节点到最近叶子结点的路径上结点的个数
这个同时能解决最大深度的问题
 */

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
    // 内部类：二叉树的结点
    static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        int depth;

        public Node(int data, Node leftChild, Node rightChild){
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    // 解法一：深度优先遍历 DFS
    public static int dfs(Node root){
        if (root.leftChild == null && root.rightChild == null){
            return 1;
        }
        if (root.leftChild == null) return dfs(root.rightChild) + 1;
        if (root.rightChild == null) return dfs(root.leftChild) + 1;
        return Math.min(dfs(root.leftChild), dfs(root.rightChild)) + 1;
    }

    // 解法二：广度优先遍历 BFS 依靠队列来实现
    public static int bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        root.depth = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if (temp.leftChild != null){
                temp.leftChild.depth = temp.depth + 1;
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                temp.rightChild.depth = temp.depth + 1;
                queue.add(temp.rightChild);
            }
            if (temp.leftChild == null && temp.rightChild == null){
                return temp.depth;
            }
        }
        return 0;
    }

    //主程序
    public static void main(String[] args) {
        Node node6 = new Node(6, null, null);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);
        Node node3 = new Node(3, null, node6);
        Node node2 = new Node(2, node4, null);
        Node node1 = new Node(1, node2, node3);
        System.out.println(dfs(node1));
        System.out.println(bfs(node1));
    }
}
