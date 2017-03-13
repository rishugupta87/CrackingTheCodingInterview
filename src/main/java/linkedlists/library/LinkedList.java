package linkedlists.library;

public class LinkedList {
    public Node head;

    public LinkedList(int data) {
        head = new Node(data);
    }

    public LinkedList() {
        head = null;
    }

    /**
     * Adds element at the head takes constant time
     *
     * @param data
     */
    public void addAtHead(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * This will add element at the tail of the linked list.
     * Adding an element ideally should be O(n) operation since we need to iterate the list to go to the end node everytime.
     * We implement in this way in this method
     *
     * However java.util.LinkedList implementation maintains a reference which keeps track of the last node
     * and hence this operation too becomes O(1)
     *
     * @param data
     */
    public void add(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);
    }

    /**
     * This will be O(n) since we will need to iterate over the LL to first find the element
     *
     * @param data
     * @return
     */
    public Node remove(int data) {
        //if you want to delete the node at the beginning
        if(head.data == data) {
            head = head.next;
            return head;
        }

        Node curr = head;
        while(curr != null && curr.next.data != data) {
            curr = curr.next;
        }

        if(curr == null) {
            return head;
        }

        curr.next = curr.next.next;

        return head;
    }

    public static void printLinkedList(final Node head) {
        Node current = head;
        while (current != null) {
            System.out.printf("%s -> ", current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.addAtHead(5);
        ll.remove(30);
        ll.remove(5);
        printLinkedList(ll.head);
    }
}
