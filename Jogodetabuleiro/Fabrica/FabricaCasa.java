package Jogodetabuleiro.Fabrica;

import Jogodetabuleiro.*;
import Jogodetabuleiro.Estrategia.*;

public class FabricaCasa {

    public static CasaGeral criarCasa(int numero, int tipoCasa) {
        switch (tipoCasa) {
            case 0: // Casa Simples
                return new CasaComEstrategia(numero, new EstrategiaSimples());
            case 1:
                return new CasaComEstrategia(numero, new EstrategiaSorte());
            case 2:
                return new CasaComEstrategia(numero, new EstrategiaPrisao());
            case 3:
                return new CasaComEstrategia(numero, new EstrategiaSurpresa());
            case 4:
                return new CasaComEstrategia(numero, new EstrategiaReversa());
            case 5:
                return new CasaComEstrategia(numero, new EstrategiaAzar());
            case 6:
                return new CasaComEstrategia(numero, new EstrategiaJogaDeNovo());
            case 7:
                return new CasaComEstrategia(numero, new EstrategiaDerrota());
            default:
                System.out.println("Tipo de casa inválido. Será criada como CasaSimples (via Strategy).");
                return new CasaComEstrategia(numero, (jogador, tabuleiro) -> {
                    jogador.moedas++;
                    System.out.println(jogador.cor + " caiu numa casa simples e ganhou 1 moeda!");
                });
        }
    }
}
