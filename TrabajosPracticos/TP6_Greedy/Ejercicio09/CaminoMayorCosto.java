package TP6_Greedy.Ejercicio09;

/* Ejercicio 9

Se posee una matriz cuadrada de tamaño N x N donde en cada celda de la matriz se aloja un
número entero NO negativo (es decir, >= 0). Dada una celda de origen y una celda de destino, se
desea encontrar, de ser posible, el camino de mayor costo entre el origen y el destino. El costo del
camino será medido por la suma de los valores de las celdas que conforman dicho camino. Los
movimientos válidos desde una celda son arriba, abajo, derecha e izquierda, un camino no puede
pasar dos veces por una misma celda, y siempre que nos movemos de una celda C1 a una celda C2,
el valor de la celda C2 debe ser mayor al valor de la celda C1. Por ejemplo, si estoy en una celda
con valor 10, no puedo ir a una celda de valor 8, pero si puedo ir a una de valor 12.

Se pide plantear un algoritmo mediante estrategia Greedy

a) ¿Cuál sería la estrategia Greedy que seguiría?.

b) Escriba un pseudo-java que lo resuelva mediante la estrategia Greedy. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
public class CaminoMayorCosto {
    private int N = 3;
    private List<Integer> S; // Solución

    public List<Integer> greedy(int[][] matriz, int[] origen, int[] destino) {
        Collections.sort(C, Collections.reverseOrder()); // Ordenar de mayor a menor
        S = new ArrayList<>();

        int i = 0;

        while (i < C.size() && !solucion(S)) {
            int x = C.get(i);

            if (factible(S, x)) {
                S.add(x);
            } else {
                i++; // Probar con el siguiente billete
            }
        }

        if (solucion(S)) {
            return S;
        }

        return null;
    }

    private boolean solucion(List<Integer> S) {

    }

    private boolean factible(List<Integer> S, int x) {

    }
} */
