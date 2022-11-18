package poker_grau_b;

import java.util.Arrays;

public class Computador extends Jogador {

	public Computador(String nome, int quantidadeFichas, int apostaAtual, Cartas[] cartasJogador) {
		super(nome, quantidadeFichas, apostaAtual, cartasJogador);
	}
	
	@Override
	public String toString() {
		return "Jogador [nome=" + getNome() + ", quantidadeFichas=" + getQuantidadeFichas() + ", apostaAtual=" + getApostaAtual()
				+ ", cartasJogador=" + Arrays.toString(getCartasJogador()) + "]";
	}
}
