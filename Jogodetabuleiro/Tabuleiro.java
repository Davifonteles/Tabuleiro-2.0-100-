package Jogodetabuleiro;

import java.util.*;
import Jogodetabuleiro.Estrategia.*;

public class Tabuleiro {
    private static Tabuleiro instancia;

    private List<JogadorGeral> jogadores;
    private List<CasaGeral> casas;
    private boolean debug = false;

    private Tabuleiro(List<JogadorGeral> jogadores, List<CasaGeral> casas) {
        this.jogadores = jogadores;
        this.casas = casas;
    }

    public static Tabuleiro getInstance(List<JogadorGeral> jogadores, List<CasaGeral> casas) {
        if (instancia == null) {
            instancia = new Tabuleiro(jogadores, casas);
        } else {
            instancia.jogadores = jogadores;
            instancia.casas = casas;
        }
        return instancia;
    }

    public static Tabuleiro getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("O tabuleiro ainda não foi inicializado.");
        }
        return instancia;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private CasaGeral encontrarCasa(int numero) {
        for (CasaGeral c : casas) {
            if (c.getNumero() == numero)
                return c;
        }
        return null;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;
        JogadorGeral vencedor = null;

        while (jogoAtivo) {
            for (JogadorGeral jogador : jogadores) {
                if (jogador.derrotado) {
                    System.out.println(jogador.cor + " está eliminado e não joga mais.");
                    continue;
                }

                if (jogador.devePularProximaRodada) {
                    System.out.println(jogador.cor + " está pulando esta rodada.");
                    jogador.devePularProximaRodada = false;
                    continue;
                }

                boolean jogadaExtra = true;
                while (jogadaExtra) {
                    jogadaExtra = false;
                    int movimento;

                    if (debug) {
                        System.out.print("DEBUG - Digite a casa para onde " + jogador.cor + " deve ir: ");
                        int destino = scanner.nextInt();
                        movimento = destino - jogador.posicao;
                    } else {
                        int[] dados = jogador.jogarDados();
                        int soma = dados[0];
                        int dado1 = dados[1];
                        int dado2 = dados[2];

                        String detalhe = "";

                        if (jogador instanceof JogadorSortudo) {
                            if (dado1 + dado2 < 7) {
                                detalhe = ", ajustado para 7";
                            } else {
                                detalhe = ", +1 por sorte = " + soma;
                            }
                        } else if (jogador instanceof JogadorAzarado) {
                            if (dado1 + dado2 > 6) {
                                detalhe = ", ajustado para 6";
                            }
                        }

                        System.out.println(jogador.cor + " tirou " + dado1 + " e " + dado2 + " (total: "
                                + (dado1 + dado2) + detalhe + ")");

                        if (dado1 == dado2) {
                            System.out.println(jogador.cor + " tirou dois dados IGUAIS e vai jogar novamente");
                            jogadaExtra = true;
                        }

                        movimento = soma;
                    }

                    jogador.posicao += movimento;
                    jogador.jogadas++;

                    CasaGeral casa = encontrarCasa(jogador.posicao);
                    if (casa != null) {
                        casa.aplicarRegra(jogador, this);
                    } else {
                        System.out.println(jogador.cor + " caiu em uma CASA NORMAL e ganhou 1 moeda!");
                        jogador.moedas++;
                    }

                    if (jogador.jogadaExtra) {
                        jogadaExtra = true;
                        jogador.jogadaExtra = false;
                    }

                    if (jogador.posicao >= casas.size() - 1) {
                        vencedor = jogador;
                        System.out.println("\nVENCEDOR: " + jogador.cor + "!\n");
                        jogoAtivo = false;
                        break;
                    }
                }
                if (!jogoAtivo)
                    break;
            }

            System.out.println("\n== POSIÇÃO ATUAL DOS JOGADORES ==");
            for (JogadorGeral j : jogadores) {
                System.out.println(j);
            }
            System.out.println("----------------------------------\n");
        }

        System.out.println("\n== RESUMO FINAL ==");
        for (JogadorGeral j : jogadores) {
            System.out.println(j);
        }

        if (vencedor != null) {
            System.out.println("Parabéns você venceu: " + vencedor.cor);
        } else {
            System.out.println("\n Nenhum vencedor definido.");
        }

        scanner.close();

    }

    public JogadorGeral getJogadorMaisAtrasadoExceto(JogadorGeral exceto) {
        JogadorGeral ultimo = null;
        for (JogadorGeral j : jogadores) {
            if (j != exceto) {
                if (ultimo == null || j.posicao < ultimo.posicao) {
                    ultimo = j;
                }
            }
        }
        return ultimo;
    }

    public void substituirJogador(JogadorGeral antigo, JogadorGeral novoJogador) {
        int index = jogadores.indexOf(antigo);
        jogadores.set(index, novoJogador);
    }
}
