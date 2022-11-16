package poker_grau_b;

public class Cartas {
	private String[] valorCarta;
	private Naipe[] naipe;
	
	public Cartas(String[] valorCarta, Naipe[] naipe) {
		this.valorCarta = valorCarta;
		this.naipe = naipe;
	}

	public String[] getValorCarta() {
		return valorCarta;
	}

	public void setValorCarta(String[] valorCarta) {
		this.valorCarta = valorCarta;
	}

	public Naipe[] getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe[] naipe) {
		this.naipe = naipe;
	}
}
