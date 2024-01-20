package org.example;

// https://javaconceptoftheday.com/why-128-128-returns-false-in-java/
public class Trainner {
    public static void main(String[] args) {
        int n = 0;
        while (true) {
            Integer a = n;
            Integer b = n;
            if (a != b) {
                break;
            }
            n++;
        }
        System.out.println(n);

        Integer i1 = 127;

        Integer i2 = 127;

        System.out.println(i1 == i2);

        Integer i3 = 128;

        Integer i4 = 128;

        System.out.println(i3 == i4);
    }
}
