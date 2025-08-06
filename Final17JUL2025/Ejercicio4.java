package Final17JUL2025;

import java.util.Collections;

/* Ejercicio 4

Se tiene un conjunto de prendeas de vestir sucias que deben lavarse. Cada prende de vestir tiene un peso asociado (el
peso de la prenda) y un color de prenda: blanca, negra o de color (rojo, amarillo, etc.). Por ejemplo, se puede tener un
jean negro de 500 gramos, una remera blanca de 200 gramos, etc. Disponemos de un único lavarropas, que tiene una
capacidad de carga máxima K por lavado (por ejemplo 6kg).

Se desea dividir el conjunto de prendas en tandas de lavado de manera que se minimice la cantidad de puestas en
funcionamiento del lavarropas, siempre asegurándonos que:
- En ninguna tanda sobrepasamos la capacidad máxima de carga K del lavarropas.
- En ningún momento se mezclen prendas blancas con prendas negras (la ropa de color si se puede juntar con
cualquiera de las otras dos).

public class Ejercicio4 {
    private List<List<Prenda>> S;
    private List<Integer> pesoTandas;
    private List<Boolean> contienePrendaNegra;
    private int K;

    public List<List<Prenda>> greedy(List<Prenda> C) {
        S = new ArrayList<ArrayList<Prenda>>();
        pesoTandas = new ArrayList<>();
        contienePrendaNegra = new ArrayList<>();

        // Ordenar C por peso descendente --> Longest Processing Time First
        Collections.sort(C, new ComparadorPesoDesc());

        for (Prenda p : C) {
            int j = 0;
            boolean ubicada = false;

            while (!ubicada && j < S.size()) {
                if (esFactible(p, j)) {
                    S.get(j).add(p);
                    pesoTandas.set(j, pesosTandas(j) + p.getPeso());
                    ubicada = true;
                }

                j++;
            }


            if (!ubicada) {
                // Crear nueva tanda
                List<Prenda> tanda = new ArrayList<>();
                tanda.add(p);
                S.add(tanda);
                pesoTandas.add(p.getPeso());
            }
        }

        return S;
    }

    private boolean esFactible(Prenda p, int tanda) {
        if (pesoTandas.get(tanda) + p.getPeso() <= K) {
            if ((contienePrendaNegra.get(tanda) && p.getColor().equals("NEGRO")) ||
                (!contienePrendaNegra.get(tanda) && !p.getColor().equals("NEGRO"))) {
                return true;
            }
        }

        return false;
    }
} */
