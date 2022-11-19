package poker_grau_b;

public class Cartas {
	private int valorCarta;
	private String naipe;
	
	public Cartas(int valorCarta, String naipe) {
		this.valorCarta = valorCarta;
		this.naipe = naipe;
	}

	public int getValorCarta() {
		return valorCarta;
	}

	public void setValorCarta(int valorCarta) {
		this.valorCarta = valorCarta;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
}
	
