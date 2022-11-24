package poker_grau_b;

import java.util.Random;

public class Operacoes {
	Random random = new Random();
	
	public Cartas[] geraBaralho() {
		String[] naipes = new String[] {"Copas","Ouros", "Paus", "Espadas"};
		Cartas[] baralho = new Cartas[52];
		
		int i = 0;
		int j = 0;
		
		for(String naipe : naipes) {
			for(i = 0; i < 13; i++) {
				baralho[j] = new Cartas(i + 1, naipe);
				j++;
			}
		}
		return baralho;
	}
	
	public Cartas[] embaralhar(Cartas[] baralho) {
		for (int i=0; i < (baralho.length - 1); i++) {
			int j = random.nextInt(baralho.length);
			Cartas temp = baralho[i];
			baralho[i] = baralho[j];
			baralho[j] = temp;
		}
		return baralho;
	}
	
	public void geraMaoJogadores(Jogador[] jogadores, Cartas[] baralho) {
		int k = 0;
		for(int i = 0; i < jogadores.length; i++) {
			Cartas[] mao = new Cartas[5];
			for(int j = 0; j < mao.length; j++) {
				mao[j] = baralho[k];
				baralho[k] = null;
				k++;
			}
			jogadores[i].setMao(mao);
		}
	}
	
	public void trocarCartaJogador(Jogador jogador, Cartas[] mao, Cartas quantidadeTrocar, Cartas cartasEscolhidas) {
		for(int i = 0; i < mao.length; i++) 
			if(cartasEscolhidas.equals(mao[i])) {		
			}
	}
	
	
	
	public boolean checarRoyalFlush(Jogador[] jogadores) {
		
	}
	
	public boolean checarStraightFlush(Jogador[] jogadores) {

	}
	
	public boolean checarFullHouse(Jogador[] jogadores) {

	}
	
	public boolean checarFlush(Jogador[] jogadores) {

	}
	
	public boolean checarSequencia(Jogador[] jogadores) {

	}
	
	public boolean checarTrinca(Jogador[] jogadores) {

	}
	
	public boolean checarDoisPares(Jogador[] jogadores) {

	}
	
	public boolean checarPar(Jogador[] jogadores) {

	}
	
	public boolean checarCartaAlta(Jogador[] jogadores) {

	}
}
