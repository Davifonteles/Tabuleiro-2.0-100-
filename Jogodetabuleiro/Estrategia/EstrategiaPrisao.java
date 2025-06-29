package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

public class EstrategiaPrisao implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        jogador.pularRodada = true;
        System.out.println(jogador.cor + " foi preso e perderá a próxima rodada!");
    }
}
