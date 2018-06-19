package DataStructures;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Esta clase posee a los nodos del grafo 
 * los cuales tiene un String para distinguir
 * unos de otros, una lista de arista para
 * saber cuales aristas salen de el, un grado 
 * saliente que da la cantidad de aristas 
 * que salen del nodo y un grado entrante que 
 * da cuales aristas entran a el
 * @author Bradly Valverde Fernandez
 *
 */
public class Nodo {
	private String nombre;
	private ArrayList<Arista> Aristas;
	private int Gsaliente;
	private int Gentrante;

	/**
	 * Contructor
	 * @param nombre. Nombre para diferenciar el nodo
	 */
	public Nodo(String nombre) {

		this.nombre = nombre;
		this.Aristas = new ArrayList<Arista>();
		this.Gsaliente = 0;
		this.Gentrante = 0;
	}
	
	/**
	 * A�ade una arista a su lista de aristas
	 * @param arista. Arista a a�adir
	 */
	public void addArista(Arista arista) {

		if (!containsArista(arista)) {
			this.Aristas.add(arista);
		}

	}
	
	/**
	 * Elimina una arista de su lista de aristas
	 * @param arista. Arista a eliminar
	 */
	public void deleteArista(Arista arista) {

		int index = 0;

		for (Arista a : this.Aristas) {

			if (a.getNInicio().getNombre().equals(arista.getNInicio().getNombre())
					&& a.getNFinal().getNombre().equals(arista.getNFinal().getNombre())) {
				break;

			}
			index++;

		}
		if (index >= this.Aristas.size()) {

			System.out.println("El objeto a eliminar no existe");

		} else {

			this.Aristas.remove(index);
		}

	}

	/**
	 * Busca una arista dentro de la 
	 * lista de aristas del nodo
	 * @param arista. Arista a buscar
	 * @return booleano true si se encuentra la arista y false si no
	 */
	private boolean containsArista(Arista arista) {

		boolean result = false;

		for (Arista a : this.Aristas) {

			if (a.getNInicio().getNombre().equals(arista.getNInicio().getNombre())
					&& a.getNFinal().getNombre().equals(arista.getNFinal().getNombre())) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * Metodo comparador para ordenar un Arraylist.sort() del objeto Nodo
	 * segun el Grado de entrada del nodo
	 */
	public static Comparator<Nodo> NodoGE = new Comparator<Nodo>() {

		@Override
		public int compare(Nodo n1, Nodo n2) {

			int GE1 = n1.getGentrante();
			int GE2 = n2.getGentrante();

			return GE2 - GE1;
		}
	};

	/**
	 * Metodo comparador para ordenar un Arraylist.sort() del objeto Nodo
	 * segun el Grado de salida del nodo
	 */
	public static Comparator<Nodo> NodoGS = new Comparator<Nodo>() {

		@Override
		public int compare(Nodo n1, Nodo n2) {

			int GS1 = n1.getGsaliente();
			int GS2 = n2.getGsaliente();

			return GS2 - GS1;
		}
	};

	/**
	 * Getter y Setter
	 */
	
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Arista> getAristas() {
		return Aristas;
	}

	public int getGsaliente() {
		return Gsaliente;
	}

	public void setGsaliente(int gsaliente) {
		Gsaliente = gsaliente;
	}

	public int getGentrante() {
		return Gentrante;
	}

	public void setGentrante(int gentrante) {
		Gentrante = gentrante;
	}

}