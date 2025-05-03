package TrabajosPracticos.TP1_EstructurasDeDatos;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        /* • Ejercicio 5

        Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
        suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar ordenada. b)
        Las listas están ordenadas y la lista resultante debe mantenerse ordenada.

        • Ejercicio 6

        Escriba una función que dadas dos listas construya otra con los elementos que están en la
        primera pero no en la segunda. */


        // Ejercicio 5
        // Crear dos listas desordenadas y ordenadas
        MySimpleLinkedList<Integer> lista1Desordenada = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista2Desordenada = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista1Ordenada = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista2Ordenada = new MySimpleLinkedList<>();

        // Llenar las listas desordenadas y ordenadas
        llenarListaDesordenada(lista1Desordenada, 10);
        llenarListaDesordenada(lista2Desordenada, 10);
        llenarListaOrdenada(lista1Ordenada, 10);
        llenarListaOrdenada(lista2Ordenada, 10);

        // Mostrar las listas
        System.out.println("Lista 1 Desordenada: " + lista1Desordenada);
        System.out.println("Lista 2 Desordenada: " + lista2Desordenada);
        System.out.println("Lista 1 Ordenada: " + lista1Ordenada);
        System.out.println("Lista 2 Ordenada: " + lista2Ordenada);

        // Obtener elementos comunes de las listas desordenadas
        MySimpleLinkedList<Integer> comunesDesordenados = getElementosComunesListasDesordenadas(lista1Desordenada, lista2Desordenada);
        System.out.println("Elementos Comunes (Desordenadas): " + comunesDesordenados);

        // Obtener elementos comunes de las listas ordenadas
        MySimpleLinkedList<Integer> comunesOrdenados = getElementosComunesListasOrdenadas(lista1Ordenada, lista2Ordenada);
        System.out.println("Elementos Comunes (Ordenadas): " + comunesOrdenados);

        // Ejercicio 6
        // Obtener elementos no comunes de las listas desordenadas
        MySimpleLinkedList<Integer> noComunesDesordenados = getElementosNoComunesListasDesordenadas(lista1Desordenada, lista2Desordenada);
        System.out.println("Elementos No Comunes (Desordenadas): " + noComunesDesordenados);
    }

    // Complejidad O(n*m)
    // a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    public static MySimpleLinkedList<Integer> getElementosComunesListasDesordenadas(MySimpleLinkedList<Integer> lista1,
                                                                               MySimpleLinkedList<Integer> lista2) {

        MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<Integer>();

        Iterator<Integer> iter1 = lista1.iterator();

        while (iter1.hasNext()) {
            Integer info1 = iter1.next();
            Iterator<Integer> iter2 = lista2.iterator();

            while (iter2.hasNext()) {
                Integer info2 = iter2.next();
                if (info1.equals(info2)) {
                    resultado.insertOrdered(info1);
                    break;
                }
            }
        }

        return resultado;
    }

    // Recorrer ambas listas en paralelo, logrando una complejidad O(n + m)
    // b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
    public static MySimpleLinkedList<Integer> getElementosComunesListasOrdenadas(MySimpleLinkedList<Integer> lista1,
                                                                                    MySimpleLinkedList<Integer> lista2) {

        MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<Integer>();

        Iterator<Integer> iter1 = lista1.iterator();
        Iterator<Integer> iter2 = lista2.iterator();

        if (!iter1.hasNext() || !iter2.hasNext()) {
            return resultado; // Si alguna lista está vacía, el resultado también lo estará.
        }

        Integer info1 = iter1.next();
        Integer info2 = iter2.next();

        while (info1 != null && info2 != null) {
            if (info1.equals(info2)) {
                resultado.insertOrdered(info1); // Insertamos el elemento en orden
                info1 = iter1.hasNext() ? iter1.next() : null;
                info2 = iter2.hasNext() ? iter2.next() : null;
            } else if (info1 < info2) {
                info1 = iter1.hasNext() ? iter1.next() : null;
            } else {
                info2 = iter2.hasNext() ? iter2.next() : null;
            }
        }

        return resultado;
    }

    // Complejidad O(n²) siendo n la cantidad de elementos de cada lista,
    // siempre y cuando ambas tengan la misma cantidad de elementos
    // Obtener elementos que están en la primera lista pero no en la segunda.
    public static MySimpleLinkedList<Integer> getElementosNoComunesListasDesordenadas(MySimpleLinkedList<Integer> lista1,
                                                                                    MySimpleLinkedList<Integer> lista2) {

        MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<Integer>();

        Iterator<Integer> iter1 = lista1.iterator();

        while (iter1.hasNext()) {
            Integer info1 = iter1.next();
            Iterator<Integer> iter2 = lista2.iterator();
            boolean noComun = true;

            while (iter2.hasNext()) {
                Integer info2 = iter2.next();

                if (info1.equals(info2)) {
                    noComun = false;
                    break;
                }
            }

            // Agregar si es elemento no comun y ya se recorrió toda la lista 2
            if (noComun) {
                resultado.insertOrdered(info1);
            }
        }

        return resultado;
    }

    // Método para llenar lista desordenada
    public static void llenarListaDesordenada(MySimpleLinkedList<Integer> list, int size) {
        Integer info;

        for (int i = 0; i < size; i++) {
            info = (int) Math.floor(Math.random() * 20);
            list.insertFront(info);
        }
    }

    // Método para llenar lista ordenada
    public static void llenarListaOrdenada(MySimpleLinkedList<Integer> list, int size) {
        Integer info;

        for (int i = 0; i < size; i++) {
            info = (int) Math.floor(Math.random() * 20);
            list.insertOrdered(info);
        }
    }
}
