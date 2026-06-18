package com.mycompany.practice;

import java.util.Scanner;

public class inheritancepractice {

    // Parent Class
    static class Student {
        String name;
        int marks;

        // Constructor
        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    // Child Class
    static class Result extends Student {

        // Constructor
        Result(String name, int marks) {
            super(name, marks);   // calling parent constructor
        }

        // Method to find highest marks
        public static void findHighest(Result[] students) {

            int highest = students[0].marks;
            String topper = students[0].name;

            for (int i = 1; i < students.length; i++) {
                if (students[i].marks > highest) {
                    highest = students[i].marks;
                    topper = students[i].name;
                }
            }

            System.out.println("\nHighest Marks: " + highest);
            System.out.println("Topper Name: " + topper);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Result[] students = new Result[5];

        // Input 5 students
        for (int i = 0; i < 5; i++) {

            System.out.println("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.println("Enter marks of student " + (i + 1) + ": ");
            int marks = sc.nextInt();
            sc.nextLine();  // clear buffer

            students[i] = new Result(name, marks); // constructor called
        }

        // Find highest marks
        Result.findHighest(students);

        sc.close();
    }
}