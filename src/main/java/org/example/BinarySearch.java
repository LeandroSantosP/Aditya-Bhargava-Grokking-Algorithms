package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        ArrayList<Integer> s = new ArrayList<>();
        s.addAll(List.of(5, 10, 20, 21));
        System.out.println(binarySearch.exec(s, 21));
    }

    public int exec(ArrayList<T> list, T target) {
        int start = 0;
        int end = list.size() - 1;
        do {
            int middle = start + (end - start) / 2;
            int result = list.get(middle).compareTo(target);
            if (result == 0) {
                return middle;
            } else if (result > 0) {
                end = middle - 1;
            }
            start = middle + 1;
        } while (start <= end);
        return -1;
    }
}
