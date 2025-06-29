package Jogodetabuleiro;

public abstract class JogadorGeral {
    public String nome;
    public String cor;
    public int posicao = 0;
    public int moedas = 0;
    public int jogadas = 0;
    public boolean jogadaExtra = false;

    public boolean pularRodada = false;
    public boolean reverso = false;
    public boolean temNovaJogada = false;
    public boolean derrotado = false;
    public boolean devePularProximaRodada = false;

    public JogadorGeral(String nome) {
        this.nome = nome;
        this. posicao = 0;
        this.jogadas = 0;
        this.moedas = 0;
        this.devePularProximaRodada = false;
        this.jogadaExtra = false;
        this.cor = nome;

        
    }

    public abstract int[] jogarDados();

    @Override
    public String toString() {
        return cor + " - " + getClass().getSimpleName()
                + "| Posição: " + posicao
                + "| Jogadas: " + jogadas
                + "| Moedas: " + moedas;
    }
}