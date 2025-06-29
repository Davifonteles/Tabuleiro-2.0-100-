package Jogodetabuleiro;

public class JogadorAzarado extends JogadorGeral {
    public JogadorAzarado(String cor) {
        super(cor);
    }

    @Override
    public int[] jogarDados() {
        int dado1 = (int)(Math.random() * 6) + 1;
        int dado2 = (int)(Math.random() * 6) + 1;

        int soma = Math.max(2, dado1 + dado2 - 1);
        System.out.println(cor + " tirou " + dado1 + " e " + dado2 + " (total: " + (dado1 + dado2) + ", -1 por azar = " + soma + ")");

        if (dado1 == dado2) {
            temNovaJogada = true;
            System.out.println(cor + " tirou dois dados IGUAIS e vai jogar novamente");
        }

        return new int[] {soma, dado1, dado2};
    }
}