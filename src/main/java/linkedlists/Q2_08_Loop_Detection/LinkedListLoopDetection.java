package linkedlists.Q2_08_Loop_Detection;

import linkedlists.library.Node;

/**
   Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

   DEFINITION
   Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to
   make a loop in the linked list.

   Input: A -) B -) C -) D -) E -) C [the same C as earlier]
   Output: C
 */
public class LinkedListLoopDetection {

    /**
     *
     1. Create two pointers, FastPointer and SlowPointer.
     2. MoveFastPointeratarateof2stepsandSlowPointeratarateof1step.
     3. When they collide, move SlowPointer to LinkedListHead.
        Keep FastPointer where it is.

     4. Move SlowPointer and FastPointer at a·rate of one step.
        Return the new collision point.

     See this video:
     https://www.youtube.com/watch?v=apIw0Opq5nk
     8->1->9>4->2(loop starts)->3->7>2>9>2(back to loop )
     *
     * @param head
     * @return
     */
    public static Node FindBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }
}
