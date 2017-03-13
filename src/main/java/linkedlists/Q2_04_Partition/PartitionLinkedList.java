package linkedlists.Q2_04_Partition;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**
   Partition: Write code to partition a linked list around a value x, such that all nodes
   less than x come before all nodes greater than or equal to x. lf x is contained within the list, the values of
   x only need to be after the elements less than x (see below).The partition element x can appear anywhere in the
   "right partition"; it does not need to appear between the left and right partitions.

   EXAMPLE
   Input: 3 -> 5 -> 8 -> 5 ->10 -> 2 -> 1[partition=5)
   Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class PartitionLinkedList {
    /**
       If we don't care about making the elements of the list "stable"(which there's no obligation to, since
       the interviewer hasn't specified that), then we can instead rearrange the elements by growing the list at the
       head and tail.
       In this approach, we start a "new"list (using the existing nodes). Elements bigger than the pivot element are put
       at the tail and elements smaller are put at the head. Each time we insert an element, we update either the head or tail.\

       Time = O(n)
       space = O(1)
     */
    public static Node partitionLinkedList(Node node, int partition) {
        Node head = node;
        Node tail = node;

        while(node != null) {
            Node tmp = node.next;
            if(node.data < partition) {
                //at node at head, update head
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = tmp;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(3);
        ll.add(5);
        ll.add(8);
        ll.add(5);
        ll.add(10);
        ll.add(2);
        ll.add(1);
        Node head = PartitionLinkedList.partitionLinkedList(ll.head, 5);
        LinkedList.printLinkedList(head);
    }
}
