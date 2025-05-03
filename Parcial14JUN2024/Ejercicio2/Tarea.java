package Parcial14JUN2024.Ejercicio2;

public class Tarea {
    private int P; // Puntaje
    private int C; // Caducidad

    public Tarea(int p, int c) {
        P = p;
        C = c;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "P=" + P +
                ", C=" + C +
                '}';
    }
}
