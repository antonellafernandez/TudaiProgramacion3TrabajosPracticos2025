package TrabajosPracticos.TP4_Grafos;

public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafo = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafo.agregarArco(1, 2, 3F);

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        Float etiqueta = grafo.obtenerArco(1, 2).getEtiqueta();

        System.out.println(etiqueta); // Debería imprimir 3
    }
}
