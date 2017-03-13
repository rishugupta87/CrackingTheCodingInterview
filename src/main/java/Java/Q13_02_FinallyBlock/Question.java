package Java.Q13_02_FinallyBlock;

/**
 * Return from Finally: In Java, does the finally block get executed if we insert a return statement
 * inside the try block of a try-catch-finally?
 */
public class Question {

    /**

     Yes, it will get executed.The finally block gets executed when the try block exits. Even when we attempt to
     exit within the try block (via a return statement,a continue statement, a break statement or any exception),
     the finally block will still be executed.

     Note that there are some cases in which the finally block will not get executed, such as the following: •
     - If the virtual machine exits during try / catch block execution.
     - If the thread which is executing during the try/catch block gets killed
     *
     */
}
