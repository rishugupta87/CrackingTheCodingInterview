package stacksandqueues.library;

import java.util.EmptyStackException;

/**
 * Note stack can be implemented using a LinkedList if we add and remove elements from the same end.
 *
 * @param <T>
 */
public class Stack<T> {
    StackNode<T> tos;

    public Stack() {
        tos = null;
    }

    /**
     * Similar to adding element at head of the linkedlist
     *
     * @param data
     */
    public void push(T data) {
        StackNode<T> nodeToAdd = new StackNode<T>(data);
        nodeToAdd.next = tos;
        tos = nodeToAdd;
    }

    /**
     * Remove element from head of LinkedList
     *
     * @return
     */
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T topElem = tos.data;
        tos = tos.next;
        return topElem;
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return tos.data;
    }

    private boolean isEmpty() {
        return tos == null;
    }
}
