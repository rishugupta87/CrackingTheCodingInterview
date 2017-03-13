package treesandgraphs.Q4_06_InorderSuccessor;

import cciLibrary.BinarySearchTree;
import cciLibrary.TreeNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node
 * in a binary search tree. You may assume that each node has a link to its parent.
 */
public class InorderSuccessor_WithParentLink {

    /**
     * Find inorder successor if the parent link is provided.
     *
     * T(n) = O(n) Space is O(n)
     *
     * @param data
     * @param root
     * @return
     */
    public static TreeNode getInorderSuccessor_withParentLink(int data, final TreeNode root) {
        //first search for this node in the binary tree.
        TreeNode currNode = BinarySearchTree.search(root, data);

        //Case 1 : If the x has a right child then
        // its inorder successor will the left most element in the right sub tree of x.
        if(currNode.right != null) {
            TreeNode tmp = currNode.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else if(currNode.right == null){ //Case 2: If the x doesnt have a right child then its inorder successor will the one of its ancestors,
            // using parent link keep traveling up till you get the node which is the left child of its parent.
            // Then this parent node will be the inorder successor.
            while(currNode.parent != null && currNode.parent.left != currNode) {
                currNode = currNode.parent;
            }
            return currNode.parent;
        }

        //Case 3: if x is the right most node in the tree then its inorder successor will be NULL.
        return null;
    }
}
