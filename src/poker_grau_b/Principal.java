package poker_grau_b;
import java.util.Arrays;
import java.util.Random;

//GUSTAVO PARCIANELLO CARDONA

public class Principal {
	public static void main(String[] args) {
		Controle op = new Controle();
		Random random = new Random();
		int dealer = 0;
		
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
			
			System.out.println();
			System.out.println("Sua mão:");
			System.out.println(Arrays.toString(jogador.getMao()));
			System.out.println();
			
			while(true) {
				int rodada = 1;
				
				System.out.println();
				System.out.println(mesa.getRodada() + "ª " + " rodada de apostas");
				System.out.println();
				System.out.println(dealer);
				
				if(dealer == 0) {
					System.out.println("--" + jogador.getNome() + " é o dealer.");
					mesa.setDealer(jogador);
					
					System.out.println();
					
					System.out.println("--" + computador4.getNome() + " é o small blind.");
					computador4.apostar(5);
					computador4.setApostaAtual(5);
					
					System.out.println();
					
					System.out.println("--" + computador3.getNome() + " é o big blind.");
					computador3.apostar(10);
					computador3.setApostaAtual(10);
					System.out.println();
					
					op.trocarCartaJogador(jogador, Teclado.leInt("Quantidade de cartas que deseja trocar: "), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador1, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador2, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador3, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador4, 1 + random.nextInt(6), 0);
					System.out.println();					
					
					op.ordenarMao(jogador);
					
					op.ordenarMao(computador1);
					op.ordenarMao(computador2);
					op.ordenarMao(computador3);
					op.ordenarMao(computador4);
					
					int primeiraAposta = op.quantidadeFichasAposta(10, 0);
					computador2.apostar(primeiraAposta);
					computador2.setApostaAtual(primeiraAposta);
					System.out.println();
					
					int segundaAposta = op.quantidadeFichasAposta(10, primeiraAposta);
					computador1.apostar(segundaAposta);
					computador1.setApostaAtual(segundaAposta);
					System.out.println();
					
					int terceiraAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + segundaAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					
					while(terceiraAposta < segundaAposta) {
						if(terceiraAposta == 0)
							System.out.println(jogador.getNome() + " está fora da rodada.");
						terceiraAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + segundaAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					}
					
					jogador.apostar(terceiraAposta);
					jogador.setApostaAtual(terceiraAposta);
					System.out.println();
					
					int quartaAposta = op.quantidadeFichasAposta(10, terceiraAposta);
					
					if(quartaAposta == 0)
						computador4.setApostaAtual(5);
					
					else {
						computador4.apostar(quartaAposta);
						computador4.setApostaAtual(quartaAposta);
					}
					System.out.println();
					
					int quintaAposta  = op.quantidadeFichasAposta(10, quartaAposta);
					
					if(quartaAposta == 10)
						computador3.setApostaAtual(10);
					
					else {
						computador3.apostar(quintaAposta);
						computador3.setApostaAtual(quintaAposta);
					}
					System.out.println();
					
					for(int j = 0; j < jogadores.length; j++) {
						if(jogadores[j].getApostaAtual() == 0)
							System.out.println(jogadores[j].getNome() + " deu fold e está fora da rodada atual.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 9)
							System.out.println(jogadores[j].getNome() + " tem um royal straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 8)
							System.out.println(jogadores[j].getNome() + " tem um straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 7)
							System.out.println(jogadores[j].getNome() + " tem uma quadra.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 6)
							System.out.println(jogadores[j].getNome() + " tem um full house.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 5)
							System.out.println(jogadores[j].getNome() + " tem um flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 4)
							System.out.println(jogadores[j].getNome() + " tem uma sequência.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 3)
							System.out.println(jogadores[j].getNome() + " tem uma trinca.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 2)
							System.out.println(jogadores[j].getNome() + " tem dois pares.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 1)
							System.out.println(jogadores[j].getNome() + " tem um par.");
						else
							System.out.println(jogadores[j].getNome() + " não tem jogo pronto, apenas carta alta.");
						System.out.println();
					}
					
					int potAposta = primeiraAposta + segundaAposta + terceiraAposta + quartaAposta;
					mesa.setPotApostas(potAposta);
					
					if(op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador1) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador2) &&
					   op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = jogador.getQuantidadeFichas() + potAposta;
						jogador.setQuantidadeFichas(potGanhador);
						System.out.println(jogador.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
						
					
					else if(op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador2) &&
						    op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador1.getQuantidadeFichas() + potAposta;
						computador1.setQuantidadeFichas(potGanhador);
						System.out.println(computador1.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador2.getQuantidadeFichas() + potAposta;
						computador2.setQuantidadeFichas(potGanhador);
						System.out.println(computador2.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador3.getQuantidadeFichas() + potAposta;
						computador3.setQuantidadeFichas(potGanhador);
						System.out.println(computador3.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador3)) {
						int potGanhador = computador4.getQuantidadeFichas() + potAposta;
						computador4.setQuantidadeFichas(potGanhador);
						System.out.println(computador4.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					dealer++;
					
					rodada++;
					mesa.setRodada(rodada);
					
					break;
				}
				
				else if(dealer == 1) {
					System.out.println("--" + computador4.getNome() + " é o dealer.");
					mesa.setDealer(computador4);
					
					System.out.println();
					
					System.out.println("--" + computador3.getNome() + " é o small blind.");
					computador3.apostar(5);
					computador3.setApostaAtual(5);
					
					System.out.println();
					
					System.out.println("--" + computador2.getNome() + " é o big blind.");
					computador2.apostar(10);
					computador2.setApostaAtual(10);
					System.out.println();
					
					op.trocarCartaJogador(jogador, Teclado.leInt("Quantidade de cartas que deseja trocar: "), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador1, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador2, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador3, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador4, 1 + random.nextInt(6), 0);
					System.out.println();					
					
					op.ordenarMao(jogador);
					
					op.ordenarMao(computador1);
					op.ordenarMao(computador2);
					op.ordenarMao(computador3);
					op.ordenarMao(computador4);
					
					int primeiraAposta = op.quantidadeFichasAposta(10, 0);
					computador1.apostar(primeiraAposta);
					computador1.setApostaAtual(primeiraAposta);
					System.out.println();
					
					int segundaAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + primeiraAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					
					while(segundaAposta < primeiraAposta) {
						if(segundaAposta == 0)
							System.out.println(jogador.getNome() + " está fora da rodada.");
						segundaAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + primeiraAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					}
					
					jogador.apostar(segundaAposta);
					jogador.setApostaAtual(segundaAposta);
					System.out.println();
					
					int terceiraAposta = op.quantidadeFichasAposta(10, segundaAposta);
					computador4.apostar(terceiraAposta);
					computador4.setApostaAtual(terceiraAposta);
					System.out.println();
					
					int quartaAposta = op.quantidadeFichasAposta(10, terceiraAposta);
					
					if(quartaAposta == 0)
						computador3.setApostaAtual(5);
					
					else {
						computador3.apostar(quartaAposta);
						computador3.setApostaAtual(quartaAposta);
					}
					System.out.println();
					
					int quintaAposta  = op.quantidadeFichasAposta(10, quartaAposta);
					
					if(quartaAposta == 10)
						computador2.setApostaAtual(10);
					
					else {
						computador2.apostar(quintaAposta);
						computador2.setApostaAtual(quintaAposta);
					}
					System.out.println();
					
					for(int j = 0; j < jogadores.length; j++) {
						if(jogadores[j].getApostaAtual() == 0)
							System.out.println(jogadores[j].getNome() + " deu fold e está fora da rodada atual.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 9)
							System.out.println(jogadores[j].getNome() + " tem um royal straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 8)
							System.out.println(jogadores[j].getNome() + " tem um straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 7)
							System.out.println(jogadores[j].getNome() + " tem uma quadra.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 6)
							System.out.println(jogadores[j].getNome() + " tem um full house.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 5)
							System.out.println(jogadores[j].getNome() + " tem um flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 4)
							System.out.println(jogadores[j].getNome() + " tem uma sequência.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 3)
							System.out.println(jogadores[j].getNome() + " tem uma trinca.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 2)
							System.out.println(jogadores[j].getNome() + " tem dois pares.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 1)
							System.out.println(jogadores[j].getNome() + " tem um par.");
						else
							System.out.println(jogadores[j].getNome() + " não tem jogo pronto, apenas carta alta.");
						System.out.println();
					}
					
					int potAposta = primeiraAposta + segundaAposta + terceiraAposta + quartaAposta;
					mesa.setPotApostas(potAposta);
					
					if(op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador1) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador2) &&
					   op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = jogador.getQuantidadeFichas() + potAposta;
						jogador.setQuantidadeFichas(potGanhador);
						System.out.println(jogador.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
						
					
					else if(op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador2) &&
						    op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador1.getQuantidadeFichas() + potAposta;
						computador1.setQuantidadeFichas(potGanhador);
						System.out.println(computador1.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador2.getQuantidadeFichas() + potAposta;
						computador2.setQuantidadeFichas(potGanhador);
						System.out.println(computador2.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador3.getQuantidadeFichas() + potAposta;
						computador3.setQuantidadeFichas(potGanhador);
						System.out.println(computador3.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador3)) {
						int potGanhador = computador4.getQuantidadeFichas() + potAposta;
						computador4.setQuantidadeFichas(potGanhador);
						System.out.println(computador4.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					dealer++;
					
					rodada++;
					mesa.setRodada(rodada);
					
					break;
				}
				
				else if(dealer == 2) {
					System.out.println("--" + computador3.getNome() + " é o dealer.");
					mesa.setDealer(computador3);
					
					System.out.println();
					
					System.out.println("--" + computador2.getNome() + " é o small blind.");
					computador2.apostar(5);
					computador2.setApostaAtual(5);
					
					System.out.println();
					
					System.out.println("--" + computador1.getNome() + " é o big blind.");
					computador1.apostar(10);
					computador1.setApostaAtual(10);
					System.out.println();
					
					op.trocarCartaJogador(jogador, Teclado.leInt("Quantidade de cartas que deseja trocar: "), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador1, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador2, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador3, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador4, 1 + random.nextInt(6), 0);
					System.out.println();					
					
					op.ordenarMao(jogador);
					
					op.ordenarMao(computador1);
					op.ordenarMao(computador2);
					op.ordenarMao(computador3);
					op.ordenarMao(computador4);
					
					int primeiraAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + 10 + " para continuar! Ou 0 fichas para sair da rodada.");
					
					while(primeiraAposta < 10) {
						if(primeiraAposta == 0)
							System.out.println(jogador.getNome() + " está fora da rodada.");
						primeiraAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + 10 + " para continuar! Ou 0 fichas para sair da rodada.");
					}
					
					jogador.apostar(primeiraAposta);
					jogador.setApostaAtual(primeiraAposta);
					System.out.println();
					
					int segundaAposta = op.quantidadeFichasAposta(10, 0);
					computador4.apostar(primeiraAposta);
					computador4.setApostaAtual(primeiraAposta);
					System.out.println();
					
					int terceiraAposta = op.quantidadeFichasAposta(10, segundaAposta);
					computador3.apostar(terceiraAposta);
					computador3.setApostaAtual(terceiraAposta);
					System.out.println();
					
					int quartaAposta = op.quantidadeFichasAposta(10, terceiraAposta);
					
					if(quartaAposta == 0)
						computador2.setApostaAtual(5);
					
					else {
						computador2.apostar(quartaAposta);
						computador2.setApostaAtual(quartaAposta);
					}
					System.out.println();
					
					int quintaAposta  = op.quantidadeFichasAposta(10, quartaAposta);
					
					if(quartaAposta == 10)
						computador1.setApostaAtual(10);
					
					else {
						computador1.apostar(quintaAposta);
						computador1.setApostaAtual(quintaAposta);
					}
					System.out.println();
					
					for(int j = 0; j < jogadores.length; j++) {
						if(jogadores[j].getApostaAtual() == 0)
							System.out.println(jogadores[j].getNome() + " deu fold e está fora da rodada atual.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 9)
							System.out.println(jogadores[j].getNome() + " tem um royal straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 8)
							System.out.println(jogadores[j].getNome() + " tem um straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 7)
							System.out.println(jogadores[j].getNome() + " tem uma quadra.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 6)
							System.out.println(jogadores[j].getNome() + " tem um full house.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 5)
							System.out.println(jogadores[j].getNome() + " tem um flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 4)
							System.out.println(jogadores[j].getNome() + " tem uma sequência.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 3)
							System.out.println(jogadores[j].getNome() + " tem uma trinca.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 2)
							System.out.println(jogadores[j].getNome() + " tem dois pares.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 1)
							System.out.println(jogadores[j].getNome() + " tem um par.");
						else
							System.out.println(jogadores[j].getNome() + " não tem jogo pronto, apenas carta alta.");
						System.out.println();
					}
					
					int potAposta = primeiraAposta + segundaAposta + terceiraAposta + quartaAposta;
					mesa.setPotApostas(potAposta);
					
					if(op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador1) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador2) &&
					   op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = jogador.getQuantidadeFichas() + potAposta;
						jogador.setQuantidadeFichas(potGanhador);
						System.out.println(jogador.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
						
					
					else if(op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador2) &&
						    op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador1.getQuantidadeFichas() + potAposta;
						computador1.setQuantidadeFichas(potGanhador);
						System.out.println(computador1.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador2.getQuantidadeFichas() + potAposta;
						computador2.setQuantidadeFichas(potGanhador);
						System.out.println(computador2.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador3.getQuantidadeFichas() + potAposta;
						computador3.setQuantidadeFichas(potGanhador);
						System.out.println(computador3.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador3)) {
						int potGanhador = computador4.getQuantidadeFichas() + potAposta;
						computador4.setQuantidadeFichas(potGanhador);
						System.out.println(computador4.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					dealer++;
					
					rodada++;
					mesa.setRodada(rodada);
					
					break;
				}
				
				else if(dealer == 3) {
					System.out.println("--" + computador2.getNome() + " é o dealer.");
					mesa.setDealer(computador2);
					
					System.out.println();
					
					System.out.println("--" + computador1.getNome() + " é o small blind.");
					computador1.apostar(5);
					computador1.setApostaAtual(5);
					
					System.out.println();
					
					System.out.println("--" + jogador.getNome() + " é o big blind.");
					jogador.apostar(10);
					jogador.setApostaAtual(10);
					System.out.println();
					
					op.trocarCartaJogador(jogador, Teclado.leInt("Quantidade de cartas que deseja trocar: "), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador1, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador2, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador3, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador4, 1 + random.nextInt(6), 0);
					System.out.println();					
					
					op.ordenarMao(jogador);
					
					op.ordenarMao(computador1);
					op.ordenarMao(computador2);
					op.ordenarMao(computador3);
					op.ordenarMao(computador4);
					
					int primeiraAposta = op.quantidadeFichasAposta(10, 0);
					computador4.apostar(primeiraAposta);
					computador4.setApostaAtual(primeiraAposta);
					System.out.println();
					
					int segundaAposta = op.quantidadeFichasAposta(10, primeiraAposta);
					computador3.apostar(segundaAposta);
					computador3.setApostaAtual(segundaAposta);
					System.out.println();
					
					int terceiraAposta = op.quantidadeFichasAposta(10, segundaAposta);
					computador2.apostar(terceiraAposta);
					computador2.setApostaAtual(terceiraAposta);
					System.out.println();
					
					int quartaAposta = op.quantidadeFichasAposta(10, terceiraAposta);
					
					if(quartaAposta == 0)
						computador1.setApostaAtual(5);
					
					else {
						computador1.apostar(quartaAposta);
						computador1.setApostaAtual(quartaAposta);
					}
					
					int quintaAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + quartaAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					
					while(quintaAposta < 10) {
						if(quintaAposta == 0)
							jogador.setApostaAtual(10);
							System.out.println(jogador.getNome() + " está fora da rodada.");
							quintaAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + quartaAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					}
					
					jogador.apostar(quintaAposta);
					jogador.setApostaAtual(quintaAposta);
					System.out.println();
					
					for(int j = 0; j < jogadores.length; j++) {
						if(jogadores[j].getApostaAtual() == 0)
							System.out.println(jogadores[j].getNome() + " deu fold e está fora da rodada atual.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 9)
							System.out.println(jogadores[j].getNome() + " tem um royal straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 8)
							System.out.println(jogadores[j].getNome() + " tem um straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 7)
							System.out.println(jogadores[j].getNome() + " tem uma quadra.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 6)
							System.out.println(jogadores[j].getNome() + " tem um full house.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 5)
							System.out.println(jogadores[j].getNome() + " tem um flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 4)
							System.out.println(jogadores[j].getNome() + " tem uma sequência.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 3)
							System.out.println(jogadores[j].getNome() + " tem uma trinca.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 2)
							System.out.println(jogadores[j].getNome() + " tem dois pares.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 1)
							System.out.println(jogadores[j].getNome() + " tem um par.");
						else
							System.out.println(jogadores[j].getNome() + " não tem jogo pronto, apenas carta alta.");
						System.out.println();
					}
					
					int potAposta = primeiraAposta + segundaAposta + terceiraAposta + quartaAposta;
					mesa.setPotApostas(potAposta);
					
					if(op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador1) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador2) &&
					   op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = jogador.getQuantidadeFichas() + potAposta;
						jogador.setQuantidadeFichas(potGanhador);
						System.out.println(jogador.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
						
					
					else if(op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador2) &&
						    op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador1.getQuantidadeFichas() + potAposta;
						computador1.setQuantidadeFichas(potGanhador);
						System.out.println(computador1.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador2.getQuantidadeFichas() + potAposta;
						computador2.setQuantidadeFichas(potGanhador);
						System.out.println(computador2.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador3.getQuantidadeFichas() + potAposta;
						computador3.setQuantidadeFichas(potGanhador);
						System.out.println(computador3.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador3)) {
						int potGanhador = computador4.getQuantidadeFichas() + potAposta;
						computador4.setQuantidadeFichas(potGanhador);
						System.out.println(computador4.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					dealer++;
					
					rodada++;
					mesa.setRodada(rodada);
					
					break;
				}
				
				else if(dealer == 4) {			
					System.out.println("--" + computador1.getNome() + " é o dealer.");
					mesa.setDealer(computador1);
					
					System.out.println();
					
					System.out.println("--" + jogador.getNome() + " é o small blind.");
					jogador.apostar(5);
					jogador.setApostaAtual(5);
					
					System.out.println();
					
					System.out.println("--" + computador4.getNome() + " é o big blind.");
					computador4.apostar(10);
					computador4.setApostaAtual(10);
					System.out.println();
					
					op.trocarCartaJogador(jogador, Teclado.leInt("Quantidade de cartas que deseja trocar: "), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador1, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador2, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador3, 1 + random.nextInt(6), 0);
					System.out.println();
					
					op.trocarCartaComputador(computador4, 1 + random.nextInt(6), 0);
					System.out.println();					
					
					op.ordenarMao(jogador);
					
					op.ordenarMao(computador1);
					op.ordenarMao(computador2);
					op.ordenarMao(computador3);
					op.ordenarMao(computador4);
					
					int primeiraAposta = op.quantidadeFichasAposta(10, 0);
					computador3.apostar(primeiraAposta);
					computador3.setApostaAtual(primeiraAposta);
					System.out.println();
					
					int segundaAposta = op.quantidadeFichasAposta(10, primeiraAposta);
					computador2.apostar(segundaAposta);
					computador2.setApostaAtual(segundaAposta);
					System.out.println();
					
					int terceiraAposta = op.quantidadeFichasAposta(10, segundaAposta);
					computador1.apostar(terceiraAposta);
					computador1.setApostaAtual(terceiraAposta);
					System.out.println();
					
					int quartaAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + terceiraAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					
					while(quartaAposta < 10) {
						if(quartaAposta == 0)
							jogador.setApostaAtual(5);
							System.out.println(jogador.getNome() + " está fora da rodada.");
						quartaAposta = Teclado.leInt("Deseja apostar quantas fichas?\nVocê deve apostar no mínimo " + terceiraAposta + " para continuar! Ou 0 fichas para sair da rodada.");
					}
					
					jogador.apostar(quartaAposta);
					jogador.setApostaAtual(quartaAposta);
					System.out.println();
					
					int quintaAposta = op.quantidadeFichasAposta(10, quartaAposta);
					
					if(quintaAposta == 0)
						computador4.setApostaAtual(5);
					
					else {
						computador4.apostar(quintaAposta);
						computador4.setApostaAtual(quintaAposta);
					}
					
					for(int j = 0; j < jogadores.length; j++) {
						if(jogadores[j].getApostaAtual() == 0)
							System.out.println(jogadores[j].getNome() + " deu fold e está fora da rodada atual.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 9)
							System.out.println(jogadores[j].getNome() + " tem um royal straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 8)
							System.out.println(jogadores[j].getNome() + " tem um straigth flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 7)
							System.out.println(jogadores[j].getNome() + " tem uma quadra.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 6)
							System.out.println(jogadores[j].getNome() + " tem um full house.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 5)
							System.out.println(jogadores[j].getNome() + " tem um flush.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 4)
							System.out.println(jogadores[j].getNome() + " tem uma sequência.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 3)
							System.out.println(jogadores[j].getNome() + " tem uma trinca.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 2)
							System.out.println(jogadores[j].getNome() + " tem dois pares.");
						else if (op.pontuacaoMaoJogadores(jogadores[j]) == 1)
							System.out.println(jogadores[j].getNome() + " tem um par.");
						else
							System.out.println(jogadores[j].getNome() + " não tem jogo pronto, apenas carta alta.");
						System.out.println();
					}
					
					int potAposta = primeiraAposta + segundaAposta + terceiraAposta + quartaAposta;
					mesa.setPotApostas(potAposta);
					
					if(op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador1) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador2) &&
					   op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(jogador) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = jogador.getQuantidadeFichas() + potAposta;
						jogador.setQuantidadeFichas(potGanhador);
						System.out.println(jogador.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
						
					
					else if(op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador2) &&
						    op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador1) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador1.getQuantidadeFichas() + potAposta;
						computador1.setQuantidadeFichas(potGanhador);
						System.out.println(computador1.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador3) && op.pontuacaoMaoJogadores(computador2) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador2.getQuantidadeFichas() + potAposta;
						computador2.setQuantidadeFichas(potGanhador);
						System.out.println(computador2.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador3) > op.pontuacaoMaoJogadores(computador4)) {
						int potGanhador = computador3.getQuantidadeFichas() + potAposta;
						computador3.setQuantidadeFichas(potGanhador);
						System.out.println(computador3.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					else if(op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(jogador) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador1) &&
						    op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador2) && op.pontuacaoMaoJogadores(computador4) > op.pontuacaoMaoJogadores(computador3)) {
						int potGanhador = computador4.getQuantidadeFichas() + potAposta;
						computador4.setQuantidadeFichas(potGanhador);
						System.out.println(computador4.getNome() + " ganhou a rodada, ganhando o total de " + potAposta + " fichas!");
					}
					
					dealer = 0;
					
					rodada++;
					mesa.setRodada(rodada);
					
					break;
				}
				
			}
			
			System.out.println();
			System.out.printf("Mão atual de %s: ", jogador.getNome());
			System.out.println(Arrays.toString(jogador.getMao()));
			System.out.println();
			System.out.printf("Mão atual de %s: ", computador1.getNome());
			System.out.println(Arrays.toString(computador1.getMao()));
			System.out.println();
			System.out.printf("Mão atual de %s: ", computador2.getNome());
			System.out.println(Arrays.toString(computador2.getMao()));
			System.out.println();
			System.out.printf("Mão atual de %s: ", computador3.getNome());
			System.out.println(Arrays.toString(computador3.getMao()));
			System.out.println();
			System.out.printf("Mão atual de %s: ", computador4.getNome());
			System.out.println(Arrays.toString(computador4.getMao()));
			System.out.println();
		}
	}
}