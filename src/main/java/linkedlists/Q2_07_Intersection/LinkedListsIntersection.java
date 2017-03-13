package linkedlists.Q2_07_Intersection;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**
 * Given two (singly) linked lists, determine if the two lists intersect. Return the inter- secting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked
 * list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class LinkedListsIntersection {

    /**
       We now have a multistep process.
       1. Run through each linked list to get the lengths and the tails.
       2. Compare the tails. If they are different (by reference, not by value), return immediately.There is no inter- section.
       3. Set two pointers to the start of each linked list.
       4. On the longer linked list, advance its pointer by the difference in lengths.
       5. Now, traverse on each linked list until the pointers are the same.

     * @param head1
     * @param head2
     * @return
     */
    public static Node findLinkedListsIntersection(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        TailLength tl1 = getTailAndSize(head1);
        TailLength tl2 = getTailAndSize(head2);

        if(tl1.tail != tl2.tail) { //if tails are not the same return they will never intersect. TODO:There is a problem in ur code where this condition is not holding true. fix laters
            return null;
        }
        int diff = Math.abs(tl1.count - tl2.count);

        for(int i = 0 ; i < diff; i++) { //if lengths are equal it wont go in the loop
            if(tl1.count > tl2.count) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
        return findIntersectingNode(head1, head2);
    }


    public static TailLength getTailAndSize(Node head) {
        if (head == null) return null;
        int size = 1;
        Node curr  = head;
        while (curr.next != null) {
            size++;
            curr = curr.next;
        }
        return new TailLength(size, curr);
    }

    private static Node findIntersectingNode(Node head1, Node head2) {
        while (head1.next != null && head2.next != null) {
            if(head1.next == head2.next) {
                return head1.next;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    static class TailLength {
        int count;
        Node tail;

        public TailLength(int count, Node tail ) {
            this.count = count;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(2);
        l1.add(5);
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        l1.add(50);
        l1.add(60);
        l1.add(70);
        l1.add(80);

        LinkedList l2 = new LinkedList(80);
        l2.add(10);
        l2.add(20);
        l2.add(60);
        l2.add(70);
        l2.add(80);

        System.out.println(LinkedListsIntersection.findLinkedListsIntersection(l1.head, l2.head).data);
    }
}
