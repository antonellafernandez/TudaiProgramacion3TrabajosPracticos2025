package Caminos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
public class TodosLosCaminos {
	
	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private Set<List<Integer>> soluciones;

	public TodosLosCaminos(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.soluciones = new HashSet<>();
	}
	
	public Set<List<Integer>> encontrarTodosLosCaminos(Integer origen, Integer destino) {
		Iterator<Integer> itVert = grafo.obtenerVertices();
		while (itVert.hasNext()) {
			Integer vertice = itVert.next();
			colores.put(vertice, "blanco");
		}
		
		List<Integer> caminoActual = new LinkedList<>();
		caminoActual.add(origen);
		colores.put(origen, "amarillo"); // Genero mi estado inicial
		
		encontrarTodosLosCaminosRec(origen, destino, caminoActual);
		return soluciones;
	}
	
	private void encontrarTodosLosCaminosRec(
		Integer actual, 
		Integer destino, 
		List<Integer> caminoActual
	) {
		
		// Condicion de corte
		if (actual == destino) {
			List<Integer> solucion = new LinkedList<>(caminoActual);
			soluciones.add(solucion);
		} else {
			Iterator<Integer> itAdy = grafo.obtenerAdyacentes(actual);
			while (itAdy.hasNext()) { // por cada posible decision
				Integer adyacente = itAdy.next();
				if (colores.get(adyacente).equals("blanco")) {
					colores.put(adyacente, "amarillo"); // aplicaba los cambios
					caminoActual.add(adyacente);
					encontrarTodosLosCaminosRec(adyacente, destino, caminoActual); // llamaba recursivamente
					colores.put(adyacente, "blanco"); // deshacer los cambios
					caminoActual.removeLast();
				}
			}	
		}
	}
	
}
*/