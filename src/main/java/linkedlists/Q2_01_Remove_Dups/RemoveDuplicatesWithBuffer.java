package linkedlists.Q2_01_Remove_Dups;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

import java.util.HashSet;
import java.util.Set;

/**
 Write code to remove duplicates from an unsorted linked list.

 FOLLOW UP
 How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicatesWithBuffer {

    /**
     * Can easily remove duplicates in one pass using hashtable/hash set
     *
     * T(n) = O(n)
     * Space = O(n)
     */
    public static void removeWithBuffer(Node head) {
        if(head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node curr = head;

        Set<Integer> visited = new HashSet<Integer>();

        while(curr != null) {
            if(!visited.contains(curr.data)) {
                visited.add(curr.data);
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = prev.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.add(1);
        ll.add(12);
        ll.add(3);
        ll.add(12);
        ll.add(8);
        ll.add(3);
        ll.add(9);
        ll.add(10);
        ll.add(1);

        RemoveDuplicatesWithBuffer.removeWithBuffer(ll.head);
        LinkedList.printLinkedList(ll.head);
    }
}
