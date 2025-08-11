package Final08AGO2024;

/* Ejercicio 3

Roberto tiene un empleo nuevo en un depósito de cajas, y su primera tarea es organizar todas las cajas. Al ser su primer día,
quiere hacer un buen trabajo, y decide ubicar las cajas en columnas para ahorrar la mayor cantidad de espacio del depósito
posible. De cada caja, Roberto conoce su peso (medida en kilogramos) y su resistencia (también medida en kilogramos). Por
ejemplo, si sobre una caja que tiene una resistencia de 100 kilogramos se apilan cajas que juntas suman más de 100kg, la caja en
cuestión no podrá resistir el peso y se romperá.

Roberto quiere apilar las cajas en la menor cantidad de columnas para ahorrar espacio, pero sin que ninguna caja se rompa.

Se pide plantear un algoritmo mediante estrategia Greedy determine en cuántas columnas deberá apilar las cajas Roberto
para completar su tarea.

import PrimerRecuperatorio28JUN2025.Ejercicio2.Caja;

import java.util.ArrayList;

public class Ejercicio3 {
    private List<Columna> S; // Solución - La clase Columna tiene una List<Caja>

    public Integer greedy(List<Caja> C) {
        S = new ArrayList<>();
        // Ordenar las cajas por resistencia de mayor a menor
        // en caso de ser iguales, por peso de menor a mayor
        Collections.sort(C, new ComparadorResistenciaDesc());

        for (Caja c : C) {
            boolean colocada = false;

            // Intentar colocar en alguna columna existente
            for (Columna columna : S) {
                if (factible(columna, c)) {
                    columna.add(c);
                    colocada = true;
                    break;
                }
            }

            // Si no se pudo colocar, crear nueva columna
            if (!colocada) {
                Columna nuevaColumna = new Columna();
                nuevaColumna.add(c);
                S.add(nuevaColumna);
            }
        }

        return S.size();
    }

    private boolean factible(Columna co, Caja ca) {
        // La clase Columna va manteniendo la resistencia actual cada vez
        // que se agrega una caja, la va restando a la resistencia acumulada
        return (co.getResistencia() - ca.getPeso()) >= 0;
    }
} */
