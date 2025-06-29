package Jogodetabuleiro;

public abstract class CasaGeral {
    protected int numero;

    public CasaGeral(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public abstract void aplicarRegra(JogadorGeral jogador, Tabuleiro tabuleiro);
}
