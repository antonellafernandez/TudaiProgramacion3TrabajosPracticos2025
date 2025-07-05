package PrimerRecuperatorio28JUN2025.Ejercicio2;

import java.util.Comparator;

public class ComparadorPesoDesc implements Comparator<Caja> {
    public int compare(Caja c1, Caja c2) {
        return Integer.compare(c2.getPeso(), c1.getPeso());
    }
}
