package PrimerRecuperatorio28JUN2024;

/* Ejercicio 3

Dada una cuadrícula de tamaño N x M y una lista con N * M números enteros (positivos y negativos) se desea
encontrar, si existe, una configuración de la cuadrícula dónde, luego de colocar todos los números de la bolsa, se
cumplan las siguientes restricciones:

    - Si tomamos el valor de una fila como la suma de los valores que contiene, ninguna fila puede tener un valor
      superior a un valor F, dado por parámetro.
    - Si tomamos el valor de una columna como la suma de los valores que contiene, ninguna columna puede tener
      un valor ingerior a un valor C, dado por parámetro.

    a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
       información se lleva en los estados.
    b) Escriba un algoritmo en pseudo-java que resuelva el problema mediante la técnica de Backtracking. */

// Hacer los árboles
// Alternativa 1: ancho -> números, alto -> casilleros
/*
public class Ejercicio3 { // Backtracking
    public Matriz ejercicio3(Matriz m, List<Integer> numeros, int F, int C) {
        Matriz m = new Matriz(); // Inicializa todas las celdas en vacío
        // Suponemos que la matriz nos puede dar un iterador a cada una de sus casillas
        Iterator<Casillero> it = m.iterator();
        return obtenerConfiguracion(m, numeros, it, F, C);
    }

    private Matriz obtenerConfiguracion(Matriz m, List<Integer> numeros, Iterator<Casillero> it, int F, int C) {
        if (!it.hasNext()) {
            if (validarSolucion(m, F, C)) {
                return m;
            }
        } else {
            Casillero casillero = it.next();

            for (int indice = 0; indice < numeros.size(); i++) {
                int numero = numeros.get(indice);
                m.add(casillero, numero);
                numeros.remove(indice);

                Matriz sol = obtenerConfiguracion(m,numeros, it, F, C);

                if (sol != null) {
                    return sol;
                }

                numeros.add(indice, numero);
            }
        }

        return null;
    }
} */
