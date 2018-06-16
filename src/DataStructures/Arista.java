package DataStructures;

public class Arista {
	
	private int peso;
	private Nodo NInicio;
	private Nodo NFinal;
	
	
	
	public Arista(int peso, Nodo nInicio, Nodo nFinal) {
		
		this.peso = peso;
		NInicio = nInicio;
		NFinal = nFinal;
		
	}
	
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
