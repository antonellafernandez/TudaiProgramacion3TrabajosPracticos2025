package TrabajosPracticos.TP6_Greedy.Ejercicio04;

import java.util.Iterator;

public interface Grafo<T> {
    // Verifica si existe un arco entre dos vertices
    public boolean existeArco(int verticeId1, int verticeId2);

    // Obtener el arco que conecta el verticeId1 con el verticeId2
    public Arco<T> obtenerArco(int verticeId1, int verticeId2);

    // Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo
    public Iterator<Integer> obtenerVertices();

    // Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId
    public Iterator<Integer> obtenerAdyacentes(int verticeId);
}
