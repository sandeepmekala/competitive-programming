package edu.java.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

interface Drawable {
    public void draw();
}

interface Sayable {
    public String say();
}

interface Doable {
    public String doIt(String name);
}

interface Addable {
    int add(int a, int b);
}

public class Lambda {
    public static void main(String[] args) {
        int width = 10;

        // without lambda, Drawable implementation using anonymous class
        Drawable d = new Drawable() {
            public void draw() {
                System.out.println("Drawing " + width);
            }
        };

        // with lambda
        Drawable d2 = () -> {
            System.out.println("Drawing " + width);
        };
        d.draw();
        d2.draw();

        Sayable s = () -> {
            return "I have nothing to say.";
        };
        System.out.println(s.say());

        // Lambda expression with single parameter.
        Doable doable = (name) -> {
            return "Hello, " + name;
        };
        System.out.println(doable.doIt("Sonoo"));

        // Multiple parameters in lambda expression
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));

        // Multiple parameters with data type in lambda expression
        Addable ad2 = (int a, int b) -> (a + b);
        System.out.println(ad2.add(100, 200));

        // Lambda expression with return keyword.
        Addable ad3 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(ad3.add(100, 200));

        //Thread Example without lambda  
        Runnable r1=new Runnable(){  
            public void run(){  
                System.out.println("Thread1 is running...");  
            }  
        };  
        Thread t1=new Thread(r1);  
        t1.start();  
        //Thread Example with lambda  
        Runnable r2=()->{  
                System.out.println("Thread2 is running...");  
        };  
        Thread t2=new Thread(r2);  
        t2.start();  


        List<Product> list=new ArrayList<Product>();  
        list.add(new Product(1,"HP Laptop",25000f));  
        list.add(new Product(3,"Keyboard",300f));  
        list.add(new Product(2,"Dell Mouse",150f));  
          
        // implementing lambda expression  
        Collections.sort(list,(p1,p2)->{  
            return p1.name.compareTo(p2.name);  
        });  
        for(Product p : list){  
            System.out.println(p.id+" "+p.name+" "+p.price);  
        }    


        List<Product> list2 = new ArrayList<Product>();  
        list2.add(new Product(1,"Samsung A5",17000f));  
        list2.add(new Product(3,"Iphone 6S",65000f));  
        list2.add(new Product(2,"Sony Xperia",25000f));  
        list2.add(new Product(4,"Nokia Lumia",15000f));  
        list2.add(new Product(5,"Redmi4 ",26000f));  
        list2.add(new Product(6,"Lenevo Vibe",19000f));  
          
        // using lambda to filter data  
        Stream<Product> filtered_data = list2.stream().filter(p -> p.price > 20000);  
          
        // using lambda to iterate through collection  
        filtered_data.forEach(  
                product -> System.out.println(product.name+": "+product.price)  
        );  
    }
}

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  