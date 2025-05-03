package Parcial15JUN2022;

/*
public class Ejercicio3 {
    private float K; // Kilómetros a recorrer sin parar con tanque lleno
    private List<Estacion> solucionActual;
    private List<Estacion> mejorSolucion;

    public List<Estacion> backtracking(List<Estacion> R) { // R es la ruta dada
        mejorSolucion = new ArrayList<Estacion>();
        solucionActual = new ArrayList<Estacion>();

        backtracking(R, 0);

        return mejorSolucion;
    }

    private void backtracking(List<Estacion> R, int indice) {
        if (indice == (R.size() - 1)) { // Caso Base: Si actual es la última estación de la ruta
            if (mejorSolucion.isEmpty() || solucionActual.size() < mejorSolucion) {
                mejorSolucion.clear();
                mejorSolucion.addAll(solucionActual);
            }

            return;
        }

        for (int i = 1; i < R.size() - 1; i++) {
            Estacion actual = R.get(indice);

            // Intento de asignación
            solucionActual.add(actual);

            // Recursión
            if (distancia(actual, R.get(indice + 1)) < K) { // Poda
                backtracking(R, indice + 1);
            }

            // Backtrack
            solucionActual.remove(solucionActual.size() - 1);
        }
    }

    public float distancia(Estacion A, Estacion B) {
        return 0; // Distancia en km entre estaciones
    }
} */
