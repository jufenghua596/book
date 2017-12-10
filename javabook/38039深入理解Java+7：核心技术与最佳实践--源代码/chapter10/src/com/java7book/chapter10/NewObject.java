package com.java7book.chapter10;

class Animal {
    int legs = 0;
    Animal(int legs) {
        System.out.println("Animal constructor");
        this.legs = legs;
    }
}

class Dog extends Animal {
    String name = "<default>";
    Dog() {
        super(4);
        System.out.println("Dog constructor");
    }
}

public class NewObject {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.legs);
    }
}
