package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

public class EstrategiaAzar implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        jogador.posicao -= 2;
        if (jogador.posicao < 0) jogador.posicao = 0;
        System.out.println(jogador.cor + " teve azar e voltou 2 casas.");
    }
}
