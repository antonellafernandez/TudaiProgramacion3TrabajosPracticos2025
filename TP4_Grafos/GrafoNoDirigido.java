package TP4_Grafos;

/* Ejercicio 1
Implemente en JAVA las clases GrafoDirigido y GrafoNoDirigido. */

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        super.agregarArco(verticeId1, verticeId2, etiqueta);
        super.agregarArco(verticeId2, verticeId1, etiqueta);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        super.borrarArco(verticeId1, verticeId2);
        super.borrarArco(verticeId2, verticeId1);
    }

    @Override
    public int cantidadArcos() {
        return super.cantidadArcos() / 2;
    }

    /* Ejercicio 7
    Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
    todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos Aires
    a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al tránsito. */

}
