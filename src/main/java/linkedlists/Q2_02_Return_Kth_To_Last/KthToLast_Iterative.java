package linkedlists.Q2_02_Return_Kth_To_Last;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**
 * Created by rg029761 on 2/27/17.
 */
public class KthToLast_Iterative {

    /**
     * Use two pointers, one pointing at head (curr), another k steps ahead(runner)
     * Now move runner head till we come to end of LL.
     * At this point curr will point to the kth element
     *
     * Time = O(n)
     * space = O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public static Node printKthToLast(Node head, int k) {

        if(head == null) {
            return null;
        }

        Node curr = head;
        Node runner = head;

        int count = 0;
        while(count < k) {
            if(runner == null) {
                System.out.println("k greater than LL size");
                return null;
            }
            runner = runner.next;
            count++;
        }

        while (runner != null) {
            runner = runner.next;
            curr = curr.next;
        }

        return curr;
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
        final Node node1 = KthToLast_Iterative.printKthToLast(ll.head, 3);
        final Node node2 = KthToLast_Iterative.printKthToLast(ll.head, 10);
        final Node node3 = KthToLast_Iterative.printKthToLast(ll.head, 1);
        final Node node4 = KthToLast_Iterative.printKthToLast(ll.head, 15);

        System.out.println(node1.data);
        System.out.println(node2.data);
        System.out.println(node3.data);

    }
}
