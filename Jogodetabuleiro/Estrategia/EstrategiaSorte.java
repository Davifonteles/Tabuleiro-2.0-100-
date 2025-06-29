package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.*;

public class EstrategiaSorte implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        if (!(jogador instanceof JogadorAzarado)) {
            jogador.posicao += 3;
            System.out.println(jogador.cor + " teve sorte e andou 3 casas!");
        } else {
            System.out.println(jogador.cor + " é azarado e não teve sorte.");
        }
    }
}
