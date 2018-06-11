package com.tec.grafos;

import java.util.ArrayList;

public class GrafoD {

	private ArrayList<Nodo> Nodos;
	private ArrayList<Arista> Aristas;

	public GrafoD() {

		this.Aristas = new ArrayList<Arista>();
		this.Nodos = new ArrayList<Nodo>();
	}

	public void addArista(String nodoInicio, String nodoFinal, int peso) {

		Nodo nTemp1 = new Nodo(nodoInicio);
		Nodo nTemp2 = new Nodo(nodoFinal);

		Arista aTemp = new Arista(peso, nTemp1, nTemp2);

		nTemp1.addArista(aTemp);

		if (!containsNodo(nodoInicio) && !containsNodo(nodoFinal)) {
			this.Nodos.add(nTemp1);
			this.Nodos.add(nTemp2);
			this.Aristas.add(aTemp);

		} else if (!containsNodo(nodoInicio)) {
			this.Nodos.add(nTemp1);
			this.Aristas.add(aTemp);

		} else if (!containsNodo(nodoFinal)) {
			this.Nodos.add(nTemp2);
			addAristaToNodo(nodoInicio, aTemp);
			this.Aristas.add(aTemp);
		} else {
			this.Aristas.add(aTemp);
			addAristaToNodo(nodoInicio, aTemp);

		}

	}

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

	public void deleteNodo(String nodo) {

		int index = 0;

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodo)) {

				for (Arista a : n.getAristas()) {

					deleteArista(a);

				}
				break;

			}
			index++;

		}
		if (index >= this.Nodos.size()) {

			System.out.println("El objeto a eliminar no existe");

		} else {

			for (Arista a : this.Aristas) {

				if (a.getNFinal().getNombre().equals(nodo)) {
					
					deleteAristaToNodo(a.getNInicio().getNombre(), a);
					deleteArista(a);
					break;
					
				}

			}

			this.Nodos.remove(index);
		}
	}

	private void addAristaToNodo(String nodoInicio, Arista arista) {

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodoInicio)) {
				n.addArista(arista);
			}

		}

	}

	private void deleteAristaToNodo(String nodoInicio, Arista arista) {

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodoInicio)) {
				n.deleteArista(arista);
			}

		}

	}

	private boolean containsNodo(String nodo) {
		boolean result = false;

		for (Nodo n : this.Nodos) {

			if (n.getNombre().equals(nodo)) {
				result = true;
			}
		}

		return result;
	}

	public ArrayList<Nodo> getNodos() {
		return Nodos;
	}

	public ArrayList<Arista> getAristas() {
		return Aristas;
	}
	
}
