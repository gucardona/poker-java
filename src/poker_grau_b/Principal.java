package poker_grau_b;

public class Principal {
	public static void main(String[] args) {

		Mesa mesa = new Mesa(0, 5, false);
		Cartas cartas = new Cartas(0, null);
		Baralho baralho = new Baralho(52, null);
		
		Jogador jogador = new Jogador(Teclado.leString("Qual o seu nome: "), 200, 0, null);
		
		Computador computador1 = new Computador("(Computador) - Rosângela", 200, 0, null);
		
		Computador computador2 = new Computador("(Computador) - Jorge", 200, 0, null);
		
		Computador computador3 = new Computador("(Computador) - Jefferson", 200, 0, null);
		
		Computador computador4 = new Computador("(Computador) - Edvalda", 200, 0, null);
		
		Computador[] Computadores = {computador1};
	}
}
