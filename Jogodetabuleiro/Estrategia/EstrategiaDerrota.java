package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

public class EstrategiaDerrota implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        jogador.derrotado = true;
        System.out.println(jogador.cor + " caiu em uma casa de DERROTA e está fora do jogo!");
    }
}
