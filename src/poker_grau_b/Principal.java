package poker_grau_b;

public class Principal {
	public static void main(String[] args) {

		Operacoes op = new Operacoes();

		Jogador jogador1 = new Jogador(Teclado.leString("Qual o seu nome? "), 0, 0, op);
		
		System.out.println("Cartas de " + jogador1.getNome());
		jogador1.getOp().geraMao();
		
	}
}
