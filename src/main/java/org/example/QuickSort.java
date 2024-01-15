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
    ArrayList<Integer> concatRes = new ArrayList<>(exec(less));
    concatRes.add(pivot);
    concatRes.addAll(exec(greater));
    return concatRes;
  }
}

/*
 * Gpt - Abstraction
 * 
 * Caso Base:
 * 
 * Todo algoritmo recursivo deve ter um caso base que define quando parar a
 * recursão. Isso evita um loop infinito.
 * Divisão do Problema:
 * 
 * O problema é dividido em instâncias menores e mais simples do mesmo problema.
 * Cada chamada recursiva trabalha com uma instância menor.
 * Chamada Recursiva:
 * 
 * A função se chama a si mesma, mas com argumentos diferentes. Isso permite
 * lidar com instâncias menores do problema.
 * Combinação dos Resultados:
 * 
 * À medida que as chamadas recursivas retornam, os resultados são combinados de
 * maneira que contribuam para resolver o problema original.
 * Garantia de Convergência:
 * 
 * Cada chamada recursiva deve estar mais próxima do caso base, garantindo que o
 * algoritmo eventualmente atinja o caso base e termine.
 * 
 * 
 * Então, ao trabalhar com recursão, é essencial garantir que cada chamada
 * recursiva trate um caso menor do problema e que haja uma lógica para combinar
 * os resultados de maneira que leve à solução do problema original. O caso base
 * é crucial para evitar a recursão infinita.
 */