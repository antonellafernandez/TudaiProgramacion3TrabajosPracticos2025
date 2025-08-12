package Final27FEB2025;

/* Ejercicio 3

En un instituto musical se desea utilizar IA para generar la mejor melodía posible, producto de esto se dispone de un
conjunto de X notas musicales distintas que pueden ser combinadas en una secuencia de notas para generar una melodía.
Gracias a distintos estudios se sabe que la mejor melodía posible debe contener H notas musicales exactamente, no
necesariamente distintas, sólo se debe asegurar de no utilizar 2 veces seguidas la misma nota. Asumiendo una función
valoracion(secuenciaDeNotas) que nos retorna que tan buena es la melodía a partir de las notas musicales que
la componen, construir un algoritmo de Backtracking que encuentra la mejor melodía posible.

public class Ejercicio3 {
    private List<Nota> mejorMelodia;
    private Integer mejorValoracion;

    public Ejercicio3() {
        this.mejorMelodia = new LinkedList<>();
        this.mejorValoracion = Integer.MIN_VALUE;
    }

    public List<Nota> generarMelodia(List<Nota> X, int H) {
        generarMelodia(X, H, new LinkedList<>());
        return mejorMelodia;
    }

    private void generarMelodia(List<Nota> X, int H, List<Nota> melodiaActual) {
        // Condición Base: Obtener una melodía con H notas
        if (melodiaActual.size() == H) {
            int valoracionActual = valoracion(melodiaActual);
            if (valoracionActual > mejorValoracion) {
                mejorMelodia.clear();
                mejorMelodia.addAll(melodiaActual);
                mejorValoracion = valoracionActual;
            }
        }

        for (Nota n : X) {
            // Poda: No utilizar dos veces seguidas la misma nota
            if (melodiaActual.isEmpty() || !melodiaActual.getLast().equals(n)) { // Redefinir el equals en Nota
                // Intento de asignación
                melodiaActual.add(n);

                // Recursión
                generarMelodia(X, H, melodiaActual);

                // Backtrack
                melodiaActual.removeLast();
            }
        }
    }
} */
