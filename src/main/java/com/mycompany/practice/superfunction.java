package com.mycompany.practice;

public class superfunction {

static class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

static class Dog extends Animal {
    void eat() {
        System.out.println("Dog eats meat");
    }

    void show() {
        super.eat();
    }
}


    public static void main(String[] args) {
        Dog d = new Dog();
        d.show();
    }

}