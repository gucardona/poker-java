package poker_grau_b;

import java.util.Arrays;
import java.util.Random;

//GUSTAVO PARCIANELLO CARDONA

public class Principal {
	public static void main(String[] args) {
		Controle op = new Controle();
		Random random = new Random();
		
		Jogador jogador = new Jogador(Teclado.leString("Qual o seu nome? "), 200, 0, null);
		Jogador computador1 = new Jogador("Computador Jonas", 200, 0, null);
		Jogador computador2 = new Jogador("Computador Cláudio", 200, 0, null);
		Jogador computador3 = new Jogador("Computador Djoniffer", 200, 0, null);
		Jogador computador4 = new Jogador("Computador Jennifer", 200, 0, null);
		
		Jogador[] jogadores = new Jogador[] {jogador, computador1, computador2, computador3, computador4};
		
		Mesa mesa = new Mesa(1, 0, jogadores, jogador);
		
		while(true) {
			
			Cartas[] baralho = op.geraBaralho();
			Cartas[] baralhoEmbaralhado = op.embaralhar(baralho);
			
			op.geraMaoJogadores(jogadores, baralhoEmbaralhado);
			op.ordenarMao(jogador);
			
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
			
			op.trocarCartaJogador(jogador, Teclado.leInt("Quantidade de cartas que deseja trocar: "), 0);
			
			op.trocarCartaComputador(computador1, 1 + random.nextInt(6), 0);
			op.trocarCartaComputador(computador2, 1 + random.nextInt(6), 0);
			op.trocarCartaComputador(computador3, 1 + random.nextInt(6), 0);
			op.trocarCartaComputador(computador4, 1 + random.nextInt(6), 0);
			
			op.ordenarMao(jogador);
			
			op.ordenarMao(computador1);
			op.ordenarMao(computador2);
			op.ordenarMao(computador3);
			op.ordenarMao(computador4);
			
			while(true) {
				int i = 0;
				int rodada = 1;
				
				System.out.println();
				System.out.println(mesa.getRodada() + "ª " + " rodada de apostas");
				System.out.println();
				
				if(i == 0) {
					mesa.setDealer(jogador);
					computador4.apostar(5);
					computador3.apostar(10);
				}
				
				else if(i == 1) {
					mesa.setDealer(computador4);
					computador3.apostar(5);
					computador2.apostar(10);
				}
				
				else if(i == 2) {
					mesa.setDealer(computador3);
					computador2.apostar(5);
					computador1.apostar(10);
				}
				
				else if(i == 3) {
					mesa.setDealer(computador2);
					computador1.apostar(5);
					jogador.apostar(10);
				}
				
				else if(i == 4) {
					mesa.setDealer(computador1);
					jogador.apostar(5);
					computador4.apostar(10);
					i = 0;
				}
				
				i++;
				
				rodada++;
				mesa.setRodada(rodada);
				
				break;
			}
			
			break;
		}

		
		System.out.println();
		System.out.println("Carta mais alta de " + jogador.getNome() + ": " + op.checarCartaAlta(jogador));
		System.out.println(jogador.getNome() + " tem par? " + op.checarPar(jogador));
		System.out.println(jogador.getNome() + " tem dois pares? " + op.checarDoisPares(jogador));
		System.out.println(jogador.getNome() + " tem trinca? " + op.checarTrinca(jogador));
		System.out.println(jogador.getNome() + " tem sequência? " + op.checarSequencia(jogador));
		System.out.println(jogador.getNome() + " tem flush? " + op.checarFlush(jogador));
		System.out.println(jogador.getNome() + " tem full house? " + op.checarFullHouse(jogador));
		System.out.println(jogador.getNome() + " tem quadra? " + op.checarQuadra(jogador));
		System.out.println(jogador.getNome() + " tem straight flush? " + op.checarStraightFlush(jogador));
		System.out.println(jogador.getNome() + " tem royal straight flush? " + op.checarRoyalFlush(jogador));
		
		System.out.println(Arrays.toString(jogador.getMao()));
		
	}
}
