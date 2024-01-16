package org.example;

import java.util.ArrayList;
import java.util.List;

class HashTableExec {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>(5);
        hashTable.add("Alex Manning", "7175501675");
        hashTable.add("Ulises Bauer", "2487620356");
        hashTable.add("Uriel Moralesg", "2522583799");
        hashTable.add("Beckett Nash", "2341096666");
        hashTable.add("Silas Molina", "2126583916");
        System.out.println(hashTable.get("Beckett Nash"));
    }
}

class Item<K, V> {
    public final K key;
    public final V value;

    public Item(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item [key=" + key + ", value=" + value + "]";
    }
}

public class HashTable<K, V> {
    private List<Item<K, V>>[] table;

    public HashTable(int capacity) {
        this.table = new ArrayList[capacity];
        for (int index = 0; index < capacity; index++) {
            this.table[index] = new ArrayList<>();
        }
    }

    private int hash(K value) {
        int baseHash = Math.abs(value.hashCode()) % this.table.length;
        return (baseHash) % this.table.length;
    }

    public void add(K name, V phoneNum) {
        this.table[this.hash(name)].add(new Item<K, V>(name, phoneNum));
    }

    public Item get(K name) {
        int position = this.hash(name);
        List<Item<K, V>> itemList = this.table[position];
        for (Item<K, V> item : itemList) {
            if (item.key.equals(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("HashTable [");
        for (int i = 0; i < table.length; i++) {
            result.append("pos ").append(i).append(": ").append(table[i]).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }
}

/*
 * b=3 a=2 g=17 = 22%5 = 2
 * hash("bag") => 2
 * [ 0, 0, bag, 0, 0 ]
 */