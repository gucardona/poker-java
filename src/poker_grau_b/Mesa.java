package poker_grau_b;

import java.util.Arrays;

//GUSTAVO PARCIANELLO CARDONA

public class Mesa {
	private int potApostas;
	private Jogador[] jogadores;
	private Jogador dealer;
	private int rodada;
	
	public Mesa(int rodada, int potApostas, Jogador[] jogadores, Jogador dealer) {
		super();
		this.potApostas = potApostas;
		this.jogadores = jogadores;
		this.dealer = dealer;
		this.rodada = 1;
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

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	@Override
	public String toString() {
		return "Mesa [potApostas=" + potApostas + ", jogadores=" + Arrays.toString(jogadores) + ", dealer=" + dealer
				+ ", rodada=" + rodada + "]";
	}
}