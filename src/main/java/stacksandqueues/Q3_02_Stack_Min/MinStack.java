package stacksandqueues.Q3_02_Stack_Min;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the
 * minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class MinStack extends Stack<Integer>{

    /**
     * Maintain a second stack that just keeps track of min
     *
     * when pushing, push on org stack, push on minStack only if currElem < minStack.peek
     * when popping, pop from orgStack, pop from minStack only if currElem = minStack.peek
     *
     */
    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<Integer>();
    }

    public void push(int value){
        if (value <= min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
