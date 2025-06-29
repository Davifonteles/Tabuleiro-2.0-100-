package Jogodetabuleiro.Fabrica;

import Jogodetabuleiro.*;

public class FabricaJogador {

    public static JogadorGeral criarJogador(String nome, int tipo) {
        switch (tipo) {
            case 1:
                return new JogadorNormal(nome);
            case 2:
                return new JogadorSortudo(nome);
            case 3:
                return new JogadorAzarado(nome);
            default:
                System.out.println("Tipo inválido. Jogador será Normal por padrão.");
                return new JogadorNormal(nome);
        }
    }
}
    

