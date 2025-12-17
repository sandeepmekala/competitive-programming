package com.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@VeryImportant
public class AnnotationsExample {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom");

        // Example 1: Check if annotation is present
        if(cat.getClass().isAnnotationPresent(VeryImportant.class))
            System.out.println("Annotation is present");
        else
            System.out.println("Annotation is not present");

        // Example 2: Check if method is annotated
        for(Method method : cat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately runImmediately = method.getAnnotation(RunImmediately.class);
                for(int i = 0; i < runImmediately.times(); i++)
                    try{
                        method.invoke(cat);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
        }

        // Example 3: Check if field is annotated
        for(Field field : cat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportString.class)){
                try{
                    Object object = field.get(cat);
                    if(object instanceof String str){
                        System.out.println(str.toUpperCase());
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface VeryImportant{}

@Target(ElementType.METHOD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface RunImmediately{
    int times() default 1;
}

@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface ImportString{}

@VeryImportant
class Cat{

    @ImportString
    String name;

    Cat(String name){
        this.name = name;
    }

    @RunImmediately(times = 3)
    public void meow(){
        System.out.println("Meow");
    }
}
