package TP5_Backtracking.Ejercicio11;

import java.util.ArrayList;

/* Ejercicio 11
El robot de limpieza necesita volver desde su posición actual hasta su base de carga. Dado que al
robot le queda poca batería, desea encontrar el camino más corto. El robot dispone de un mapa de
la casa representado como una matriz, donde cada celda es una posición de la casa. La matriz
posee un 0 si la celda está vacía, o un 1 si la celda presenta algún obstáculo (por ejemplo, un
mueble). Se desea encontrar entonces el camino más corto considerando que:

- Desde una celda solo te puedes mover a las celdas contiguas (izquierda, derecha, arriba y
abajo)
- El robot sólo puede caminar por celdas libres (no por celdas con obstáculos)

¿Hay alguna poda que se pueda aplicar al algoritmo? */
/*
public class RobotDeLimpieza {
    private Camino caminoMasCorto;

    public Camino robotDeLimpieza(Mapa mapa, Celda base){
        Camino camino = new Camino;
        ArrayList<Celda> celdas = mapa.obtenerCeldas();
        robotDeLimpieza(mapa, base, camino, celdas.get(0), celdas);
    }

    private void robotDeLimpieza(Mapa mapa, Celda base, Camino camino, Celda actual, ArrayList<Celda> celdas){
        if (actual == base) {
            if ((camino.size() < caminoMasCorto) || (caminoMascorto.size() == 0)) {
                caminoMasCorto.clear();
                caminoMasCorto.addAll(camino);
            }
        } else {
            for (Celda celda : mapa.obtenerVecinos(actual)){
                if (!visitados.get(celda)) {
                    if (celda.estaVacia()) {
                        visitados.put(celda,true);
                        camino.add(celda);
                        robotDeLimpieza(mapa,base,camino,celda,celdas);
                        visitados.put(celda,false);
                        camino.remove(celda);
                    }
                }
            }
        }
    }
}*/
