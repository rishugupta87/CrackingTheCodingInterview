package cciLibrary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rg029761 on 2/4/17.
 */
public class BinaryTree {
    TreeNode root;
    private static final Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public BinaryTree(int data) {
        root = new TreeNode(data);
        root.left = null;
        root.right = null;
    }

    public static int height(final TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void add(int data) {
        if(queue.isEmpty()) {
            queue.add(root);
        }
        TreeNode newNode = new TreeNode(data);
        addNode(newNode);
    }

    private void addNode(final TreeNode currNode) {
        if(currNode == null) return;
        if(queue.peek().left == null) {
            queue.add(currNode);
            queue.peek().left = currNode;
            return;
        }
        if(queue.peek().right == null) {
            queue.add(currNode);
            queue.peek().right = currNode;
            return;
        }
        queue.remove();
        addNode(currNode);
    }

    public static boolean ifNodeExists(final TreeNode root, final TreeNode node) {
        if(root == null) {
            return false; //havent found the node so far
        }
        if(root.val == node.val) {
            return true;
        }
        // in or condition if we found the node recursing the left subtree it wont recurse the right subtree.
        // if this was an and condition it would have recursed both left and right subtree.
        return ifNodeExists(root.left, node) || ifNodeExists(root.right, node);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(10);
        bt.add(20);
        bt.add(30);
        bt.add(40);
        bt.add(50);
        bt.add(60);
        BinaryTreePrinter.printNode(bt.root);
        bt.inorder(bt.root);
    }
}
