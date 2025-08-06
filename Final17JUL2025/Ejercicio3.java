package Final17JUL2025;

/* Dado un juego de dominó compuesto de 28 fichas se desea encontrar una secuencia circular de fichas
que utilice la totalidad de las fichas y respete las restricciones de ubicacion de 2 fichas consecutivas
que coincidan en el número.

public class Ejercicio3 {
    private List<Ficha> solucion;

    public List<Ficha> encontrarSecuenciaCircular(List<Ficha> fichas) {
        solucion = new ArrayList<Ficha>();

        if (encontrarSecuenciaCircular(fichas, 0)) {
            return solucion;
        }

        return new ArrayList<Ficha>();
    }

    private boolean encontrarSecuenciaCircular(List<Ficha> fichas, int pos) {
        if (pos == fichas.size() - 1) {
            return esFichaValida(solucion.get(solucion.size() - 1), solucion.get(0));
        }

        for (int i = pos; i < fichas.size(); i++) {
            Ficha actual = fichas.get(i);

            // Poda
            if (pos == 0 || esFichaValida(solucion.get(i - 1), actual)) {
                // Intento de asignación
                solucion.add(actual);

                // Recursión
                if (encontrarSecuenciaCircular(fichas, i + 1)) {
                    return true;
                }

                // Backtrack
                solucion.remove(solucion.size() - 1);
            }

            // Flip
            fichas.get(i).flip();

            // Poda
            if (pos == 0 || esFichaValida(solucion.get(i - 1), actual)) {
                // Intento de asignación
                solucion.add(actual);

                // Recursión
                if (encontrarSecuenciaCircular(fichas, i + 1)) {
                    return true;
                }

                // Backtrack
                solucion.remove(solucion.size() - 1);
                fichas.get(i).flip();
            }
        }

        return false;
    }

    private boolean esFichaValida(Ficha ficha1, Ficha ficha2) {
        return (ficha1.getLado2() == ficha2.getLado1());
    }
} */
