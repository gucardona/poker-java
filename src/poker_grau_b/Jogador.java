package poker_grau_b;

public class Jogador {
	private String nome;
	private int quantidadeFichas;
	private int apostaAtual;
	private Operacoes op;
	
	public int consultaFichas() {
		return quantidadeFichas;
	}
	
	public void apostar(int aposta) {
		int qntFichasAntes = quantidadeFichas;
		quantidadeFichas -= apostaAtual;
		System.out.println("Você tinha " + qntFichasAntes + " fichas");
		System.out.println("Você apostou " + aposta + " fichas");
		System.out.println("Você tem " + quantidadeFichas + " fichas");
	}
	
	public Jogador(String nome, int quantidadeFichas, int apostaAtual, Operacoes op) {
		this.nome = nome;
		this.quantidadeFichas = quantidadeFichas;
		this.apostaAtual = apostaAtual;
		this.op = op;
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
	
	public Operacoes getOp() {
		return op;
	}

	public void setOp(Operacoes op) {
		this.op = op;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", quantidadeFichas=" + quantidadeFichas + ", apostaAtual=" + apostaAtual + "]";
	}
}
