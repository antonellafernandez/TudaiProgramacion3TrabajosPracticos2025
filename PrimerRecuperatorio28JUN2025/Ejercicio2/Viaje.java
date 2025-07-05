package PrimerRecuperatorio28JUN2025.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private List<Caja> cajas;
    private int peso;

    public Viaje(int peso) {
        this.cajas = new ArrayList<>();
        this.peso = peso;
    }

    public List<Caja> getCajas() {
        return new ArrayList<>(cajas);
    }

    public void addCaja(Caja caja) {
        this.cajas.add(caja);
        this.peso += caja.getPeso();
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
