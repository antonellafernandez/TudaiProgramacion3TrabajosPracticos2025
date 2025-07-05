package Caminos;

import java.util.HashMap;
import java.util.Iterator;

/*
public class ExisteCamino {
	
	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;

	public ExisteCamino(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}
	
	public boolean existeCamino(Integer origen, Integer destino) {
		Iterator<Integer> itVert = grafo.obtenerVertices();
		while (itVert.hasNext()) {
			Integer vertice = itVert.next();
			colores.put(vertice, "blanco");
		}
		
		colores.put(origen, "amarillo"); // Genero mi estado inicial
		return existeCaminoRec(origen, destino);
	}
	
	private boolean existeCaminoRec(Integer actual, Integer destino) {
		
		// Condicion de corte
		if (actual == destino) {
			return true;
		} else {
			Iterator<Integer> itAdy = grafo.obtenerAdyacentes(actual);
			while (itAdy.hasNext()) { // por cada posible decision
				Integer adyacente = itAdy.next();
				if (colores.get(adyacente).equals("blanco")) {
					colores.put(adyacente, "amarillo"); // aplicaba los cambios
					boolean resultadoAdy = existeCaminoRec(adyacente, destino); // llamaba recursivamente
					if (resultadoAdy)
						return resultadoAdy;
					colores.put(adyacente, "blanco"); // deshacer los cambios
				}
			}	
		}
		
		return false;
	}
	
}
*/