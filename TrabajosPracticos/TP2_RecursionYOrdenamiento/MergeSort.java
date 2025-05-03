package TP2_RecursionYOrdenamiento;

// Complejidad en el peor de los casos O(n.log2 n)
public class MergeSort {
    private int[] numbers;
    private int[] helper; // Requiere memoria auxiliar adicional
    private int size;

    public void sort(int[] values) {
        this.numbers = values;
        size = values.length;
        this.helper = new int[size];
        mergeSort(0, size - 1);
    }

    private void mergeSort(int low, int high) {
        // Si low es menor que high continua el ordenamiento
        // Si low no es menor que high entonces el array está ordenado
        // ya que es el caso base donde el array tiene un solo elemento.
        if (low < high) {
            // Obtener el indice del elemento que se encuentra en la mitad
            // Al ser int redondea el resultado al entero menor
            int middle = (low + high) / 2;

            // Ordenar la mitad izquierda del array – llamada recursiva
            mergeSort(low, middle);

            // Ordenar la mitad derecha del array – llamada recursiva
            mergeSort(middle + 1, high);

            // Combinar ambas mitades ordenadas
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        // Copiar ambas partes al array helper
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // Copiar de manera ordenada al array original los valores de la
        // mitad izquierda o de la derecha
        while (i <= middle && j <= high) {
            if (helper[ i ] <= helper[ j ]) {
                numbers[ k ] = helper[ i ];
                i++;
            } else {
                numbers[ k ] = helper[ j ];
                j++;
            }
            k++;
        }

        // Si quedaron elementos copiarlos al array original
        while (i <= middle) {
            numbers[ k ] = helper[ i ];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[ k ] = helper[ j ];
            k++;
            j++;
        }
    }
}
