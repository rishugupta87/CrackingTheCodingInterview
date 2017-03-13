package cciLibrary;

/**
 * Created by rg029761 on 2/8/17.
 */
public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree(int data) {
        root = new TreeNode(data);
        root.left = null;
        root.right = null;
    }

    public void add(int data) {
        addNode(data, root);
    }

    public void deleteNode(int data) {
        TreeNode prevNode = null;
        TreeNode currNode = root; //60

        while(currNode.val != data) {
            if(data < currNode.val) {
                prevNode = currNode;
                currNode = currNode.left;
            } else {
                prevNode = currNode;
                currNode = currNode.right;
            }
        }

        //found a match at this point.
        if(currNode.left != null && currNode.right != null) {
            //replace current node with leftmost child in right subtree or rightmost child in left subtree
            prevNode = currNode; //keep track of previous node which is to be deleted
            currNode = currNode.right;
            TreeNode tmp = null; //keep track of parent

            //find the smallest node
            while(currNode.left != null) {
                tmp = currNode;
                currNode = currNode.left;
            }
            prevNode.val = currNode.val;

            if(tmp == null) { //check deleting 70 to understand why we did this
                tmp = prevNode;
            }
            if(currNode.val >= tmp.val) {
                tmp.right = currNode.right;
            } else {
                tmp.left = currNode.left;
            }
        } else if(currNode.left == null && currNode.right != null) {
            prevNode.right = currNode.right;
        } else if(currNode.right == null && currNode.left != null) {
            prevNode.left = currNode.left;
        } else {
            if(currNode.val < prevNode.val) {
                prevNode.left = null;
            } else {
                prevNode.right = null;
            }
        }
    }

    private void addNode(int data, TreeNode root) {
        if(data <= root.val) {
            if(root.left == null) {
                root.left = new TreeNode(data);
                return;
            } else {
                addNode(data, root.left);
            }
        }
        if(data > root.val) {
            if(root.right == null) {
                root.right = new TreeNode(data);
                return;
            } else {
                addNode(data, root.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(60);
        bst.add(50);
        bst.add(75);
        bst.add(70);
        bst.add(80);
        bst.add(55);
        bst.add(45);
        bst.add(90);

        System.out.println("before  deletion");
        BinaryTreePrinter.printNode(bst.root);
        BinaryTree.inorder(bst.root);

        int data = 75;
        System.out.println("deleting node" + data);
        bst.deleteNode(data);

        System.out.println("after  deletion");
        BinaryTreePrinter.printNode(bst.root);
        BinaryTree.inorder(bst.root);
    }

    public static boolean ifNodeExists(final TreeNode root, final TreeNode node) {
        return true;
    }

    public static TreeNode search(final TreeNode root, final int data) {
        return null;
    }
}
