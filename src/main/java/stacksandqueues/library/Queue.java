package stacksandqueues.library;

import java.util.NoSuchElementException;

/**
 * Note queue can be implemented using a LinkedList if we add and remove elements from the opposite ends.
 *
 * @param <T>
 */
public class Queue<T> {
    QueueNode<T> first;
    QueueNode<T> last; //we also keep track of the last node so that we can add nodes at the end in constant time.

    public Queue() {
        first = null;
        last = null;
    }

    /**
     * Similar to Adding elements at the end of the LinkedList
     *
     * @param data
     */
    public void add(T data) {
        QueueNode nodeToAdd = new QueueNode(data);
        if(last == null) {
            last = nodeToAdd;
            first = last;
            return;
        }
        last.next = nodeToAdd;
        last = last.next;
    }

    /**
     * Similar to Removing elements from the beginning of the LinkedList
     *
     * @return
     */
    public T remove() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        T firstElem = first.data;
        first = first.next;
        if(first == null) { //extra careful of handling this
            last = null;
        }
        return firstElem;
    }

    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
