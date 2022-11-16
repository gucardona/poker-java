package poker_grau_b;

public class Mesa {
	private int potApostas;
	private int numeroJogadores;
	private boolean dealer;
	
	public Mesa(int potApostas, int numeroJogadores, boolean dealer) {
		this.potApostas = potApostas;
		this.numeroJogadores = numeroJogadores;
		this.dealer = dealer;
	}

	public int getPotApostas() {
		return potApostas;
	}

	public void setPotApostas(int potApostas) {
		this.potApostas = potApostas;
	}

	public int getNumeroJogadores() {
		return numeroJogadores;
	}

	public void setNumeroJogadores(int numeroJogadores) {
		this.numeroJogadores = numeroJogadores;
	}

	public boolean isDealer() {
		return dealer;
	}

	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}
}
