package org.example;

public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        // recursion.exec01(10);
        System.out.println(recursion.factorial(3));
        // System.out.println(recursion.factorialWitLoop(3));
    }

    private int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        // stack the calls until num is worth 1 Ex: ...3,2,1 (worth 1);
        int res = factorial(num - 1);
        // unstack the calls returning the stack item from top to bottom Ex: 1,2,3...
        return num * res;
    }

    public int factorialWitLoop(int num) {
        int total = 1;
        for (int i = 1; i <= num; i++) {
            total *= i;
        }
        return total;
    }

    private void exec01(int count) {
        if (count == 0)
            return;
        System.out.println(count);
        exec01(count - 1);
    }

}
