package DataStructures;
/**
 * Esta clase posee a las aristas del grafo
 * las cuales tienen un nodo de inicio
 * y van dirigidas a un nodo de llegada
 * con su propios peso
 * 
 * @author Bradly Valverde Fernandez
 *
 */
public class Arista {
	
	private int peso;
	private Nodo NInicio;
	private Nodo NFinal;
	
	
	/**
	 * Constructor
	 */
	public Arista(Nodo nInicio, Nodo nFinal, int peso) {

		NInicio = nInicio;
		NFinal = nFinal;
		this.peso = peso;
		
	}
	
	/**
	 * Getter y Setter
	 */
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Nodo getNInicio() {
		return NInicio;
	}
	public void setNInicio(Nodo nInicio) {
		NInicio = nInicio;
	}
	public Nodo getNFinal() {
		return NFinal;
	}
	public void setNFinal(Nodo nFinal) {
		NFinal = nFinal;
	}
	
	
	
}
