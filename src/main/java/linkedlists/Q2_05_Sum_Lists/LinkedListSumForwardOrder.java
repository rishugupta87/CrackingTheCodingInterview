package linkedlists.Q2_05_Sum_Lists;

import linkedlists.library.LinkedList;
import linkedlists.library.Node;

/**

 FOLLOW UP
 Suppose the digits are stored in forward order. Repeat the above problem.
 EXAMPLE
 Case1:
         -> 6 -> 1 -> 7->
         -> 2 -> 9 -> 5->
 output: -> 9 -> 1 -> 2->

 Case2:
         -> 1 -> 2 -> 3 -> 4 ->
         -> 5 -> 6 -> 7->
 output: -> 1 -> 8 -> 0 -> 1 ->
 */
public class LinkedListSumForwardOrder {

    //global LL
    final LinkedList resultLL;

    public LinkedListSumForwardOrder() {
        //problem with using a global LinkedList is that if we call the sum method twice it adds results to the same list.
        //same object calling sum twice will result in adding results to previous results
        //TODO: optimize this later
        resultLL = new LinkedList();
    }

    /**
     * Algorithm1:
     * reverse LL1, reverse LL2, add the two linked list using LinkedListSumReverseOrder, reverse the resulting linked list
     *
     * Algorithm2:
     * Start with the last node using recursion and carry to the previous no if sum >= 10
     * However whats challenging about case 2 where one list is longer than the second is to figure out that "5" should be matched with "2" and not 1.
     * To resolve this we pad the shorter lists with 0s at the beginning equal to diff in length of two lists.
     *
     * Note here we are using a global LinkedList for the result , problem with using a global LinkedList is that if we call the sum method twice it adds results to the same list
     */
    public Node sumLinkedLists(Node head1, Node head2) {
        if(head1 == null && head2 == null) {
            return null;
        }
        if(head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        int list1Length = length(head1);
        int list2Length = length(head2);

        //pad zeros at the beginning
        if(list1Length < list2Length) {
            head1 = padZeros(head1, list2Length - list1Length);
        } else {
            head2 = padZeros(head2, list1Length - list2Length);
        }

        Value value = new Value();

        Node n = sum(head1, head2, value);

        if(value.value == 1) { // to incorporate the last carry over
            resultLL.addAtHead(1);
        }

        return n;
    }

    private Node sum(final Node head1, final Node head2, final Value value) {
        if(head1 == null || head2 == null) {
            return null;
        }
        Node node = sum(head1.next, head2.next, value);
        int sum = 0;
        sum += head1.data + head2.data + value.value;
        if(sum >= 10) {
            value.value = 1;
        } else {
            value.value = 0;
        }
        resultLL.addAtHead(sum % 10);

        return node;
    }

    class Value {
        int value;
        public Value() {
            value = 0;
        }
    }

    private Node padZeros(Node head, final int diff) {
        //add node at beginning of the node
        for(int i = 0 ; i < diff; i++) {
            Node newNode = new Node(0);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    private int length(Node head) { // here you are just passing a copy of head and not the actual reference, java is pass by value only.
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList(6);
        ll1.add(1);
        ll1.add(7);

        LinkedList ll2 = new LinkedList(3);
        ll2.add(9);
        ll2.add(5);

        LinkedListSumForwardOrder obj1 = new LinkedListSumForwardOrder();
        obj1.sumLinkedLists(ll1.head, ll2.head);
        LinkedList.printLinkedList(obj1.resultLL.head);

        LinkedList ll3 = new LinkedList(1);
        ll3.add(2);
        ll3.add(3);
        ll3.add(4);

        LinkedList ll4 = new LinkedList(5);
        ll4.add(6);
        ll4.add(7);

        LinkedListSumForwardOrder obj2 = new LinkedListSumForwardOrder();
        obj2.sumLinkedLists(ll3.head, ll4.head);
        LinkedList.printLinkedList(obj2.resultLL.head);
    }
}
