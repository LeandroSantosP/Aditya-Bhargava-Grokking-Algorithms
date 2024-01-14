package org.example;

import java.util.ArrayList;
import java.util.List;

class ExecRecursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        // recursion.exec01(10);
        // System.out.println(recursion.factorial(3));
        ArrayList<Integer> s = new ArrayList<>();
        s.addAll(List.of(5, 10, 20, 21));
        System.out.println(recursion.binarySearchRec(s, 10, 0, s.size() - 1));
//        System.out.println(recursion.<Integer>maxNum(s, 0, s.get(0)));
//        System.out.println(recursion.count(s));
//        System.out.println(recursion.sumR(s));
//        System.out.println(recursion.DeC(s, 0, s.size() - 1));
        // System.out.println(recursion.factorialWitLoop(3));
    }
}

public class Recursion {

    public int binarySearchRec(ArrayList<Integer> list, int target, int start, int end) {
        if (start <= end) {
            int middle = start + (end - start) / 2;
            if (list.get(middle) == target) {
                return target;
            } else if (list.get(middle) > target) {
                return binarySearchRec(list, target, start, middle - 1);
            } else if (list.get(middle) < target) {
                return binarySearchRec(list, target, middle + 1, end);
            }
        }
        return -1;
    }

    public <T extends Comparable<T>> T maxNum(ArrayList<T> list, int index, T greaterNum) {
        if (index == list.size()) {
            return greaterNum;
        }
        T currentNum = list.get(index);
        if (currentNum.compareTo(greaterNum) > 0) {
            greaterNum = currentNum;
        }
        T result = maxNum(list, index + 1, greaterNum);
        return result;
    }

    public int DeC(ArrayList<Integer> list, int start, int end) {
        if (start == end) {
            return list.get(start);
        }
        int middle = (start + end) / 2;
        int sumLelt = this.DeC(list, start, middle);
        int sumRight = this.DeC(list, middle + 1, end);
        return sumLelt + sumRight;
    }

    public int sumR(ArrayList<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        var copy = new ArrayList<>(list);

        var s = copy.remove(list.size() - 1);
        /* item sendo armazenados na stack (Enpilhando) bottom to top */
        /* resultado da recursao */
        var w = this.sumR(copy);
        /* Item sendo retornados da stack (Desenpilhando) top to bottom */
        return s + w;
    }

    public int count(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        ArrayList<Integer> copy = new ArrayList<>(list);
        copy.remove(copy.size() - 1);
        int res = this.count(copy);
        return res + 1;
    }

    public int factorial(int num) {
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
