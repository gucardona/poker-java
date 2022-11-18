package poker_grau_b;

import java.util.Random;

public class Baralho {
	private int quantidadeCartas = 52;
	private Cartas[] cartasUsadas;

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
	
	
	public void embaralhar(Cartas[] cartasUsadas) {
		Random random = new Random();
		for (int i=0; i < (cartasUsadas.length - 1); i++) {
			int j = random.nextInt(cartasUsadas.length);
			Cartas temp = cartasUsadas[i];
			cartasUsadas[i] = cartasUsadas[j];
			cartasUsadas[j] = temp;
		}
	}
	
	public void trocarCarta(Cartas primeira, Cartas segunda) {
		Cartas temp = primeira;
		primeira = segunda;
		segunda = temp;
	}
	
	public void descartarCarta() {
		
	}
}
