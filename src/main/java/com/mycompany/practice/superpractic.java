
package com.mycompany.practice;


public class superpractic {
    static class Vehicle{
        void start(){
            System.out.println("Vehicle start");
        }
    }
    static class Car extends Vehicle{
        void start(){
            System.out.println("Car start");
        }
        void show(){
            super.start();
        }
    }
    public static void main(String[]args){
        Car c= new Car();
        c.show();
    }
}
