package com.trial;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Person> l1 = new ArrayList<>();
        l1.add(new Person("A", 1));

        List<Person> l2 = new ArrayList<>();
        l2.add(new Person(new String("A"), 1));

        if(l1.containsAll(l2))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}

class Person{
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }
}
