package linkedlists.Q2_05_Sum_Lists;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**
 * Created by rg029761 on 3/2/17.
 */
public class Play {

    public static void main(String[] args) {
        LinkedList ll3 = new LinkedList(1);
        ll3.add(2);
        ll3.add(3);
        ll3.add(4);
        test(ll3.head);
        LinkedList.printLinkedList(ll3.head);
    }

    private static void test(Node head) { // here you are just passing a copy of head and not the actual reference, java is pass by value only.
        while(head != null) {
            head.data = 2; // however the copy of reference can change the value
            head = head.next;
        }
    }
}
