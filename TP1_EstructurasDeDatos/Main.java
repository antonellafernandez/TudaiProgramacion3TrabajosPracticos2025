package TP1_EstructurasDeDatos;

public class Main {

    public static void main(String[] args) {
        /* • Ejercicio 5

        Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
        suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar ordenada. b)
        Las listas están ordenadas y la lista resultante debe mantenerse ordenada. */

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
        MySimpleLinkedList<Integer> comunesDesordenados = obtenerElementosComunesDesordenados(lista1Desordenada, lista2Desordenada);
        System.out.println("Elementos Comunes (Desordenadas): " + comunesDesordenados);

        // Obtener elementos comunes de las listas ordenadas
        MySimpleLinkedList<Integer> comunesOrdenados = obtenerElementosComunesOrdenados(lista1Ordenada, lista2Ordenada);
        System.out.println("Elementos Comunes (Ordenadas): " + comunesOrdenados);
    }

    // a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    public static MySimpleLinkedList<Integer> obtenerElementosComunesDesordenados(MySimpleLinkedList<Integer> lista1,
                                                                                  MySimpleLinkedList<Integer> lista2) {

        MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<>();

        Node<Integer> node1 = lista1.get(0);
        while (node1 != null) {
            Node<Integer> node2 = lista2.first;
            while (node2 != null) {
                if (node1.getInfo().equals(node2.getInfo())) {
                    resultado.insertOrdered(node1.getInfo());  // Insertar el común en orden
                    break;  // Salimos del segundo ciclo cuando encontramos el primer común
                }
                node2 = node2.getNext();
            }
            node1 = node1.getNext();
        }

        return resultado;
    }

    // b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
    public static MySimpleLinkedList<Integer> obtenerElementosComunesOrdenados(MySimpleLinkedList<Integer> lista1,
                                                                               MySimpleLinkedList<Integer> lista2) {

        MySimpleLinkedList<Integer> resultado = new MySimpleLinkedList<>();
        Node<Integer> node1 = lista1.first;
        Node<Integer> node2 = lista2.first;

        // Usamos un enfoque de dos punteros para recorrer ambas listas
        while (node1 != null && node2 != null) {
            int valor1 = node1.getInfo();
            int valor2 = node2.getInfo();

            if (valor1 == valor2) {
                resultado.insertOrdered(valor1);  // Insertar el común en orden
                node1 = node1.getNext();
                node2 = node2.getNext();
            } else if (valor1 < valor2) {
                node1 = node1.getNext();
            } else {
                node2 = node2.getNext();
            }
        }

        return resultado;
    }

    // Método para llenar lista desordenada
    public static void llenarListaDesordenada(MySimpleLinkedList<Integer> list, int size) {
        Integer info;

        for (int i = 0; i < size; i++) {
            info = (int) Math.floor(Math.random() * 100);
            list.insertFront(info);
        }
    }

    // Método para llenar lista ordenada
    public static void llenarListaOrdenada(MySimpleLinkedList<Integer> list, int size) {
        Integer info;

        for (int i = 0; i < size; i++) {
            info = (int) Math.floor(Math.random() * 100);
            list.insertOrdered(info);
        }
    }
}
