import java.util.Scanner;

public class practicee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}

pf task 2

public class SumEven {
    public static void main(String[] args) {

        int sum = 0;

        for (int i = 2; i <= 50; i += 2) {
            sum = sum + i;
        }

        System.out.println("Sum of even numbers = " + sum);
    }
}



mysql task

CREATE DATABASE student;

USE student; 

CREATE TABLE STUDENT(
id INT PRIMARY KEY,
name VARCHAR(50),
age INT
);


INSERT into STUDENT VALUES(1,'Abdullah',24);
INSERT into STUDENT VALUES(2,'Umar',22);
INSERT into STUDENT VALUES(3,'Saad',20);
INSERT into STUDENT VALUES(4,'Tayyab',18);



select * from student
where age>20;
