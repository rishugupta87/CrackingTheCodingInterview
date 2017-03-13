package stacksandqueues.Q3_04_Queue_via_Stacks;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 *
 Algorithm:
   In this approach, stackNewest has the newest elements on top and stackOldest
   has the oldest elements on top. When we dequeue an element, we want to remove the oldest element first,
   and so we dequeue from stackOldest. If stackOldest is empty, then we want to transfer all elements from stackNewest into
   this stack in reverse order.To insert an element, we push onto stac kNewest, since it has the newest elements on top.
 */
public class MyQueue<T> {
    Stack<T> newestStack = new Stack<T>();
    Stack<T> oldestStack = new Stack<T>();

    public void add(T data) {
        newestStack.push(data);
    }

    public T remove() {
        shiftElementsFromNewToOldStack();
        return oldestStack.pop();
    }

    public T peek() {
        shiftElementsFromNewToOldStack();
        return oldestStack.peek();
    }

    private void shiftElementsFromNewToOldStack() {
        if(oldestStack.isEmpty()) {
            while (!newestStack.isEmpty()) {
                oldestStack.push(newestStack.pop());
            }
        }
        if(oldestStack.isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}

