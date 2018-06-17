package DataStructures;

public class Main {

	public static void main(String[] args) {
		GrafoD g1 = new GrafoD();
		
		g1.addArista("Puntarenas", "San Jose", 1);
		g1.addArista("Cartago", "San Jose", 1);
		g1.addArista("Cartago", "Puntarenas", 1);
		g1.addArista("Alajuela", "Cartago", 1);
		
		g1.addArista("Guanacaste", "San Carlos", 1);
		
		//g1.deleteNodo("San Jose");
		
		for(Nodo n : g1.getNodos()) {
			
			System.out.println("Los Nodos en el grafo son " + n.getNombre() + " y tienen como aristas dirigidos a");
			
			for (Arista a : n.getAristas()) {
				
				System.out.println(a.getNFinal().getNombre());
			}
			System.out.println();
			
		}
		for (Arista a : g1.getAristas()) {
			
			System.out.println("El grafo posee arista que van de " + a.getNInicio().getNombre() + " a " + a.getNFinal().getNombre());
		}
		
	}

}
