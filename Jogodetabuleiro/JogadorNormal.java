package Jogodetabuleiro;

import java.util.Random;

public class JogadorNormal extends JogadorGeral {
    public JogadorNormal(String cor) {
        super(cor);
    }

    @Override
    public int[] jogarDados() {
        Random rand = new Random();
        int dado1 = rand.nextInt(6) + 1;
        int dado2 = rand.nextInt(6) + 1;
        int soma = dado1 + dado2;

    if (dado1 == dado2) {
        temNovaJogada = true;
    }

    return new int[]{soma, dado1, dado2};
    }
}