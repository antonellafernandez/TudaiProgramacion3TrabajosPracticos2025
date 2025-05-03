package TrabajosPracticos.TP6_Greedy.Ejercicio02;

/* Ejercicio 2

Problema de la mochila: Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un peso
positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El objetivo es
llenar la mochila de tal manera que se maximice el valor de los objetos transportados, respetando la
limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una fracción xi (0 ≤ xi ≤ 1)
del objeto i es ubicada en la mochila contribuye en xipi al peso total de la mochila y en xivi al valor
de la carga.

¿Qué estrategia Greedy seguiría para resolver el problema? Esquematice la resolución mediante un
pseudocódigo en Java. */

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private List<Integer> mochila; // Solución
    private List<Integer> elementosPeso;
    private List<Integer> elementosValor;
    private int pesoMax;

    public Mochila(List<Integer> elementosPeso, List<Integer> elementosValor, int pesoMax) {
        this.mochila = new ArrayList<>();
        this.elementosPeso = elementosPeso;
        this.elementosValor = elementosValor;
        this.pesoMax = pesoMax;
    }

    public List<Integer> greedy() {
        for (int i = 0; i < elementosPeso.size(); i++) {
            mochila.set(i, 0);
        }

        int pesoActual = 0;

        while (pesoActual < pesoMax) {
            int i = seleccion();

            if (pesoActual + elementosPeso.get(i) < pesoMax) {
                mochila.set(i, 1);
                pesoActual += elementosPeso.get(i);
            } else {
                mochila.set(i, (pesoMax - pesoActual) / elementosPeso.get(i));
                pesoActual = pesoMax;
            }
        }

        return mochila;
    }

    private int seleccion() {
        double coeficienteMayor = 0;
        int indice = -1;

        for(int i = 0; i<elementosPeso.size(); i++) {
            double coeficiente = elementosValor.get(i) / elementosPeso.get(i);

            if(coeficiente > coeficienteMayor) {
                coeficienteMayor = coeficiente;
                indice = i;
            }
        }

        return indice;
    }
}
