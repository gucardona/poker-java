package poker_grau_b;

import java.util.Arrays;

public class Jogador {
	private String nome;
	private int quantidadeFichas;
	private int apostaAtual;
	private Cartas[] cartasJogador = new Cartas[5];
	
	public int consultaFichas() {
		return quantidadeFichas;
	}
	
	public Cartas[] consultaMaoJogador() {
        return cartasJogador;
    }
	
	public void apostar(int aposta) {
		int qntFichasAntes = quantidadeFichas;
		quantidadeFichas -= apostaAtual;
		System.out.println("Você tinha " + qntFichasAntes + " fichas");
		System.out.println("Você apostou " + aposta + " fichas");
		System.out.println("Você tem " + quantidadeFichas + " fichas");
	}

	
	

	public Jogador(String nome, int quantidadeFichas, int apostaAtual, Cartas[] cartasJogador) {
		super();
		this.nome = nome;
		this.quantidadeFichas = quantidadeFichas;
		this.apostaAtual = apostaAtual;
		this.cartasJogador = cartasJogador;
	}

	public String getNome() {
		return nome;
	}

	public Cartas[] getCartasJogador() {
		return cartasJogador;
	}

	public void setCartasJogador(Cartas[] cartasJogador) {
		this.cartasJogador = cartasJogador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeFichas() {
		return quantidadeFichas;
	}

	public void setQuantidadeFichas(int quantidadeFichas) {
		this.quantidadeFichas = quantidadeFichas;
	}

	public int getApostaAtual() {
		return apostaAtual;
	}

	public void setApostaAtual(int apostaAtual) {
		this.apostaAtual = apostaAtual;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", quantidadeFichas=" + quantidadeFichas + ", apostaAtual=" + apostaAtual
				+ ", cartasJogador=" + Arrays.toString(cartasJogador) + "]";
	}
}
