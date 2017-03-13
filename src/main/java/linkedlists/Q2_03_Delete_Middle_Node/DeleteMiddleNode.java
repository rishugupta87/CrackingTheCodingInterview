package linkedlists.Q2_03_Delete_Middle_Node;

import linkedlists.library.Node;

/**
    Implement an algorithm to delete a node in the middle
    any node but the first and last node, not necessarily the exact middle) of a singly linked list,
    given only access to that node.

    SOLUTION
    EXAMPLE
    Input: the node c from the linked list a- >b- >c - >d - >e- >f
    output : a->b->d>e->f
 */
public class DeleteMiddleNode {
    /**
     * Given access to n solution if to copy the next node after n i.e (n+1)th node to n
     * and delete node n+1
     *
     * @param n
     * @return
     */
    public static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false; // Failure
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}
