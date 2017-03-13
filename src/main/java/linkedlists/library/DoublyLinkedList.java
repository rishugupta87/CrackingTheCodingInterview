package linkedlists.library;

public class DoublyLinkedList {
    DoublyLLNode head;

    public DoublyLinkedList(int data) {
        head = new DoublyLLNode(data);
    }

    /**
     * At the beginning
     *
     * @param data
     */
    public void addAtHead(int data) {
        if(head == null) {
            return;
        }

        DoublyLLNode node = new DoublyLLNode(data);
        head.prev = node;
        node.next = head;
        head = node;
    }

    /**
     * At at the end.
     *
     * @param data
     */
    public void add(int data) {
        if(head == null) {
            return;
        }

        DoublyLLNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        DoublyLLNode node = new DoublyLLNode(data);
        curr.next = node;
        node.prev = curr;
    }

    /**
     * To add at a position
     *
     * @param data
     * @param pos
     */
    public void addAtPosition(int data, int pos) {
        if(head == null) {
            return;
        }
        if(pos == 1) {
            addAtHead(data);
            return;
        }
        DoublyLLNode curr = head;
        int count = 1;
        while(curr != null && count != pos - 1) {
            count++;
            curr = curr.next;
        }
        if(curr == null) {
            return;
        }
        DoublyLLNode node = new DoublyLLNode(data);
        node.next = curr.next;
        curr.next = node;
        node.prev = curr;
        node.next.prev = node;
    }

    public void delete(int data) {

        if(head == null) {
            return;
        }
        if(head.data == data) {
            head = head.next;
            head.prev = null;
        }
        DoublyLLNode curr = head;

        while(curr.next != null && curr.next.data != data) {
            curr = curr.next;
        }
        if(curr.next == null) {
            return;
        }
        curr.next = curr.next.next;
        if(curr.next != null) {
            curr.next.prev = curr;
        }
    }

    public static void printLinkedList(final DoublyLLNode head) {
        DoublyLLNode current = head;
        while (current != null) {
            System.out.printf("%s,", current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        System.out.println("************add 25 at pos = 3************");
        ll.addAtPosition(25, 3);
        printLinkedList(ll.head);
        System.out.println("************delete 25************");
        ll.delete(25);
        printLinkedList(ll.head);
        System.out.println("************delete 10************");
        ll.delete(10);
        printLinkedList(ll.head);
        System.out.println("************delete 40************");
        ll.delete(40);
        printLinkedList(ll.head);
        System.out.println("************add 5 at head************");
        ll.addAtHead(5);
        printLinkedList(ll.head);
    }
}
