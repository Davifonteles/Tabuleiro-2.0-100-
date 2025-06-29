package Jogodetabuleiro.Estrategia;

import Jogodetabuleiro.CasaGeral;
import Jogodetabuleiro.JogadorGeral;
import Jogodetabuleiro.Tabuleiro;

public class CasaComEstrategia extends CasaGeral {

    private EstrategiaCasa estrategia;

    public CasaComEstrategia(int numero, EstrategiaCasa estrategia) {
        super(numero);
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarRegra(JogadorGeral jogador, Tabuleiro tabuleiro) {
        estrategia.executar(jogador, tabuleiro);
    }

    public EstrategiaCasa getEstrategia(){
        return estrategia;
    }
}
