package poker_grau_b;

public class Principal {
	public static void main(String[] args) {

		Operacoes op = new Operacoes();

		Jogador jogador1 = new Jogador(null, 0, 0, null);
		
		op.geraMao();
		
		jogador1.setCartasJogador(op.geraMao());
	}
}
