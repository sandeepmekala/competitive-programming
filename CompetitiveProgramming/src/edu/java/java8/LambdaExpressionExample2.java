package edu.java.java8;
@FunctionalInterface  //It is optional  
interface Drawable2{  
    public void draw();  
}  
  
public class LambdaExpressionExample2 {  
    public static void main(String[] args) {
        int width=10;
        
        //with lambda
        Drawable d2=()->{
            System.out.println("Drawing "+width);
        };
        d2.draw();  
    }  
}  