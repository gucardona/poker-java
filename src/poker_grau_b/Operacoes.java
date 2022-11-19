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
	
	public void trocarCartaJogador(Jogador jogador, Cartas[] mao, Cartas cartaEscolhida) {
		for(int i = 0; i < mao.length; i++) 
			if(cartaEscolhida.equals(mao[i])) {
				
			}
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
				mao[j] = mao[k];
				mao[k] = null;
			}
			jogadores[i].setMao(mao);
		}
	}
}
