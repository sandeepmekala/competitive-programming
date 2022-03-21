package edu.java.java8;
interface Drawable{  
    public void draw();  
}  
public class LambdaExpressionExample {  
    public static void main(String[] args) {  
        int width=10;  
  
        //without lambda, Drawable implementation using anonymous class  
        Drawable2 d=new Drawable2(){  
            public void draw(){System.out.println("Drawing "+width);}  
        };  
        d.draw();  
    }  
}  