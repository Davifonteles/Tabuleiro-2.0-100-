package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

public class EstrategiaJogaDeNovo implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        jogador.temNovaJogada = true;
        System.out.println(jogador.cor + " ganhou uma nova jogada!");
    }
}
