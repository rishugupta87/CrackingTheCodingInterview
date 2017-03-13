package linkedlists.Q2_02_Return_Kth_To_Last;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**
 * Find Kth to last element using recursion
 */
public class KthToLast_Recursive {

    /**
     * This algorithm recurses through the linked list. When it hits the end, the method passes back a counter set to o.Each
     * parent call adds 1 to this counter.When the counter equals k, we know we have reached the kth to last element of the linked list.
     *
     * Problem ?
     * Implementing this is short and sweet- provided we have a way of"passing back"an integer value through the stack.
     * Unfortunately, we can't pass back a node and a counter using normal return statements. So how do we handle this?
     *
     * Approach A: Don't Return the Element.
     * This  is what this method does instead of returning element we are printing value
     *
     * @param head
     * @param k
     * @return
     */
    public static int printKthToLast_approachA(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast_approachA(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    /**
     * This approach uses a wrapper class
     *
     * Important question to understand recursion.
     *
     * the issue was that we couldn't simultaneously return a counter and an index.
     * If we wrap the counter value with simple class (or even a single element array), we can mimic passing by reference.
     *
     * @param head
     * @param k
     * @param index
     * @return
     */
    public static Node printKthToLast_approachB(Node head, int k, Index index) {
        if (head == null) {
            return null;
        }
        Node node = printKthToLast_approachB(head.next, 3, index);
        index.value = index.value + 1;
        if (index.value == k) {
            return head;
        }
        return node;
    }

    static class Index {
        int value;
        public Index() {
            value = 0;
        }
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(60);
        ll.add(70);
        ll.add(80);
        ll.add(90);
        ll.add(100);
        Index index = new Index();
        final Node node = KthToLast_Recursive.printKthToLast_approachB(ll.head, 3, index);
        System.out.println(node.data);
    }
}
