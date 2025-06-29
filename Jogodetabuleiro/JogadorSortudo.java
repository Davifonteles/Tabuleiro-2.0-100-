package Jogodetabuleiro;

import java.util.Random;

public class JogadorSortudo extends JogadorGeral {
    public JogadorSortudo(String cor) {
        super(cor);
    }

    @Override
    public int[] jogarDados() {
        Random rand = new Random();
        int dado1 = rand.nextInt(6) + 1;
        int dado2 = rand.nextInt(6) + 1;
        int soma = dado1 + dado2;

        if (soma < 7) {
            soma = 7;
        } else {
            soma += 1;
        }

        return new int[]{soma, dado1, dado2};
    }
}
