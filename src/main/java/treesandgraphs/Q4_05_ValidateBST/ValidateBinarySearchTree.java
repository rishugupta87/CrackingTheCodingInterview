package treesandgraphs.Q4_05_ValidateBST;

import cciLibrary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBinarySearchTree {
    /**
     Logic: Can do an inorder traversal and populate the list. if list is sorted its a valid BST.

     Time complexity  = O(n) for traversal

     Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).
     The only space usage in your code comes from elements in your Stack<>. Since, as you observed in the question,
     the size of Stack<> at any point is the depth of the current node(i.e., distance from the root), the space complexity of your algorithm is O(height).
     If you have a balanced binary tree, for example, O(height) could be as low as O(log V), where V is the number of vertices in your tree. In the worst case, O(height) = O(V).

     Consider: Note we need to assume how you wanna handle duplicates. in this case if duplicates occur at right of tree they are considered invalid as per line 33
       20  Valid
      /
     20

     20    Invalid
      \
      20

     Can we improve this further ? : Do we really need a list here ? No actually we just need to keep track of last element and make sure currElement > last element.
     Checkout how its done in ValidateBinarySearchTree2

     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        populateListInorder(root, list);
        return isListSorted(list);
    }

    private static boolean isListSorted(final List<Integer> list) {
        int i = 0 ;
        while(i < list.size() - 2) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static void populateListInorder(final TreeNode root, final List<Integer> list) {
        if(root == null) {
            return;
        }
        populateListInorder(root.left, list);
        list.add(root.val);
        populateListInorder(root.right, list);
    }
}
