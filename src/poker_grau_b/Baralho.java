package poker_grau_b;

public class Baralho {
	private int quantidadeCartas = 52;
	private Cartas[] cartasUsadas;
	
	public void embaralhar() {
		
	}
	
	public void trocarCarta() {
		
	}
	
	public void descartarCarta() {
		
	}

	
	
	
	
	
	
	public Baralho(int quantidadeCartas, Cartas[] cartasUsadas) {
		super();
		this.quantidadeCartas = quantidadeCartas;
		this.cartasUsadas = cartasUsadas;
	}

	public int getQuantidadeCartas() {
		return quantidadeCartas;
	}

	public void setQuantidadeCartas(int quantidadeCartas) {
		this.quantidadeCartas = quantidadeCartas;
	}

	public Cartas[] getCartasUsadas() {
		return cartasUsadas;
	}

	public void setCartasUsadas(Cartas[] cartasUsadas) {
		this.cartasUsadas = cartasUsadas;
	}
}
