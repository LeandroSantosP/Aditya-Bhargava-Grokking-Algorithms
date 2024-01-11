package org.example;
import java.util.ArrayList;

public class SelectSort<T extends Comparable<T>> {
    public SelectSort() {
    }

    public ArrayList<T> findSmaller(ArrayList<T> arr) {
        ArrayList<T> sorted = new ArrayList<>(arr.size());
        while (!arr.isEmpty()) {
            int smallerIndex = 0;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i).compareTo(arr.get(smallerIndex)) < 0) {
                    smallerIndex = i;
                }
            }
            sorted.add(arr.get(smallerIndex));
            arr.remove(smallerIndex);
        }
        return sorted;
    }
}
