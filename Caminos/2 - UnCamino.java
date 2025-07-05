package Caminos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
public class UnCamino {
	
	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;

	public UnCamino(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}
	
	public List<Integer> encontrarCamino(Integer origen, Integer destino) {
		Iterator<Integer> itVert = grafo.obtenerVertices();
		while (itVert.hasNext()) {
			Integer vertice = itVert.next();
			colores.put(vertice, "blanco");
		}
		
		List<Integer> caminoActual = new LinkedList<>();
		caminoActual.add(origen);
		colores.put(origen, "amarillo"); // Genero mi estado inicial
		
		return encontrarCaminoRec(origen, destino, caminoActual);
	}
	
	private List<Integer> encontrarCaminoRec(
		Integer actual, 
		Integer destino, 
		List<Integer> caminoActual
	) {
		
		// Condicion de corte
		if (actual == destino) {
			return caminoActual;
		} else {
			Iterator<Integer> itAdy = grafo.obtenerAdyacentes(actual);
			while (itAdy.hasNext()) { // por cada posible decision
				Integer adyacente = itAdy.next();
				if (colores.get(adyacente).equals("blanco")) {
					colores.put(adyacente, "amarillo"); // aplicaba los cambios
					caminoActual.add(adyacente);
					List<Integer> posibleCamino = encontrarCaminoRec(adyacente, destino, caminoActual); // llamaba recursivamente
					if (posibleCamino != null)
						return posibleCamino;
					colores.put(adyacente, "blanco"); // deshacer los cambios
					caminoActual.removeLast();
				}
			}	
		}
		
		return null;
	}
	
}
*/