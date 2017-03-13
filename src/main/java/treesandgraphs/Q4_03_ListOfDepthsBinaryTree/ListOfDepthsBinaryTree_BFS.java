package treesandgraphs.Q4_03_ListOfDepthsBinaryTree;

import cciLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g.,
 * if you have a tree with depth 0, you'll have 0 linked lists).
 */
public class ListOfDepthsBinaryTree_BFS {
    public static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        while(!queue.isEmpty()) {
            int noOfLevelNodes = queue.size();

            //create a new linked list at each level
            LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();

            while (noOfLevelNodes > 0) {
                TreeNode node = queue.remove();
                linkedList.add(node);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                noOfLevelNodes --;
            }
            //when you are done with the current level
            result.add(linkedList);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
    }

}


