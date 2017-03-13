package stacksandqueues.Q3_06_Animal_Shelter;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis. People
 * must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they
 * would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linked L is t data structure.
 */
public class AnimalShelter {
    LinkedList<Dog> dogs;
    LinkedList<Cat> cats;

    private static int order = 0; //order in which animal arrive at the animal shelter

    public AnimalShelter() {
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if(animal instanceof Dog) {
            dogs.add((Dog)animal); // the default add method of LinkedList at the elements at the end of LinkedList.
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeAny() {
        if(dogs.size() == 0 && cats.size() == 0) {
            throw new NoSuchElementException();
        }
        if(dogs.size() == 0) {
            return dequeCats();
        } else if(cats.size() == 0) {
            return dequeDogs();
        }

        //deque either dog or a cat based on arrival time.
        Dog oldestDog = dogs.peek(); // this gives the first element in the linkedlist.
        Cat oldestCat = cats.peek();

        return oldestDog.order < oldestCat.order ? dequeDogs() : dequeCats();
    }

    private Dog dequeDogs() {
        if(dogs.size() == 0) {
            throw new NoSuchElementException();
        }
        return dogs.poll(); //poll removes head of linkedlist
    }

    private Cat dequeCats() {
        if(cats.size() == 0) {
            throw new NoSuchElementException();
        }
        return cats.poll();
    }

    public static void main(String[] args) {
        Animal animal1 = new Dog("jimmy");
        Animal animal2 = new Cat("bazinga");
        Animal animal3 = new Dog("ranzo");
        Animal animal4 = new Dog("bruno");
        Animal animal5 = new Cat("poppper");

        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(animal1);
        animalShelter.enqueue(animal2);
        animalShelter.enqueue(animal3);
        animalShelter.enqueue(animal4);
        animalShelter.enqueue(animal5);

        System.out.println(animalShelter.dequeAny().name);
        System.out.println(animalShelter.dequeAny().name);
        System.out.println(animalShelter.dequeCats().name);
        System.out.println(animalShelter.dequeDogs().name);
    }
}
