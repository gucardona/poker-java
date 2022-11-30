package poker_grau_b;

import java.util.Arrays;
import java.util.Random;

//GUSTAVO PARCIANELLO CARDONA

public class Controle {
    Random random = new Random();

    public Cartas[] geraBaralho() { // GERA O BARALHO PARA OS JOGADORES
	String[] naipes = new String[] { "Copas", "Ouros", "Paus", "Espadas" };
	Cartas[] baralho = new Cartas[52];

	int i = 0;
	int j = 0;

	for (String naipe : naipes) {
	    for (i = 0; i < 13; i++) {
		baralho[j] = new Cartas(i + 1, naipe);
		j++;
	    }
	}
	return baralho;
    }

    public Cartas[] embaralhar(Cartas[] baralho) { // EMBARALHA O BARALHO GERADO
	for (int i = 0; i < (baralho.length - 1); i++) {
	    int j = random.nextInt(baralho.length);
	    Cartas temp = baralho[i];
	    baralho[i] = baralho[j];
	    baralho[j] = temp;
	}
	return baralho;
    }

    public void geraMaoJogadores(Jogador[] jogadores, Cartas[] baralho) { // PEGA O BARALHO EMBARALHADO E DISTRIBUI 5
									  // CARTAS PARA CADA JOGADOR
	int k = 0;
	for (int i = 0; i < jogadores.length; i++) {
	    Cartas[] mao = new Cartas[5];
	    for (int j = 0; j < mao.length; j++) {
		mao[j] = baralho[k];
		baralho[k] = null;
		k++;
	    }
	    if (jogadores[i] != null)
		jogadores[i].setMao(mao);
	}
    }

    public void trocarCartaJogador(Jogador jogador, int quantidadeTrocar, int escolhida) { // MÉTODO PARA O JOGADOR
											   // TROCAR CARTA CASO QUEIRA
	System.out.println();
	if (quantidadeTrocar < 1)
	    System.out.println("Você não trocou nenhuma carta!\nContinuando...");

	while (quantidadeTrocar > 5)
	    quantidadeTrocar = Teclado.leInt("Você só tem 5 cartas na mão!\nQuantas cartas deseja trocar: ");

	for (int i = 0; i < quantidadeTrocar; i++) {

	    escolhida = Teclado.leInt("Posicão da carta que deseja trocar: ");
	    System.out.println();

	    while (escolhida > 5)
		escolhida = Teclado.leInt("Você só tem 5 cartas na mão!\nPosicão da carta que deseja trocar: ");

	    String naipe = "Copas";
	    System.out.println();

	    if (random.nextInt(4) == 0)
		naipe = "Copas";
	    else if (random.nextInt(4) == 1)
		naipe = "Ouros";
	    else if (random.nextInt(4) == 2)
		naipe = "Paus";
	    else if (random.nextInt(4) == 3)
		naipe = "Espadas";

	    System.out.println(Arrays.toString(jogador.getMao()));

	    Cartas novaCarta = new Cartas(2 + (random.nextInt(14)), naipe);
	    jogador.getMao()[escolhida - 1] = novaCarta;

	    System.out.println(Arrays.toString(jogador.getMao()));
	    System.out.println();
	    System.out.println("Carta trocada com sucesso!\nContinuando...");
	    System.out.println();
	}
    }

    public void trocarCartaComputador(Jogador computador, int quantidadeTrocar, int escolhida) { // MÉTODO PARA O
												 // JOGADOR TROCAR
												 // CARTA CASO QUEIRA

	if (quantidadeTrocar < 1)
	    System.out.println(computador.getNome() + " não trocou nenhuma carta!\nContinuando...");

	for (int i = 0; i < quantidadeTrocar; i++) {

	    escolhida = 1 + random.nextInt(5);

	    String naipe = "Copas";

	    if (random.nextInt(4) == 0)
		naipe = "Copas";
	    else if (random.nextInt(4) == 1)
		naipe = "Ouros";
	    else if (random.nextInt(4) == 2)
		naipe = "Paus";
	    else if (random.nextInt(4) == 3)
		naipe = "Espadas";

	    Cartas novaCarta = new Cartas(2 + (random.nextInt(14)), naipe);
	    computador.getMao()[escolhida - 1] = novaCarta;
	}
	System.out.println("Cartas de " + computador.getNome() + " trocadas com sucesso.");
    }

