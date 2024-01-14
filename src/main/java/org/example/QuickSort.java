package org.example;

import java.util.ArrayList;
import java.util.List;

class ExecQuickSort {
  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    ArrayList<Integer> input = new ArrayList<>();
    input.addAll(List.of(10, 5, 1, 3));
    System.out.println(quickSort.exec(input));
  }
}

public class QuickSort {
  public ArrayList<Integer> exec(ArrayList<Integer> list) {
    if (list.size() < 2) {
      return list;
    }
    int pivot = list.get(0);
    ArrayList<Integer> less = new ArrayList<>();
    ArrayList<Integer> greater = new ArrayList<>();
    for (int index = 1; index < list.size(); index++) {
      if (list.get(index) <= pivot) {
        less.add(list.get(index));
      } else {
        greater.add(list.get(index));
      }
    }
    ArrayList<Integer> concatRes = new ArrayList<>();
    concatRes.addAll(exec(less));
    concatRes.add(pivot);
    concatRes.addAll(exec(greater));
    return concatRes;
  }
}
