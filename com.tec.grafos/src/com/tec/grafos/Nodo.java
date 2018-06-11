package com.tec.grafos;

import java.util.ArrayList;

public class Nodo {
	private String nombre;
	private ArrayList<Arista> Aristas;
	
	
	public Nodo(String nombre) {
		
		this.nombre = nombre;
		this.Aristas = new ArrayList<Arista>();
		
	}

	public void addArista(Arista arista) {
		
		if (!containsArista(arista)) {
			this.Aristas.add(arista);
		}
		
	}
	
	public void deleteArista(Arista arista) {
		
		int index = 0;
		
		for (Arista a : this.Aristas) {
			
			if (a.getNInicio().getNombre().equals(arista.getNInicio().getNombre()) &&
					a.getNFinal().getNombre().equals(arista.getNFinal().getNombre())) {
				break;
				
			}
			index ++;
			
			
		} if (index >= this.Aristas.size()) {
			
			System.out.println("El objeto a eliminar no existe");
			
		}else {
			
			this.Aristas.remove(index);
		}
	
	}
	
	
	
	private boolean containsArista(Arista arista) {
		
		boolean result = false;
		
		for (Arista a : this.Aristas) {
			
			if (a.getNInicio().getNombre().equals(arista.getNInicio().getNombre()) &&
					a.getNFinal().getNombre().equals(arista.getNFinal().getNombre())) {
				result = true;
			}
		}
		
		return result;
	}

	public String getNombre() {
		return nombre;
	}


	public ArrayList<Arista> getAristas() {
		return Aristas;
	}
	
	
	
}
