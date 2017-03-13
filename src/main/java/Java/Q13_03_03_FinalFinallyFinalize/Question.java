package Java.Q13_03_03_FinalFinallyFinalize;

/**
 * What is the difference between final, finally,and finalize?
 */
public class Question {

    /**
     *
     * final
     * - When applied to a variable (primitive): The value of the variable cannot change.
     * - When applied to a variable (reference): The reference variable cannot point to any other object on the heap.
     * - When applied to a method: The method cannot be overridden. When applied to a class: The class cannot be subclassed.
     *
     * finally
     * - always executed in try catch to ensure a segment of a code is always executed
     * The f i n a l l y block is often used to write the clean-up code.
     *
     * finalize
     * - called by the garbage collector if no more references exist
     * - The automatic garbage collector calls the finalize() method just before actually destroying the
     * object. A class can therefore override the finalize () method from the Object class in order to define custom
     * behavior during garbage collection.
     *
     * protected void finalize() throws Throwable {
     *       //Close open files, release resources, etc
     *  }
     *
     *
     */
}
