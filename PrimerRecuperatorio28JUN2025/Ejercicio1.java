package PrimerRecuperatorio28JUN2025;

/* Ejercicio 1
Dado un Árbol Binario de Búsqueda, se desea calcular la suma total de los valores almacenados en los nodos del árbol
que están dentro de un cierto rango [L, R]. Es decir, dados dos enteros L y R, hay que sumar todos los valores v
del árbol tales que L <= v <= R.

a) Implemente un algoritmo eficiente en JAVA que recorra solo las partes necesarias del árbol para calcular la
suma de los valores dentro del rango dado.

b) Justifique por qué su algoritmo evita visitar nodos innecesarios.

Recordar! Propiedad de los ABB, para cada nodo del ABB, todas las claves del subárbol izquierdo son menores que la
de la raíz, y todas las del derecho son mayores.

Entonces,
• Si el valor del nodo actual es menor que L, todos los nodos en su subárbol izquierdo serán menores aún,
por lo tanto se ignoran.
• Si el valor del nodo actual es mayor que R, todos los nodos en su subárbol derecho serán mayores aún,
por lo tanto se ignoran.

c) Exprese y justifique cuál es la complejidad temporal del algoritmo en el peor caso en la notación Big-O.

Complejidad en el peor caso O(n) siendo n la cantidad de nodos, es decir, ha de recorrerlos todos.

public class Ejercicio1 {
    private Nodo root;

    public int calcularSumaEnRango(int L, int R) {
        return calcularSumaEnRango(root, L, R);
    }

    private int calcularSumaEnRango(Nodo actual, int L, int R) {
        if (actual == null) {
            return 0;
        }

        int valor = actual.getValor();
        int suma = 0;

        // Si el valor actual es mayor que L, puede haber valores válidos en la izquierda
        if (valor > L) {
            suma += calcularSumaEnRango(actual.getLeft(), L, R);
        }

        // Si el valor está dentro del rango, se suma
        if (valor >= L && valor <= R) {
            suma += valor;
        }

        // Si el valor actual es menor que R, puede haber valores válidos en la derecha
        if (valor < R) {
            suma += calcularSumaEnRango(actual.getRight(), L, R);
        }

        return suma;
    }
}
*/