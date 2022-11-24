package poker_grau_b;

import java.util.Arrays;

public class Principal {
	public static void main(String[] args) {
		Operacoes op = new Operacoes();
		
		Jogador jogador = new Jogador(Teclado.leString("Qual o seu nome? "), 200, 0, null);
		Jogador computador1 = new Jogador("Computador Jonas", 200, 0, null);
		Jogador computador2 = new Jogador("Computador Cláudio", 200, 0, null);
		Jogador computador3 = new Jogador("Computador Djoniffer", 200, 0, null);
		Jogador computador4 = new Jogador("Computador Jennifer", 200, 0, null);
		
		Jogador[] jogadores = new Jogador[] {jogador, computador1, computador2, computador3, computador4};
		
		Mesa mesa = new Mesa(0, jogadores, jogador);
		
		Cartas[] baralho = op.geraBaralho();
		Cartas[] baralhoEmbaralhado = op.embaralhar(baralho);
		
		op.geraMaoJogadores(jogadores, baralhoEmbaralhado);
		
		System.out.println(jogador.toString());
		System.out.printf("Mão atual de %s: ", jogador.getNome());
		System.out.println(Arrays.toString(jogador.getMao()));
		
		System.out.println(computador1.toString());
		System.out.printf("Mão atual de %s: ", computador1.getNome());
		System.out.println(Arrays.toString(computador1.getMao()));
		
		System.out.println(computador2.toString());
		System.out.printf("Mão atual de %s: ", computador2.getNome());
		System.out.println(Arrays.toString(computador2.getMao()));
		
		System.out.println(computador3.toString());
		System.out.printf("Mão atual de %s: ", computador3.getNome());
		System.out.println(Arrays.toString(computador3.getMao()));
		
		System.out.println(computador4.toString());
		System.out.printf("Mão atual de %s: ", computador4.getNome());
		System.out.println(Arrays.toString(computador4.getMao()));
		
		while(mesa != null) {
			
		}
	}
}
