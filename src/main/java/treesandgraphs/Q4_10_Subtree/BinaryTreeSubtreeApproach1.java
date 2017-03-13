package treesandgraphs.Q4_10_Subtree;

import cciLibrary.TreeNode;

/**
 *
 Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
 algorithm to determine if T2 is a subtree of T1.
 A tree T2 is a subtree ofT T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class BinaryTreeSubtreeApproach1 {
    /**
     * Approach 1:

       consider:
         T1     T2
         3       3
        /         \
       4           4

     doing inorder traversal on T1 and T2 wont give us the answer T1= [4,3] T2=[3,4]

     doing preorder traversal wont give us the answer as although the traversal order is same both trees are structurally different
      - But we can fix this .
      - both trees look same because of the null nodes. What everytime if we see a null node we insert an 'x'
      - T1 = [4,3,X] T2=[X,3,4] now this will give us the correct answer

      Lets try this approach . T1 has m nodes and T2 has n nodes.
      Time complexity = O(n + m)
      Space Complexity = O (n + m) , perceive this as no of recursive calls to traverse t1 and t2
     */
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        //insert "X" inplace of nulls.
        constructComparableTree(t1, sb1);
        constructComparableTree(t2, sb2);

        return sb1.toString().indexOf(sb2.toString()) != -1;
    }

    private static void constructComparableTree(final TreeNode node, final StringBuilder sb) {
        if(node == null) {
            sb.append("X");
        }
        sb.append(node.val + " ");
        constructComparableTree(node.left, sb);
        constructComparableTree(node.right, sb);
    }
}
