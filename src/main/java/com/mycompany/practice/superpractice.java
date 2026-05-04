
package com.mycompany.practice;

public class superpractice {
    class Animal{
        void eat(){
                System.out.println("Animal is Eating");
    }
    }
    class Dog extends Animal{
        void eat(){
            System.out.println("Dog is Eating");
        }
        void show(){
            super.eat();
        }
    }
    
}
