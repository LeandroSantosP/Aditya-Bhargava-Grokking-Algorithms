package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectSort<T extends Comparable<T>> {
    public static void main(String[] args) {
        SelectSort<Integer> selectSort = new SelectSort();
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> values = Arrays.asList(231, 3, 23, 23, 52, 1);
        list.addAll(values);
        System.out.println(selectSort.exec(list));
        System.out.println(list);
    }
    public SelectSort() {
    }

    public ArrayList<T> exec(ArrayList<T> arr) {
        ArrayList<T> sorted = new ArrayList<>(arr.size());
        while (!arr.isEmpty()) {
            int smallerIndex = 0;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i).compareTo(arr.get(smallerIndex)) < 0) {
                    smallerIndex = i;
                }
            }
            sorted.add(arr.remove(smallerIndex));
        }
        return sorted;
    }
}
