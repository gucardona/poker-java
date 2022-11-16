package poker_grau_b;

public class Jogador {
	private String nome;
	private int quantidadeFichas;
	private int apostaAtual;
	private Mao mao;
	
	public int consultaFichas() {
		return quantidadeFichas;
	}
	
	public int apostar(int aposta) {
		return apostaAtual;
	}

	public Jogador(String nome, int quantidadeFichas, int apostaAtual, Mao mao) {
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

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}
}
