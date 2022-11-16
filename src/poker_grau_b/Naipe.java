package poker_grau_b;

import java.util.Arrays;

public class Naipe {
	private String[] naipe = {"copas", "ouros", "paus", "espadas"};

	public Naipe(String[] naipe) {
		this.naipe = naipe;
	}

	public String[] getNaipe() {
		return naipe;
	}

	public void setNaipe(String[] naipe) {
		this.naipe = naipe;
	}

	@Override
	public String toString() {
		return "Naipe [naipe=" + Arrays.toString(naipe) + "]";
	}
}
