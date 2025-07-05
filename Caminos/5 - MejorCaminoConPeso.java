package Caminos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
public class MejorCaminoConPeso {
	
	private Grafo<Integer> grafo;
	private HashMap<Integer, String> colores;
	private List<Integer> mejorSolucion;
	private Integer mejorPeso;

	public MejorCaminoConPeso(Grafo<Integer> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.mejorSolucion = new LinkedList<>();
		this.mejorPeso = null;
	}
	
	public List<Integer> encontrarMejorCamino(Integer origen, Integer destino) {
		Iterator<Integer> itVert = grafo.obtenerVertices();
		while (itVert.hasNext()) {
			Integer vertice = itVert.next();
			colores.put(vertice, "blanco");
		}
		
		List<Integer> caminoActual = new LinkedList<>();
		caminoActual.add(origen);
		colores.put(origen, "amarillo"); // Genero mi estado inicial
		
		encontrarMejorCaminoRec(origen, destino, caminoActual, 0);
		return mejorSolucion;
	}
	
	private void encontrarMejorCaminoRec(
		Integer actual, 
		Integer destino, 
		List<Integer> caminoActual,
		int pesoActual
	) {
		
		// Condicion de corte
		if (actual == destino) {
			if (esMejor(pesoActual, mejorPeso)) {
				this.mejorSolucion.clear();
				this.mejorSolucion.addAll(caminoActual);
				this.mejorPeso = pesoActual;
			}
		} else {
			Iterator<Integer> itAdy = grafo.obtenerAdyacentes(actual);
			while (itAdy.hasNext()) { // por cada posible decision
				Integer adyacente = itAdy.next();
				if (colores.get(adyacente).equals("blanco")) {
					Arco<Integer> arco = grafo.obtenerArco(actual, adyacente);
					
					colores.put(adyacente, "amarillo"); // aplicaba los cambios
					caminoActual.add(adyacente);
					pesoActual += arco.getEtiqueta();
					
					encontrarMejorCaminoRec(adyacente, destino, caminoActual, pesoActual); // llamaba recursivamente
					
					colores.put(adyacente, "blanco"); // deshacer los cambios
					caminoActual.removeLast();
					pesoActual -= arco.getEtiqueta();
				}
			}	
		}
	}
	
	private boolean esMejor(Integer actual, Integer mejor) {
		// return mejor == null || actual < mejor; // Camino menos pesado
		return mejor == null || actual > mejor; // Camino mas pesado
	}
	
}
*/