package com.java.generics;

public class GenericsWithInheritance {
    public static void main(String[] args) {

        // Example 2: Generics with Inheritance
        // Generics can be used with inheritance to restrict the type of classes that can be used.
        Eater<Animal> e = new Eater<>(new Cat());
        e.eat();

        // God can't be added as it doesn't extend Animal
        //Eater<Animal> e2 = new Eater<>(new Dog());
    }
}

class Animal{
    public void eat(){
        System.out.println("Eating");
    }
}
class Cat extends Animal{}
class Dog{}

// We can use Interface as well but still need to extends keyword
// We can extend multiple interfaces but only one class with & separated. Class should be first.
class Eater<T extends Animal>{
    T animal;

    Eater(T animal){
        this.animal = animal;
    }

    public void eat(){
        // Since, T is bounded to Animal, we can call eat method of Animal
        animal.eat();
        System.out.println("Eating: " + this.animal.getClass().getName());
    }
}
