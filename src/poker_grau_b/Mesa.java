package poker_grau_b;

import java.util.Arrays;

public class Mesa {
	private int potApostas;
	private Jogador[] jogadores;
	private Jogador dealer;
	
	public Mesa(int potApostas, Jogador[] jogadores, Jogador dealer) {
		super();
		this.potApostas = potApostas;
		this.jogadores = jogadores;
		this.dealer = dealer;
	}

	public int getPotApostas() {
		return potApostas;
	}

	public void setPotApostas(int potApostas) {
		this.potApostas = potApostas;
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
		this.jogadores = jogadores;
	}

	public Jogador getDealer() {
		return dealer;
	}

	public void setDealer(Jogador dealer) {
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "Mesa [potApostas=" + potApostas + ", jogadores=" + Arrays.toString(jogadores) + ", dealer=" + dealer
				+ "]";
	}
}
