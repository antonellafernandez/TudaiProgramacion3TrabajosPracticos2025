package TP3_EstructurasDeDispersion;

import java.util.Hashtable;
import java.util.LinkedList;

public class HashTable {
    private int M;
    private Hashtable<Integer, LinkedList<Integer>> table;

    public HashTable() {
        this.table = new Hashtable<>();
    }

    public void insert(int key) {
        int index = hash(key);
        LinkedList<Integer> list = table.getOrDefault(index, new LinkedList<>());
        list.add(key);
        table.put(index, list);
    }

    private int hash(int key) {
        return key;
    }

    public void printTable() {
        for (int key : table.keySet()) {
            System.out.print(key + ": ");
            for (int num : table.get(key)) {
                System.out.print(num + " -> ");
            }
            System.out.println("null");
        }
    }
}
