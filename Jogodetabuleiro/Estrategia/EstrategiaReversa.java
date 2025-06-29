package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

public class EstrategiaReversa implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        jogador.reverso = !jogador.reverso;
        System.out.println(jogador.cor + " teve a direção invertida! Agora ele anda para trás.");
    }
}
