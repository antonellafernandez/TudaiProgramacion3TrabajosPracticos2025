package TP3_EstructurasDeDispersion;

import java.util.Hashtable;

public class DynamicHashTable {
    private Hashtable<Integer, Integer> table;

    public DynamicHashTable(int initialCapacity, float loadFactor) {
        table = new Hashtable<>(initialCapacity, loadFactor);
    }

    public void insert(int key) {
        table.put(key, key);
    }

    public int get(int key) {
        return table.get(key);
    }

    public void printTable() {
        for (Integer key : table.keySet()) {
            System.out.println(key + ": " + table.get(key));
        }
    }
}
