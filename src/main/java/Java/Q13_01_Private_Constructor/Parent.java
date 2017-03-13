package Java.Q13_01_Private_Constructor;

/**
 * In terms of inheritance what is the effect of keeping the constructor private.
 *
 *

 Solution
 1) By Keeping the constructor private the class cannot be subclassed from outside , however inner classes can extend them

 */
public class Parent {

    private Parent() {
        System.out.println("Parent constructor");
    }

    private void run() {
        System.out.println("I am running");
    }

    public void talk() {
        System.out.println("I am talking");
    }

    static class A extends Parent{ // since this is a nested class it can access parents constructor even if its private.
        public A() {
            System.out.println("A constructor");
        }
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.talk();
        parent.run();
        A a = new A();
    }
}
