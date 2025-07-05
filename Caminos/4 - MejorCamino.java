package Caminos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
public class MejorCamino {
	
	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private List<Integer> mejorSolucion;

	public MejorCamino(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.mejorSolucion = new LinkedList<>();
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
		
		encontrarMejorCaminoRec(origen, destino, caminoActual);
		return mejorSolucion;
	}
	
	private void encontrarMejorCaminoRec(
		Integer actual, 
		Integer destino, 
		List<Integer> caminoActual
	) {
		
		// Condicion de corte
		if (actual == destino) {
			if (esMejor(caminoActual, this.mejorSolucion)) {
				this.mejorSolucion.clear();
				this.mejorSolucion.addAll(caminoActual);
			}
		} else {
			Iterator<Integer> itAdy = grafo.obtenerAdyacentes(actual);
			while (itAdy.hasNext()) { // por cada posible decision
				Integer adyacente = itAdy.next();
				if (colores.get(adyacente).equals("blanco")) {					
					colores.put(adyacente, "amarillo"); // aplicaba los cambios
					caminoActual.add(adyacente);
					
					encontrarMejorCaminoRec(adyacente, destino, caminoActual); // llamaba recursivamente
					
					colores.put(adyacente, "blanco"); // deshacer los cambios
					caminoActual.removeLast();
				}
			}	
		}
	}
	
	private boolean esMejor(List<Integer> actual, List<Integer> mejor) {	
		// return actual.size() > mejor.size(); // Camino mas largo
		return mejor.isEmpty() || actual.size() < mejor.size(); // Camino mas corto
	}
	
}
*/