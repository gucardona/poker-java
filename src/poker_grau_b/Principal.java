package poker_grau_b;

public class Principal {
	public static void main(String[] args) {

		Operacoes op = new Operacoes();
		
		Jogador jogador = new Jogador(Teclado.leString("Qual o seu nome? "), 200, 0, null);
		Jogador computador1 = new Jogador("Computador Jonas", 200, 0, null);
		Jogador computador2 = new Jogador("Computador Cláudio", 200, 0, null);
		Jogador computador3 = new Jogador("Computador Djoniffer", 200, 0, null);
		Jogador computador4 = new Jogador("Computador Jennifer", 200, 0, null);
		
		Jogador[] jogadores = new Jogador[] {jogador, computador1, computador2, computador3, computador4};
		
		Cartas[] baralho = op.geraBaralho();
		Cartas[] baralhoEmbaralhado = op.embaralhar(baralho);
		
		op.geraMaoJogadores(jogadores, baralhoEmbaralhado);
		
		
	}
}
