package stacksandqueues.Q3_05_Sort_Stack;

import java.util.Stack;

/**
 * Created by rg029761 on 3/5/17.
 */
public class SortStack {

    /**
     Algorithm:
      1) Maintain a second stack which will keep elements in sorted order
      2) pop element from stack 1, keep it in a tmp variable
         put this element in sortedStack if this element is > top element in sorted stack else keep popping elements from sorted stack and push in inputStack

       This algorithm is 0 (N2) time and 0 (N) space.


       If we were allowed to use unlimited stacks, we could implement a modified quicksort or mergesort.

       With the mergesort solution, we would create two extra stacks and divide the stack into two parts. We would recursively sort each stack,
       and then merge them back together in sorted order into the original stack. Note that this would require the creation of two additional stacks per level of recursion.

       With the quicksort solution, we would create two additional stacks and divide the stack into the two stacks based on a pivot element. The
       two stacks would be recursively sorted, and then merged back together into the original stack. Like the earlier solution, this one involves creating two
       additional stacks per level of recursion.

     * @param inputStack
     */
    public static void sort(Stack<Integer> inputStack) {
        if(inputStack.isEmpty()) {
            return;
        }
        Stack<Integer> sortedStack = new Stack<Integer>();

        while(!inputStack.isEmpty()) {
            int topElem = inputStack.pop();
            while (!sortedStack.isEmpty() && topElem < sortedStack.peek()) {
                inputStack.push(sortedStack.pop());
            }
            sortedStack.push(topElem);
        }

        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(20);
        stack.push(40);
        stack.push(5);
        stack.push(100);

        SortStack.sort(stack);
    }
}
