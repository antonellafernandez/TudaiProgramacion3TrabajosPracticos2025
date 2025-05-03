package Parcial15JUN2022;

/*
public class Ejercicio2 {
    private float K; // Kilómetros a recorrer sin parar con tanque lleno
    private List<Estacion> S; // Solución

    public List<Estacion> greedy(List<Estacion> R) { // R es la ruta dada
        S = new LinkedList<Estacion>();

        int i = 0;

        while (i < R.size()) {
            Estacion x = R.get(i);

            if (factible(R, S, x)) {
                S.add(x);
            } else {
                i++; // Probar con la siguiente estación
            }
        }

        return S;
    }

    private boolean factible(List<Estacion> R, List<Estacion> S, Estacion x) {
        // Llena el tanque al inicio y al final
        if (R.indexOf(x) == 0 || R.indexOf(x) == R.size() || distancia(S.getLast(), x) >= K) {
            return true;
        }

        return false;
    }

    public float distancia(Estacion A, Estacion B) {
        return 0; // Distancia en km entre estaciones
    }
} */
