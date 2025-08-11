package Final08AGO2024;

/* Ejercicio 2

El patrón de desbloqueo de un celular es un método de autenticación que consta de una cuadrícula de 3x3
puntos. El usuario debe conectar un mínimo de 4 puntos para crear un patrón. Los
puntos se conectan trazando una línea continua, sin levantar el dedo de la pantalla. No se puede pasar más de
una vez por una conexión entre puntos, y las conexiones desde un punto se pueden hacer a los puntos contiguos.
El patrón puede iniciar desde cualquiera de los puntos de la cuadrícula y finalizar en cualquier punto.
Diseñe un algoritmo mediante la técnica Backtracking que descubra el patrón de desbloqueo del teléfono
celular, contando con el siguiente método:

public boolean validarPatron(List<Punto> patron)

Al cual se le pasa una lista de puntos en el orden en que se conectan en el patrón, y el método devuelve true si el patrón
logra desbloquear el teléfono o false en caso contrario.

public class Ejercicio2 {
    private Cuadricula cuadricula;

    public Ejercicio2() {
        this.cuadricula = new Cuadricula(3); // Cuadrícula 3x3
    }

    public boolean validarPatron(List<Punto> patron) {
        if (patron.size() >= 4) {
            List<Punto> visitados = new ArrayList<>();
            return backtrack(patron, visitados, 0);
        }

        return false;
    }

    private boolean backtrack(List<Punto> patron, List<Punto> visitados, int pos) {
        // Caso Base: recorrer el patron por completo
        if (pos == patron.size() - 1) {
            return true;
        }

        Punto actual = patron.get(pos);
        Punto siguiente = patron.get(pos + 1);

        // Intento de asignación
        visitados.add(actual);

        // Obtener adyacentes del punto actual
        List<Punto> adyacentes = cuadricula.getAdyacentes(actual);

        // Poda: Verificar que el siguiente punto es válido
        if (adyacentes.contains(siguiente) && !visitados.contains(siguiente)) {
            // Recursión
            if (backtrack(patron, visitados, pos + 1)) {
                return true;
            }
        }

        // Backtrack
        visitados.remove(visitados.size() - 1);
        return false;
    }
} */
