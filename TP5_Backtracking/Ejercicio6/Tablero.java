package TP5_Backtracking.Ejercicio6;

public class Tablero {
    private Casilla[][] casillas;
    private int N;
    private int[] origen;

    public Tablero(int N, int[] origen) {
        this.N = N;
        this.casillas = new Casilla[N][N];

        this.origen = origen;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void marcarCasilla(int x, int y, int color) {
        casillas[x][y].setColor(color);
    }

    // Imprimir el tablero para visualizar el recorrido
    public void imprimirTablero() {
        int n = casillas.length; // Dimensión vertical del tablero

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(casillas[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }

    // Verificar si la casilla actual está junto a la casilla inicial (para completar el recorrido cerrado)
    public boolean vecinaOrigen(int x, int y) {
        return (x == origen[0] && y == origen[1]);
    }

    // Verificar si una casilla es válida (dentro del tablero y no visitada)
    public boolean esFactible(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && casillas[x][y].getColor() == 0);
    }

    // Cantidad total de casillas en el tablero
    public int cantPisadas() {
        return N * N;
    }
}
