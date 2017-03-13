package treesandgraphs.Q4_03_ListOfDepthsBinaryTree;

import cciLibrary.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListOfDepthsBinaryTree_DFS {

    public static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        if(root == null) {
            return new ArrayList<LinkedList<TreeNode>>();
        }
        Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();

        List<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
        for(int level : map.keySet()) {
            result.add(map.get(level));
        }
        return result;
    }

    private static void createLL(final TreeNode root, Map<Integer, LinkedList<TreeNode>> map, int level) {
        if(root == null) {
            return;
        }
        if(!map.containsKey(level)) {
            LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
            linkedList.addLast(root);
            map.put(level, linkedList);
        } else {
            LinkedList list = map.get(level);
            list.addLast(root);
            map.put(level, list);
        }
        createLL(root.left, map, level++);
        createLL(root.right, map, level++);
    }
}
