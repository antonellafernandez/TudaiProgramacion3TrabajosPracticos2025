package TP5_Backtracking.Ejercicio02HechoPorProfe;

/* Ejercicio 2

Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
booleanos, uno para cada dirección a la que se permite ir desde allí. */

import java.util.ArrayList;

public class Laberinto {
    private Casillero destino;
    private Camino mejorCamino;

    public Camino backLaberinto(Casillero origen) {
        Camino camino = new Camino();

        camino.agregarAlCamino(origen);
        camino.marcarVisitado(origen);
        camino.incrementar(origen.getValor()); // Sumar el valor del casillero de origen al camino

        backLaberinto(origen, camino); // Llamado recursivo

        return mejorCamino;
    }

    private void backLaberinto(Casillero actual, Camino caminoActual) {
        if (actual.equals(destino)) { // Si se llegó al destino (condición de corte)
            if (mejorCamino == null || mejorCamino.getValor() > caminoActual.getValor()) {
                mejorCamino = caminoActual; // Actualizar mejorCamino
            }
        } else {
            ArrayList<Casillero> vecinos = actual.getVecinos(); // Obtener los casilleros a los cuales me puedo mover

            for (Casillero vecino: vecinos) {
                // Si el vecino no ha sido visitado, se lo explora
                if (!caminoActual.estaVisitado(vecino)) {
                    // Aplicar / Hacer cambios / Agregar solucion
                    caminoActual.agregarAlCamino(vecino);
                    caminoActual.marcarVisitado(vecino);
                    caminoActual.incrementar(vecino.getValor());

                    // Poda: si el valor del camino actual es menor o igual que el mejor camino, seguir explorando
                    if (mejorCamino == null || caminoActual.getValor() <= mejorCamino.getValor()) {
                        backLaberinto(vecino, caminoActual); // Llamada recursiva para explorar el vecino
                    }

                    // Deshacer
                    caminoActual.quitarUltimo();
                    caminoActual.quitarVisitado(vecino);
                    caminoActual.decrementar(vecino.getValor());
                }
            }
        }
    }
}
