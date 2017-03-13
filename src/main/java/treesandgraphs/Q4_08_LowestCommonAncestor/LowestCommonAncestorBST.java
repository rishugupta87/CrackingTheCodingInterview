package treesandgraphs.Q4_08_LowestCommonAncestor;

import cciLibrary.BinarySearchTree;
import cciLibrary.TreeNode;

public class LowestCommonAncestorBST {
    /**
     *            60
     *         /     \
     *        55      90
     *       / \     /  \
     *      50  58  85  100
     *           \
     *            59
     *
     *  Algorithm :
     *  1)
     *
     */
    public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return null;
        }
        // ask interviewer what happens if one of the nodes is not present ?
        // if its a must to have both nodes present you need to search and check if both the nodes are present

        if(root.val == n1.val || root.val == n2.val) {
            return root;
        }
        if(n1.val < root.val && n2.val < root.val) { //both are in the left subtree
            return LCA(root.left, n1, n2); // if you find either one of them , we dont need to search the other one as this will be the LCA simply return
        } else if(n1.val > root.val && n2.val > root.val) { //both are in the right subtree,we dont need to search the other one as this will be the LCA simply return
            return LCA(root.right, n1, n2);
        }
        return root; //else one in the left subtree, another in the right subtree.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(60);
        TreeNode n1 = new TreeNode(55);
        TreeNode n2 = new TreeNode(50);
        TreeNode n3 = new TreeNode(58);
        TreeNode n4 = new TreeNode(59);
        TreeNode n5 = new TreeNode(90);
        TreeNode n6 = new TreeNode(85);
        TreeNode n7 = new TreeNode(100);
        root.left = n1;
        root.left.left = n2;
        root.left.right = n3;
        root.left.right.right = n4;
        root.right = n5;
        root.right.left = n6;
        root.right.right = n7;

        System.out.println(LowestCommonAncestorBST.LCA(root, root, n1).val);
        System.out.println(LowestCommonAncestorBST.LCA(root, n3, n4).val);
        System.out.println(LowestCommonAncestorBST.LCA(root, n4, n7).val);
    }
}
