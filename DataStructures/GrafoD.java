package DataStructures;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que controla a las demas clases
 * en el paquete y crea un grafo dirigido 
 * con ellas
 * @author Bradly Valverde Fernandez
 *
 */
public class GrafoD {

	private ArrayList<Nodo> Nodos;
	private ArrayList<Arista> Aristas;

	/**
	 * Constructor
	 */
	public GrafoD() {

		this.Aristas = new ArrayList<Arista>();
		this.Nodos = new ArrayList<Nodo>();
	}

	/**
	 * A�ade una arista al grafo dirigido
	 * junto con los 2 nodos de cada extremo
	 * @param nodoInicio. String del Nodo de inicio de la arista
	 * @param nodoFinal. String del Nodo al que va dirigido la arista
	 * @param peso. Peso de la arista
	 */
	public void addArista(String nodoInicio, String nodoFinal, int peso) {

		Nodo nTemp1 = new Nodo(nodoInicio);
		Nodo nTemp2 = new Nodo(nodoFinal);

		Arista aTemp = new Arista(peso, nTemp1, nTemp2);

		nTemp1.addArista(aTemp);

		if (!containsNodo(nodoInicio) && !containsNodo(nodoFinal)) {
			this.Nodos.add(nTemp1);
			this.Nodos.add(nTemp2);
			if (!containsArista(aTemp)) {
				this.Aristas.add(aTemp);
			}

		} else if (!containsNodo(nodoInicio)) {
			this.Nodos.add(nTemp1);
			if (!containsArista(aTemp)) {
				this.Aristas.add(aTemp);
			}
		} else if (!containsNodo(nodoFinal)) {
			this.Nodos.add(nTemp2);
			if (!containsArista(aTemp)) {
				addAristaToNodo(nodoInicio, aTemp);
				this.Aristas.add(aTemp);
			}
		} else {
			if (!containsArista(aTemp)) {
				this.Aristas.add(aTemp);
				addAristaToNodo(nodoInicio, aTemp);
			}
		}

	}

