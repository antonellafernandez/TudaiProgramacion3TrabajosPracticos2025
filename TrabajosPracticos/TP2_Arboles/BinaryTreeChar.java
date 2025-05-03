package TP2_Arboles;

/* Ejercicio 5
Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del
árbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
que posea exactamente N vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con
una entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N = 2, debería
retornar [“MANA”, “MANO”, “MISA”]. */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeChar {
    private TreeNodeChar root;

    public BinaryTreeChar(TreeNodeChar rootNode) {
        this.root = rootNode;
    }

    public BinaryTreeChar() {
        this.root = null;
    }

    public void add(Character value) {
        if (this.root == null) {
            this.root = new TreeNodeChar(value);
        } else {
            this.add(this.root, value);
        }
    }

    private void add(TreeNodeChar actual, Character value) {
        if (actual.getLeft() == null) {
            actual.setLeft(new TreeNodeChar(value));
        } else if (actual.getRight() == null) {
            actual.setRight(new TreeNodeChar(value));
        }
    }

    public List<String> searchWordsWithNVowels(int N) {
        List<String> result = new ArrayList<>();

        if (this.root != null) {
            searchWordsWithNVowels(this.root, "", result, N);
        }

        return result;
    }

    private void searchWordsWithNVowels(TreeNodeChar node, String word, List<String> result, int N) {
        if (node != null) {
            String newWord = word + node.getValue();

            if (node.getLeft() == null && node.getRight() == null) {
                if (countVowels(newWord) == N) {
                    result.add(newWord);
                }
            } else {
                searchWordsWithNVowels(node.getLeft(), newWord, result, N);
                searchWordsWithNVowels(node.getRight(), newWord, result, N);
            }
        }
    }

    private int countVowels(String word) {
        int count = 0;

        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }

        return count;
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
