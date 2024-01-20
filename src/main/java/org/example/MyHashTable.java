package org.example;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

class HashTableExec {
    public static void main(String[] args) {
        /* Java Implemataion */
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Alex", "7175501675");
        hashtable.put("Ulises Bauer", "2487620356");
        System.out.println(hashtable.get("Alex"));
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
        }
        /* My Simple Implemataion */
        MyHashTable<String, String> myhashTable = new MyHashTable<>(5);
        myhashTable.add("Alex Manning", "7175501675");
        myhashTable.add("Ulises Bauer", "2487620356");
        myhashTable.add("Uriel Moralesg", "2522583799");
        myhashTable.add("Beckett Nash", "2341096666");
        myhashTable.add("Silas Molina", "2126583916");
        System.out.println(myhashTable.get("Beckett Nash") == "2341096666");
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

public class MyHashTable<K extends String, V> {
    private List<Item<K, V>>[] table;

    public MyHashTable(int capacity) {
        this.table = new ArrayList[capacity];
        for (int index = 0; index < capacity; index++) {
            this.table[index] = new ArrayList<>();
        }
    }

    private int hash(K value) {
        int baseHash = Math.abs(value.hashCode()) % this.table.length;
        return (baseHash) % this.table.length;
    }

    private int hash2(K value) {
        int hash = 5381;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash << 5) + hash + value.charAt(i);
        }
        hash = Math.abs(hash);
        return hash % this.table.length;
    }

    public void add(K name, V phoneNum) {
        this.table[this.hash2(name)].add(new Item<K, V>(name, phoneNum));
    }

    public V get(K name) {
        int position = this.hash2(name);
        List<Item<K, V>> itemList = this.table[position];
        for (Item<K, V> item : itemList) {
            if (item.key.equals(name)) {
                return item.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("HashTable {");
        for (int i = 0; i < table.length; i++) {
            result.append("pos ").append(i).append(": ").append(table[i]).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }
}

/*
 * b=3 a=2 g=17 = 22%5 = 2
 * hash("bag") => 2
 * [ 0, 0, bag, 0, 0 ]
 */