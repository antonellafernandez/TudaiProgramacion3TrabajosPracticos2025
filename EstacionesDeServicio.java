/* Un camionero conduce desde la Ciudad de Buenos Aires hasta Ushuaia siguiendo una ruta dada y llevando un camión
que le premite, con el tanque de gasoil lleno, recorrer K kilómetros sin parar.
El camionero dispone de la información que le indica las distancias entre las estaciones de servicio que hay en su ruta
(recordar que la ruta ya viene dada).
El camionero quiere parar a cargar gasoil la menor cantidad de veces posible.
El camionero parte desde el origen con el tanque lleno, y al llegar a destino vuelve a llenar el tanque.

Supongamos entonces que tiene una lista vinculada E que contiene las estaciones de servicio en el orden en que
serán encontradas siguiendo la ruta dada. El primer nodo contendrá la estación de servicio E0 de la ciudad origen donde
llena inicialmente el taque y el último la estación de servicio de la ciudad destino donde también llenará el tanque.

Suponga que existe una función public float distancia(Estacion A, Estacion B) que dadas dos estaciones
cualquiera retorna la distancia en kilómetros entre ellas (la estación de servicio A debe aparecer antes que B en la ruta).

public class EstacionesDeServicio {
    private float K; // Kilómetros a recorrer sin parar con tanque lleno
    private List<Estacion> S; // Solución

    // Backtracking
    public List<Estacion> backtracking(List<Estacion> E) { // E es la ruta dada
        S = new LinkedList<Estacion>();

        // Agrego la primer Estacion
        S.add(E.getFirst());

        if (backtracking(E, 1)) {
            return S;
        }

        return new LinkedList<Estacion>();
    }

    private boolean backtracking(List<Estacion> E, int actual) {
        // Caso Base: Llegar a destino
        if (actual == E.size() - 1) {
            S.add(E.getLast());
            return true;
        }

        for (int i = actual; i < E.size(); i++) {
            Estacion e = E.get(i);

            if (distancia(S.getLast(), e) <= K) {
                // Intento de asignación
                S.add(e);

                // Recursión
                if (backtracking(E, i + 1)) {
                    return true;
                }

                // Backtrack
                S.removeLast();
            } else {
                break;
            }
        }

        return false;
    }

    // Greedy
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