	/**
	 * Devuelve el grado saliente 
	 * del nodo especificado
	 * @param nodo. String del nodo al que se le busca el grado saliente
	 * @return La cantidad de arista que salen de ese nodo
	 */
	public int getGradoSaliente(String nodo) {

		int result = 0;

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodo)) {

				for (Arista a : this.Aristas) {
					if (a.getNInicio().getNombre().equals(nodo)) {

						result += 1;

					}

				}
				break;

			}

		}
		return result;
	}

	/**
	 * Devuelve el grado entrante
	 * del nodo especificado
	 * @param nodo. String del nodo al que se le busca el grado Entrante
	 * @return La cantidad de arista que entran a ese nodo
	 */
	public int getGradoEntrante(String nodo) {

		int result = 0;

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodo)) {

				for (Arista a : this.Aristas) {
					if (a.getNFinal().getNombre().equals(nodo)) {

						result += 1;

					}

				}
				break;

			}

		}
		return result;
	}

	/**
	 * genera de mayor a menor 
	 * un ranking en la consola de cuales nodos
	 * tienen mas dependencias
	 */
	public void generateRankingDependencies() {

		for (Nodo n : this.Nodos) {

			n.setGentrante(getGradoEntrante(n.getNombre()));
			n.setGsaliente(getGradoSaliente(n.getNombre()));
		}

		Collections.sort(this.Nodos, Nodo.NodoGE);

		for (Nodo n : this.Nodos) {

			System.out.println("El Nodo " + n.getNombre() + " posee una dependencia de " + n.getGentrante());
		}

	}

	/**
	 * genera de mayor a menor 
	 * un ranking en la consola de cuales nodos
	 * son mas referenciados
	 */
	public void generateRankingReferences() {

		for (Nodo n : this.Nodos) {

			n.setGentrante(getGradoEntrante(n.getNombre()));
			n.setGsaliente(getGradoSaliente(n.getNombre()));
		}

		Collections.sort(this.Nodos, Nodo.NodoGS);

		for (Nodo n : this.Nodos) {

			System.out.println("El Nodo " + n.getNombre() + " posee una referencia de " + n.getGsaliente());
		}

	}

	/**
	 * genera una matriz de direcciones
	 * del grafo con sus nodos
	 */
	public void generateMatrix() {

		int[][] matrix = new int[this.Nodos.size()][this.Nodos.size()];
		int i = 0;
		int j = 0;

		System.out.println("El orden es ");

		for (Nodo n : this.Nodos) {
			System.out.print(n.getNombre() + " ");
		}

		for (Nodo n1 : this.Nodos) {

			for (Nodo n2 : this.Nodos) {

				for (Arista a : n1.getAristas()) {

					if (a.getNFinal().getNombre().equals(n2.getNombre())) {
						matrix[i][j] = 1;
						break;
					} else {
						matrix[i][j] = 0;
					}

				}
				j += 1;

			}
			i += 1;

			j = 0;

		}

		System.out.println();
		System.out.println("Y su matriz es ");

		int contar = 0;

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				if (contar != matrix.length) {
					System.out.print(matrix[x][y] + " ");
					contar += 1;
				} else {
					System.out.println();
					System.out.print(matrix[x][y] + " ");
					contar = 1;
				}
			}
		}
	}

	/**
	 * A�ade una arista al
	 * nodo que se busca dentro de la 
	 * lista de nodos del grafo dirigido
	 * @param nodoInicio. Nodo al que se le desea a�adir la arista
	 * @param arista. arista a a�adir
	 */
	private void addAristaToNodo(String nodoInicio, Arista arista) {

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodoInicio)) {
				n.addArista(arista);
			}

		}

	}

	/**
	 * Busca un nodo dentro de la 
	 * lista de de nodos del grafo
	 * @param nodo. Nodo a buscar
	 * @return booleano true si se encuentra el nodo y false si no
	 */
	private boolean containsNodo(String nodo) {
		boolean result = false;

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodo)) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * Busca una arista dentro de la 
	 * lista de aristas del grafo
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
	 * Getter
	 */
	
	public ArrayList<Nodo> getNodos() {
		return Nodos;
	}

	public ArrayList<Arista> getAristas() {
		return Aristas;
	}

	
	// public void deleteArista(Arista arista) {
	//
	// int index = 0;
	//
	// for (Arista a : this.Aristas) {
	//
	// if (a.getNInicio().getNombre().equals(arista.getNInicio().getNombre())
	// && a.getNFinal().getNombre().equals(arista.getNFinal().getNombre())) {
	//
	// break;
	//
	// }
	// index++;
	//
	// }
	// if (index >= this.Aristas.size()) {
	//
	// System.out.println("El objeto a eliminar no existe");
	//
	// } else {
	//
	// this.Aristas.remove(index);
	// }
	//
	// }
	//
	// public void deleteNodo(String nodo) {
	//
	// int index = 0;
	//
	// for (Nodo n : this.Nodos) {
	//
	// if (n.getNombre().equals(nodo)) {
	//
	// for (Arista a : n.getAristas()) {
	//
	// deleteArista(a);
	//
	// }
	// break;
	//
	// }
	// index++;
	//
	// }
	// if (index >= this.Nodos.size()) {
	//
	// System.out.println("El objeto a eliminar no existe");
	//
	// } else {
	//
	// for (Arista a : this.Aristas) {
	//
	// if (a.getNFinal().getNombre().equals(nodo)) {
	//
	// deleteArista(a);
	// deleteAristaToNodo(a.getNInicio().getNombre(), a);
	// break;
	//
	// }
	//
	// }
	//
	// this.Nodos.remove(index);
	// }
	// }
	// private void deleteAristaToNodo(String nodoInicio, Arista arista) {
	//
	// for (Nodo n : this.Nodos) {
	//
	// if (n.getNombre().equals(nodoInicio)) {
	// n.deleteArista(arista);
	// }
	//
	// }
	//
	// }
}