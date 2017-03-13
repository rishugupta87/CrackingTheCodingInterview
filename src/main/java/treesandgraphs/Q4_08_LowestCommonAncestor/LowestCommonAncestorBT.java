package treesandgraphs.Q4_08_LowestCommonAncestor;

import cciLibrary.BinaryTree;
import cciLibrary.TreeNode;

public class LowestCommonAncestorBT {
    /**
     *      10
     *    /   \
     *   20    30
     *  /  \
     * 40   50
     *     /
     *    60
     *
     *  LCA(10,20) = 10
     *  LCA(40,30) = 10
     *  LCA(20,30) = 10
     *  LCA (40,50) = 20
     *  LCA(50, 60) = 50
     *
     *  LCA(1, 2) = null (both don't exist)
     *  LCA(1, 30) = null (1 does not exists)
     *
     *  Algorithm:
     *  1) Check if both nodes exist. If neither one exist return null
     *  2) Check for both nodes first in left subtree . If either one of them is found in left return that node, else return null
     *  3) Search for both nodes in right subtree . If either one of them is found in left return that node, else return null
     *  4) Because of check at step 1 we know step 2 and step 3 will return some node value
     *  5) If after step 2 and step 3 we get some node back, that means one of the node was found in left subtree and the other in right subtree. So return root as LCA
     *  6) If only step 3 returns a node then that node is the LCA.
     *  7) If only step 4 return a node then that node is the LCA
     *
     *  Time Complexity:
     *  1) search is exists O(n) as we need to visit all the nodes at least once.
     *  2) searching in left and right subtree take O(n)
     *  3) Total time taken is O(n)
     */
    public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null || n1 == null || n2 == null) {
            return null;
        }
        if(!(BinaryTree.ifNodeExists(root, n1) && BinaryTree.ifNodeExists(root, n2))) {
            return null;
        }
        return findLCA(root, n1, n2);
    }

    private static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return null;
        }
        if(root.val == n1.val || root.val == n2.val) {
            return root;
        }
        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);

        if(left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(40);
        TreeNode n3 = new TreeNode(50);
        TreeNode n4 = new TreeNode(60);
        TreeNode n5 = new TreeNode(30);
        root.left = n1;
        root.left.left = n2;
        root.left.right = n3;
        root.left.right.left = n4;
        root.right = n5;

        System.out.println(LowestCommonAncestorBT.LCA(root, n1, root).val);
        System.out.println(LowestCommonAncestorBT.LCA(root, n2, n5).val);
        System.out.println(LowestCommonAncestorBT.LCA(root, n1, n5).val);
        System.out.println(LowestCommonAncestorBT.LCA(root, n2, n3).val);
        System.out.println(LowestCommonAncestorBT.LCA(root, n3, n4).val);
    }
}
