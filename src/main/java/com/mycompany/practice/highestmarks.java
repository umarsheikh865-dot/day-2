package com.mycompany.practice;

import java.util.Scanner;

public class highestmarks {

    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    static class Result extends Student {

        Result(String name, int marks) {
            super(name, marks);
        }

        public static void findHighest(Result[] students) {

            int highest = students[0].marks;
            String topper = students[0].name;

            for (int i = 1; i < students.length; i++) {

                if (students[i].marks > highest) {
                    highest = students[i].marks;
                    topper = students[i].name;
                }
            }

            System.out.println("Highest Marks: " + highest);
            System.out.println("Topper Name: " + topper);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Result[] students = new Result[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.println("Enter marks of student " + (i + 1) + ": ");
            int marks = sc.nextInt();
            sc.nextLine();

            students[i] = new Result(name, marks);
        }

        Result.findHighest(students);

        sc.close();
    }
}