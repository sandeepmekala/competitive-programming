package com.java.java8new.li04.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
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
    static int outerstaticnum;
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


        // sort
        List<String> list3 = Arrays.asList("a", "x", "b");

		// anonymous comparator
		Collections.sort(list3, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		System.out.println(list3);

		// lamda expression
		// all functional intefaces can be replaces with lamda expressions
		Collections.sort(list3, (String a, String b) -> {
			return a.compareTo(b);
		});

		// if body is single line, we don't need to add return and flower
		// brackets
		Collections.sort(list3, (String a, String b) -> a.compareTo(b));

		// compiler is already aware of the parameter types, you can even ignore
		// them
		Collections.sort(list3, (a, b) -> a.compareTo(b));


        // Lamda scopes ----------------------------------------------------
		// lamda can access local final variables, instance variables, static
		// variables even if final keyword is not used, it should be effectively final
		final int num = 1;
		Function<Integer, String> converter = (from) -> String.valueOf(num);
		//num =3;

		// same applies for anonymous objects
		int num2 = 2;
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return a * num2;
			}
		};
		// num2 = 3;

		// Even modify from outer static variables
		Function<Integer, String> convert4 = (from) -> {
			outerstaticnum = 12;
			return String.valueOf(from);
		};

		// Even modify from outer instance variables
        //int outernum;
		Function<Integer, String> convert5 = (from) -> {
			//outernum = 12;
			return String.valueOf(from);
		};

		// default methods can not be access from lamda expression but can be
		// accessed from anonymous objects
		// This gives compilation error
		// Formula formula2 = (a) -> sqrt(a);

		// This works fine
		Formula formula2 = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
		};
		// Lamda scopes ----------------------------------------------------
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

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}