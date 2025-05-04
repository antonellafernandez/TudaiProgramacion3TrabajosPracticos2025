package Parcial16JUN2023;

/* Ejercicio 2

Se posee una matriz cuadrada de tamaño N x N donde en cada celda de la matriz se aloja un número entero NO
negativo (es decir, >= 0). Dada una celda de origen y una celda de destino, se desea encontrar, de ser posible, el
camino de mayor costo entre el origen y el destino. El costo del camino será medido por la suma de los valores de
las celdas que conforman dicho camino. Los movimientos válidos, desde una celda son arriba, abajo, derecha e
izquierda, un camino no puede pasar dos veces por una misma celda, y siempre que nos movemos de una celda C1 a
una celda C2, el valor de la celda C2 debe ser mayor al valor de la celda C1. Por ejemplo, si estoy en una celda con
valor 10, no puedo ir a una celda de valor 8, pero si puedo ir a una de valor 12.

Se pide plantear un algoritmo mediante estrategia Greedy.

a) ¿Cuál sería la estrategia Greedy que seguiría?
b) Escriba un pseudo-java que lo resuelva mediante la estrategia Greedy.

import TrabajosPracticos.TP5_Backtracking.Ejercicio11.Celda;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    private int N;
    private List<Celda> S; // Camino solución

    public List<Celda> greedy(List<Celda> matriz, Celda origen, Celda destino) {
        S = new ArrayList<Celda>();

        Celda actual = origen;
        S.add(actual);

        while (!actual.equals(destino)) {
            ArrayList<Celda> adyacentes = actual.getAdyacentes();

            int i = 0;

            while (i < adyacentes.size() && !solucion(S, destino)) {
                Celda c = adyacentes.get(i);

                if (factible(S, c)) {
                    S.add(c);
                    actual = c;
                } else {
                    i++; // Probar con la siguiente adyacente
                }
            }
        }

        return S;
    }

    private boolean solucion(List<Celda> S, Celda destino) {
        if (S.get(S.size() - 1).equals(destino)) {
            return true;
        }

        return false;
    }

    private boolean factible(List<Celda> S, Celda actual) {
        if ((actual.getValor() > S.get(S.size() - 1).getValor()) && !S.contains(actual)) {
            return true;
        }

        return false;
    }
} */
