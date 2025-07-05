package PrimerRecuperatorio28JUN2025.Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Ejercicio 2
Debido a un mal funcionamiento de una de las máquinas que generan piezas, la empresa se encuentra con la
situación de tener que enviar a un depósito la cantidad de piezas sobrantes. Los empleados han ubicado dichas piezas
en un número X de cajas, cada una con su propio peso.

Se sabe que el transporte contratado puede llevar un peso total P en cada viaje. Se desea encontrar el orden en que
deben ser cargadas las cajas en el transporte de manera de minimizar el total de viajes a realizar.

a) Explique claramente cuál sería la estrategia greedy que seguiría.
b) Escriba un algoritmo en JAVA que lo resuelva mediante la estrategia greedy.
c) Diga y justifique cuál será la complejidad computacional del algoritmo en notación Big-O. */

public class Ejercicio2 {
    private int P; // Capacidad del transporte
    private List<Viaje> S; // Solución

    public List<Viaje> greedy(List<Caja> C) {
        // Ordenar las cajas por su peso de mayor a menor - Longest Processing Time First
        Collections.sort(C, new ComparadorPesoDesc());
        S = new ArrayList<>();

        for (Caja caja : C) {
            boolean ubicada = false;

            for (Viaje viaje : S) {
                if (factible(caja, viaje)) {
                    viaje.addCaja(caja);
                    ubicada = true;
                    break;
                }
            }

            if (!ubicada) {
                Viaje nuevoViaje = new Viaje(0);
                nuevoViaje.addCaja(caja);
                S.add(nuevoViaje);
            }
        }

        return S;
    }

    private boolean factible(Caja caja, Viaje viaje) {
        return (viaje.getPeso() + caja.getPeso()) < P;
    }
}
