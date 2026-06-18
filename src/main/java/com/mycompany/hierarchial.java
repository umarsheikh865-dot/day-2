package com.mycompany;

public class hierarchial {

    static class Animal {
        void eat() {
            System.out.println("Animal is eating");
        }
    }

    static class Dog extends Animal {
        void bark() {
            System.out.println("Dog is barking");
        }
    }
     static class Cat extends Animal {
        void meow() {
            System.out.println("cat is meowing");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
        System.out.println();
        Cat c= new Cat();
        c.eat();
        c.meow();
    }
}