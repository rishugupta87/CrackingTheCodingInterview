package linkedlists.Q2_05_Sum_Lists;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**
   Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
   The digits are stored in reverse order, such that the 1's digit is at the head of the list.
   Write a function that adds the two numbers and returns the sum as a linked list.

   EXAMPLE
   Input: (7-) 1 -) 6) + (5 -) 9 -) 2).That is,617 + 295. Output: 2 -) 1 -) 9.That is, 912.

   Test cases to consider:
          ->7->1->6->       ->7->1->6->     ->7->1->6->3->2
          ->5->9->2->       ->5->9->4->     ->5->9->4
 output:  ->2->1->9->       ->2->1->1->1    ->2->1->1->4->2
 */
public class LinkedListsSumReverseOrder {

    public static Node sumLinkedLists(Node head1, Node head2) {

        if(head1 == null && head2 == null) {
            return null;
        }
        if(head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        LinkedList ll = new LinkedList();

        Node curr1 = head1;
        Node curr2 = head2;
        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int sum = 0;
            sum += carry;
            if(curr1 != null) {
                sum += curr1.data;
                curr1 = curr1.next;
            }
            if(curr2 != null) {
                sum += curr2.data;
                curr2 = curr2.next;
            }
            carry = sum >= 10 ? 1 : 0;
            ll.add(sum % 10);
        }

        //if at the end of both list but still a carry append the carry at the end.
        if(carry == 1) {
            ll.add(1);
        }

        return ll.head;
    }

    public static void main(String[] args) {

        //case 1:
        LinkedList ll1 = new LinkedList(7);
        ll1.add(1);
        ll1.add(6);

        LinkedList ll2 = new LinkedList(5);
        ll2.add(9);
        ll2.add(2);

        //case 2
        LinkedList ll3 = new LinkedList(7);
        ll3.add(1);
        ll3.add(6);

        LinkedList ll4 = new LinkedList(5);
        ll4.add(9);
        ll4.add(4);

        //case 3
        LinkedList ll5 = new LinkedList(7);
        ll5.add(1);
        ll5.add(6);
        ll5.add(3);
        ll5.add(2);

        LinkedList ll6 = new LinkedList(5);
        ll6.add(9);
        ll6.add(4);

        Node head1 = sumLinkedLists(ll1.head, ll2.head);
        Node head2 = sumLinkedLists(ll3.head, ll4.head);
        Node head3 = sumLinkedLists(ll5.head, ll6.head);
        LinkedList.printLinkedList(head1);
        LinkedList.printLinkedList(head2);
        LinkedList.printLinkedList(head3);
    }
}
