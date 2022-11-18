package poker_grau_b;

public class Cartas {
	private int valorCarta;
	private String[] naipe;
	
	public Cartas(int valorCarta, String[] naipe) {
		this.valorCarta = valorCarta;
		this.naipe = naipe;
	}

	public int getValorCarta() {
		return valorCarta;
	}

	public void setValorCarta(int valorCarta) {
		this.valorCarta = valorCarta;
	}

	public String[] getNaipe() {
		return naipe;
	}

	public void setNaipe(String[] naipe) {
		this.naipe = naipe;
	}
	
	public void imprimeCarta(){
		if (valorCarta == 11){
			System.out.printf("J de " + naipe);
		}
		
		else if(valorCarta == 12){
			System.out.printf("Q de " + naipe);
		}
		
		else if(valorCarta == 13){
			System.out.printf("K de " + naipe);
		}
		
		else if(valorCarta == 14){
			System.out.printf("A de " + naipe);
		}
		
		else{
			System.out.println(getValorCarta());
			System.out.printf(" de " + naipe);
		}
	}
}	
