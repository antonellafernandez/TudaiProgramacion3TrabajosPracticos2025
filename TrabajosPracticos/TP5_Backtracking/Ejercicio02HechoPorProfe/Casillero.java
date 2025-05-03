package TP5_Backtracking.Ejercicio02HechoPorProfe;

import java.util.ArrayList;

public class Casillero {
    private int valor;
    private int[] pos;

    public Casillero(int valor, int[] pos) {
        this.valor = valor;
        this.pos = pos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public ArrayList<Casillero> getVecinos() {
        return new ArrayList<Casillero>();
    }
}
