package CrackingTheCodingInterview.ch3._2;

import java.util.LinkedList;

// 动物类
abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }
}

// 狗类
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

// 猫类
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

// 动物收容所类
class AnimalShelter {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    // 入队方法
    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    // 出队任意动物
    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    // 出队狗
    public Dog dequeueDog() {
        return dogs.poll();
    }

    // 出队猫
    public Cat dequeueCat() {
        return cats.poll();
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Dog("Dog1"));
        shelter.enqueue(new Cat("Cat1"));
        shelter.enqueue(new Dog("Dog2"));

        Animal adopted = shelter.dequeueAny();
        System.out.println("Adopted: " + adopted.name);

        adopted = shelter.dequeueCat();
        System.out.println("Adopted: " + adopted.name);

        adopted = shelter.dequeueDog();
        System.out.println("Adopted: " + adopted.name);
    }
}    