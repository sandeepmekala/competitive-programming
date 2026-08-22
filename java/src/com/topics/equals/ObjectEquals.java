package com.java.equals;

public class ObjectEquals {

        public static void main(String[] args) {
            Person p1 = new Person("A", 1);
            Person p2 = new Person("A", 1);

            if(p1.equals(p2))
                System.out.println("Equal");
            else
                System.out.println("Not Equal");
        }
}

class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))    // It is important to use .equals method instead of == operator
            return false;
        if (age != other.age)
            return false;
        return true;
    }

}
