package com.mycompany.practice;

public class Practice {

    static class Pen {
        String color;
        String type;

        public void write() {
            System.out.println("Writing something");
        }
    }

    public static void main(String[] args) {

        Pen pen1 = new Pen();
        pen1.color = "blue";
        pen1.type = "gel";

        pen1.write();

        System.out.println("Pen color: " + pen1.color);
        System.out.println("Pen type: " + pen1.type);
    }
}