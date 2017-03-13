package linkedlists.Q2_01_Remove_Dups;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

public class RemoveDuplicatesWithoutBuffer {

    /**
     * Time = O(n^2)
     * Space = O(1)
     *
     * @param head
     */
    public static void removeWithoutBuffer(Node head) {
        Node current = head;
        while (current != null) {
			/* Remove all future nodes that have the same value */
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
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

        RemoveDuplicatesWithoutBuffer.removeWithoutBuffer(ll.head);
        LinkedList.printLinkedList(ll.head);
    }
}
