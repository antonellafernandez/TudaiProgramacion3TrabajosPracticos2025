package Final27FEB2025;

/* Ejercicio 4

Supongamos tener M llaves distintas, donde cada una abre una o más cerraduras. Y se tienen N cerraduras distintas.

Se tiene además un array L de tamaño M, donde se indica para cada llave cuántas cerraduras abre de las N
cerraduras totales.

Se tiene también un método: public boolean abre(int k, int c) que responde true si la llave k abre la cerradura c, sino false.

Se busca resolver el problema de encontrar un conjunto mínimo de llaves con las que pueda abrir las N
cerraduras.

Se pide diseñar un algoritmo que resuelva el problema mediante una estrategia Greedy.

import java.util.ArrayList;

public class Ejercicio4 {
    private List<Cerradura> N; // La clase Cerradura tiene un boolean abierto iniciado en false
    private List<Llave> S; // Solución

    public Ejercicio4(List<Cerradura> N) {
        this.N = N;
        this.S = new ArrayList<>();
    }

    // La clase Llave tiene una List<Cerradura> L indicando las cerraduras que abre
    public List<Llave> greedy(List<Llave> M) {
        // Ordenar las llaves por cantidad de cerraduras que abren desc
        Collections.sort(M, new ComparadorCantidadCerradurasDesc());

        // Copiar el conjunto de llaves
        List<Llave> aux = new ArrayList<>(M);

        for (Cerradura c : N) {
            // Primero ver si se puede abrir con alguna llave de la solución
            for (Llave l : S) {
                if (!c.esAbierta() && abre(l, c)) {
                    c.abrir();
                }
            }

            // Si sigue cerrada, recorrer aux
            if (!c.esAbierta()) {
                for (Llave l: aux) {
                    if (abre(l, c)) {
                        S.add(l);
                        aux.remove(l);

                        // Abrir todas las cerraduras que esta llave abre
                        for (Cerradura ce : N) {
                            if (!ce.esAbierta() && abre(l, ce)) {
                                ce.abrir();
                            }
                        }
                    }
                }
            }
        }

        return S;
    }

    public boolean abre(Llave k, Cerradura c) {
        for (Cerradura ce : k.getCerraduras()) {
            if (ce.equals(c)) { // Redefinir el equals en Cerradura
                return true;
            }
        }

        return false;
    }
} */
