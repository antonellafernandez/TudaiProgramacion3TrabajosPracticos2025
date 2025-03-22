package TP5_Backtracking.Ejercicio6;

/* Ejercicio 6

Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió a
ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas todavía
había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que deduzca el
recorrido completo que hizo el caballo. */

public class CaballoDeAtila {
    static final int N = 5; // Tamaño del tablero
    static final int[] origen = {0, 0};
    static final Movimiento[] movimientos = {
            new Movimiento(0, -1), // Arriba
            new Movimiento(0, 1),  // Abajo
            new Movimiento(-1, 0), // Izquierda
            new Movimiento(1, 0)   // Derecha
    };

    public static void main(String[] args) {
        // Crear un tablero de N x N
        Tablero tablero = new Tablero(N, origen);

        // Imprimir tablero inicial
        System.out.println("Tablero inicial");
        tablero.imprimirTablero();

        System.out.println();

        // Empezamos el recorrido desde una posición inicial
        int nroPisada = 0;
        tablero.marcarCasilla(origen[0], origen[1], 1); // Marcar el origen como casilla visitada
        backAtila(tablero, origen[0], origen[1], nroPisada); // Llamado al backtracking
    }

    // Método para resolver el recorrido utilizando Backtracking
    public static void backAtila(Tablero tablero, int x, int y, int nroPisada) {
        // Condición base: regresar a la casilla inicial después de haber recorrido al menos una casilla
        if (nroPisada > 1 && tablero.vecinaOrigen(x, y)) {
            System.out.println("Tablero solución con " + nroPisada + " pisadas");
            tablero.imprimirTablero();
            return;
        }

        // Intentar mover a las casillas adyacentes
        for (Movimiento mov : movimientos) {
            int nuevoX = x + mov.getDx();
            int nuevoY = y + mov.getDy();

            // Si el movimiento es válido
            if (tablero.esFactible(nuevoX, nuevoY)) {
                tablero.marcarCasilla(nuevoX, nuevoY, 1); // Marcar como visitada

                // Llamado recursiva
                backAtila(tablero, nuevoX, nuevoY, nroPisada + 1);

                // Desmarcar para probar otros caminos
                tablero.marcarCasilla(nuevoX, nuevoY, 0);
            }
        }
    }
}
