package com.solutionDiary;

/*
2022/2/20
二叉树的遍历
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTravel {
    // 内部类，帮助构造二叉树
    static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    // 先序遍历，递归
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    // 中序遍历，递归
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.leftChild);
        System.out.print(root.data + " ");
        inOrder(root.rightChild);
    }

    // 后序遍历，递归
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data + " ");
    }

    // 层序遍历，借助队列
    public static void levelOrder(TreeNode root) {
        // 构造队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        else queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.leftChild != null) queue.add(temp.leftChild);
            if (temp.rightChild != null) queue.add(temp.rightChild);
        }
    }

    // 先序遍历，借助栈
    public static void preOrderIterate(TreeNode root) {
        // 根 左 右 只需要右边比左先入栈即可
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                System.out.print(temp.data + " ");
                if (temp.rightChild != null) stack.push(temp.rightChild);
                if (temp.leftChild != null) stack.push(temp.leftChild);

            }
        }
    }

    // 主程序
    public static void main(String[] args) {
        // 构造二叉树
        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(6, null, null);
        TreeNode node3 = new TreeNode(5, node4, node5);
        TreeNode node2 = new TreeNode(7, null, null);
        TreeNode node1 = new TreeNode(1, node3, node2);
        // 测试
        preOrder(node1);
        System.out.println();

        inOrder(node1);
        System.out.println();

        postOrder(node1);
        System.out.println();

        levelOrder(node1);
        System.out.println();

        preOrderIterate(node1);
    }
}
