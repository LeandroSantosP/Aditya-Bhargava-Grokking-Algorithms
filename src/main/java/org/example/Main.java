package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SelectSort<Integer> selectSort = new SelectSort();
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> values = Arrays.asList(231, 3, 23, 23, 52, 1);
        list.addAll(values);
        System.out.println(selectSort.findSmaller(list));
        System.out.println(list);
    }
}
