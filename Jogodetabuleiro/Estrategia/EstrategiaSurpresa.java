package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

import java.util.Random;

public class EstrategiaSurpresa implements EstrategiaCasa {
    @Override
    public void executar(JogadorGeral jogador, Tabuleiro tabuleiro) {
        Random rand = new Random();
        int valor = rand.nextInt(7) - 3; // valor aleatório entre -3 e +3
        jogador.posicao += valor;

        if (valor > 0) {
            System.out.println(jogador.cor + " teve uma surpresa positiva e avançou " + valor + " casas!");
        } else if (valor < 0) {
            System.out.println(jogador.cor + " teve uma surpresa negativa e voltou " + (-valor) + " casas!");
        } else {
            System.out.println(jogador.cor + " teve uma surpresa neutra e ficou na mesma posição!");
        }
    }
}
