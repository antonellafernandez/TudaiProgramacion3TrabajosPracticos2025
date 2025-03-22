package TP5_Backtracking.Ejercicio6;

public class Casilla {
    private int color;

    public Casilla() {
        this.color = 0; // No visitada
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        if (color == 0 || color == 1) {
            this.color = color; // 0 = no visitada, 1 = visitada
        }
    }
}
