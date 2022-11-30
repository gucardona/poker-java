package poker_grau_b;

//GUSTAVO PARCIANELLO CARDONA

public class Jogador {
    private String nome;
    private int quantidadeFichas;
    private int apostaAtual;
    Cartas[] mao;

    public int consultaFichas() {
	return quantidadeFichas;
    }

    public void apostar(int aposta) {
	int qntFichasAntes = quantidadeFichas;

	if (aposta > quantidadeFichas) {
	    aposta = quantidadeFichas;
	    System.out.println(nome + " apostou todas as fichas.");
	}

	else if (aposta == 0)
	    System.out.println(nome + " deu fold e estÃ¡ fora da rodada.");

	else
	    System.out.println(nome + " tinha " + qntFichasAntes + " e apostou " + aposta + " fichas.");

	quantidadeFichas -= aposta;
    }

    public Jogador(String nome, int quantidadeFichas, int apostaAtual, Cartas[] mao) {
	this.nome = nome;
	this.quantidadeFichas = quantidadeFichas;
	this.apostaAtual = apostaAtual;
	this.mao = mao;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public int getQuantidadeFichas() {
	return quantidadeFichas;
    }

    public void setQuantidadeFichas(int quantidadeFichas) {
	this.quantidadeFichas = quantidadeFichas;
    }

    public int getApostaAtual() {
	return apostaAtual;
    }

    public void setApostaAtual(int apostaAtual) {
	this.apostaAtual = apostaAtual;
    }

    public Cartas[] getMao() {
	return mao;
    }

    public void setMao(Cartas[] mao) {
	this.mao = mao;
    }

    @Override
    public String toString() {
	return ("\nNome do jogador: " + nome + "\nQuantidade de fichas: " + quantidadeFichas + " fichas"
		+ "\nAposta atual: " + apostaAtual + " fichas");
    }
}
