package com.company;

import java.util.Scanner;

// Parent Class
class Person {
    int age;
    String name;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Child Class
class Student extends Person {
    int marks;

    Student(String name, int age, int marks) {
        super(name, age);   // calling parent constructor
        this.marks = marks;
    }

    @Override
    void display() {
        super.display();    // display name and age
        System.out.println("Marks: " + marks);
    }
}

// Main Class
public class schoolmanagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student[] std = new Student[2];

        for (int i = 0; i < 2; i++) {

            System.out.println("Enter student " + (i + 1) + " name:");
            String name = sc.next();

            System.out.println("Enter student " + (i + 1) + " age:");
            int age = sc.nextInt();

            System.out.println("Enter student " + (i + 1) + " marks:");
            int marks = sc.nextInt();

            std[i] = new Student(name, age, marks);
        }

        System.out.println("\n--- Student Details ---");

        for (int i = 0; i < 2; i++) {
            std[i].display();
            System.out.println("--------------------");
        }

        sc.close();
    }
}