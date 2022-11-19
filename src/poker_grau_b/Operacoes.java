package poker_grau_b;

import java.util.Random;

public class Operacoes {
	
	public Cartas[] geraMao() {
		Random random = new Random();
		
		String[] cartasMaoNumeroConv = new String[5];

		for(int i = 0; i < cartasMaoNumeroConv.length; i++) {
			int cartasMaoNumero = 1 + random.nextInt(14);
			
			if(cartasMaoNumero == 1)
				cartasMaoNumeroConv[i] = "1";
			if(cartasMaoNumero == 2)
				cartasMaoNumeroConv[i] = "2";
			if(cartasMaoNumero == 3)
				cartasMaoNumeroConv[i] = "3";
			if(cartasMaoNumero == 4)
				cartasMaoNumeroConv[i] = "4";
			if(cartasMaoNumero == 5)
				cartasMaoNumeroConv[i] = "5";
			if(cartasMaoNumero == 6)
				cartasMaoNumeroConv[i] = "6";
			if(cartasMaoNumero == 7)
				cartasMaoNumeroConv[i] = "7";
			if(cartasMaoNumero == 8)
				cartasMaoNumeroConv[i] = "8";
			if(cartasMaoNumero == 9)
				cartasMaoNumeroConv[i] = "9";
			if(cartasMaoNumero == 10)
				cartasMaoNumeroConv[i] = "10";
			if(cartasMaoNumero == 11)
				cartasMaoNumeroConv[i] = "J";
			if(cartasMaoNumero == 12)
				cartasMaoNumeroConv[i] = "Q";
			if(cartasMaoNumero == 13)
				cartasMaoNumeroConv[i] = "K";
			if(cartasMaoNumero == 14)
				cartasMaoNumeroConv[i] = "A";	
		}
	
		String[] cartasMaoNaipe = new String[5];
		
		for(int i = 0; i < cartasMaoNaipe.length; i++) {
			int numParaNaipe = 1 + random.nextInt(4);
			
			if(numParaNaipe == 1)
				cartasMaoNaipe[i] = "Copas";
			if(numParaNaipe == 2)
				cartasMaoNaipe[i] = "Ouros";
			if(numParaNaipe == 3)
				cartasMaoNaipe[i] = "Paus";
			if(numParaNaipe == 4)
				cartasMaoNaipe[i] = "Espadas";
		}
		
		System.out.println("Sua mão:");
		
		String mao;
		for(int i = 0; i < 5; i++)
			mao = cartasMaoNumeroConv[i] + " de " + cartasMaoNaipe[i]);
		return mao;
	}
	
	public void trocarCarta(Cartas primeira, Cartas segunda) {
		Cartas temp = primeira;
		primeira = segunda;
		segunda = temp;
	}
	
	public void embaralhar(Cartas[] cartasUsadas) {
		Random random = new Random();
		for (int i=0; i < (cartasUsadas.length - 1); i++) {
			int j = random.nextInt(cartasUsadas.length);
			Cartas temp = cartasUsadas[i];
			cartasUsadas[i] = cartasUsadas[j];
			cartasUsadas[j] = temp;
		}
	}
	
	public void descartarCarta() {
		
	}
}