    public void ordenarMao(Jogador jogador) { // ORDENA A MÃO (EM ORDEM CRESCENTE) PARA FICAR MAIS FÁCIL DE ANALISAR OS
					      // JOGOS POSSÍVEIS

	int temp = 0;

	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		if (jogador.getMao()[i].getValorCarta() > jogador.getMao()[j].getValorCarta()) {
		    temp = jogador.getMao()[i].getValorCarta();
		    jogador.getMao()[i].setValorCarta(jogador.getMao()[j].getValorCarta());
		    jogador.getMao()[j].setValorCarta(temp);
		}
	    }
	}
    }

    public int pontuacaoMaoJogadores(Jogador jogador) { // COMPARA MÃO DOS JOGADORES COM OS JOGOS POSSÍVEIS E RETORNA UM
							// INTEIRO PARA DEPOIS COMPARAR AS MÃOS DOS JOGADORES

	if (jogador != null && checarRoyalFlush(jogador) == true)
	    return 9;
	else if (checarStraightFlush(jogador) == true)
	    return 8;
	else if (checarQuadra(jogador) == true)
	    return 7;
	else if (checarFullHouse(jogador) == true)
	    return 6;
	else if (checarFlush(jogador) == true)
	    return 5;
	else if (checarSequencia(jogador) == true)
	    return 4;
	else if (checarTrinca(jogador) == true)
	    return 3;
	else if (checarDoisPares(jogador) == true)
	    return 2;
	else if (checarPar(jogador) == true)
	    return 1;

	else if (jogador.getApostaAtual() == 0)
	    return -1;

	else
	    return 0;
    }

    public Jogador[] compararCartaMaisAlta(Jogador[] jogadores) {
	return null;
    }

    public int quantidadeFichasAposta(int blind, int jogadaAnterior) { // GERA DE FORMA ALEATÓRIA SE O COMPUTADOR VAI
								       // DAR FOLD OU APOSTAR
	blind = 10;
	int numAleatorio = random.nextInt(2);

	if (numAleatorio == 0)
	    return 0;

	else if (numAleatorio == 1) {

	    if (jogadaAnterior == 0)
		return blind * (random.nextInt(20));

	    else if (jogadaAnterior > 0) {
		blind = jogadaAnterior;

		if (blind < 200)
		    return blind * (random.nextInt(20));
		else
		    return 200;
	    }
	}

	return 0;
    }

    public boolean checarRoyalFlush(Jogador jogador) {
	if (jogador != null && jogador.getMao()[0].getValorCarta() == 10 && jogador.getMao()[1].getValorCarta() == 11
		&& jogador.getMao()[2].getValorCarta() == 12 && jogador.getMao()[3].getValorCarta() == 13
		&& jogador.getMao()[4].getValorCarta() == 14 && checarFlush(jogador) == true)
	    return true;
	return false;
    }

    public boolean checarStraightFlush(Jogador jogador) {
	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		if (checarSequencia(jogador) == false
			|| jogador.getMao()[j].getNaipe() != jogador.getMao()[i].getNaipe())
		    return false;
	    }
	}
	return true;
    }

    public boolean checarQuadra(Jogador jogador) {
	if (jogador.getMao()[0].getValorCarta() == jogador.getMao()[1].getValorCarta()
		&& jogador.getMao()[1].getValorCarta() == jogador.getMao()[2].getValorCarta()
		&& jogador.getMao()[2].getValorCarta() == jogador.getMao()[3].getValorCarta()
		|| jogador.getMao()[1].getValorCarta() == jogador.getMao()[2].getValorCarta()
			&& jogador.getMao()[2].getValorCarta() == jogador.getMao()[3].getValorCarta()
			&& jogador.getMao()[3].getValorCarta() == jogador.getMao()[4].getValorCarta())
	    return true;
	return false;

    }

    public boolean checarFullHouse(Jogador jogador) {
	if (jogador.getMao()[0].getValorCarta() == jogador.getMao()[1].getValorCarta()
		&& jogador.getMao()[2].getValorCarta() == jogador.getMao()[3].getValorCarta()
		&& jogador.getMao()[2].getValorCarta() == jogador.getMao()[4].getValorCarta()
		&& jogador.getMao()[4].getValorCarta() != jogador.getMao()[0].getValorCarta()
		|| jogador.getMao()[3].getValorCarta() == jogador.getMao()[4].getValorCarta()
			&& jogador.getMao()[0].getValorCarta() == jogador.getMao()[1].getValorCarta()
			&& jogador.getMao()[0].getValorCarta() == jogador.getMao()[2].getValorCarta()
			&& jogador.getMao()[2].getValorCarta() != jogador.getMao()[4].getValorCarta())
	    return true;
	return false;
    }

    public boolean checarFlush(Jogador jogador) {
	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		if (jogador.getMao()[j].getNaipe() != jogador.getMao()[i].getNaipe())
		    return false;
	    }
	}
	return true;
    }

    public boolean checarSequencia(Jogador jogador) {
	if (jogador.getMao()[0].getValorCarta() == (jogador.getMao()[1].getValorCarta() - 1)
		&& jogador.getMao()[1].getValorCarta() == (jogador.getMao()[2].getValorCarta() - 1)
		&& jogador.getMao()[2].getValorCarta() == (jogador.getMao()[3].getValorCarta() - 1)
		&& jogador.getMao()[3].getValorCarta() == (jogador.getMao()[4].getValorCarta() - 1))
	    return true;
	return false;
    }

    public boolean checarTrinca(Jogador jogador) {
	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		for (int k = j + 1; k < jogador.getMao().length; k++) {
		    if (jogador.getMao()[i].getValorCarta() == jogador.getMao()[j].getValorCarta()
			    && jogador.getMao()[i].getValorCarta() == jogador.getMao()[k].getValorCarta())
			return true;
		}
	    }
	}
	return false;
    }

    public boolean checarDoisPares(Jogador jogador) {
	int numPares = 0;
	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		if (jogador.getMao()[i].getValorCarta() == jogador.getMao()[j].getValorCarta()) {
		    numPares++;
		}
		if (numPares == 2)
		    return true;

	    }
	}
	return false;
    }

    public boolean checarPar(Jogador jogador) {
	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		if (jogador.getMao()[i].getValorCarta() == jogador.getMao()[j].getValorCarta()) {
		    return true;
		}
	    }
	}
	return false;
    }

    public int checarParMaior(Jogador jogador) {
	int numPar = 0;
	for (int i = 0; i < jogador.getMao().length; i++) {
	    for (int j = i + 1; j < jogador.getMao().length; j++) {
		if (jogador.getMao()[i].getValorCarta() == jogador.getMao()[j].getValorCarta()) {
		    numPar = jogador.getMao()[i].getValorCarta();
		    break;
		}
	    }
	}
	return numPar;
    }

    public int checarCartaAlta(Jogador jogador) {
	int cartaAlta = 0;
	for (int i = 0; i < jogador.getMao().length; i++) {
	    if (jogador.getMao()[i].getValorCarta() > cartaAlta)
		cartaAlta = jogador.getMao()[i].getValorCarta();
	}
	return cartaAlta;
    }
}