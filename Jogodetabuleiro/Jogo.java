package Jogodetabuleiro;

import Jogodetabuleiro.Fabrica.FabricaCasa;
import Jogodetabuleiro.Fabrica.FabricaJogador;
import Jogodetabuleiro.Estrategia.CasaComEstrategia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<JogadorGeral> jogadores;
    private List<CasaGeral> casas;
    private Tabuleiro tabuleiro;

    public void configTabuleiro(int qtdCasas) {
        casas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < qtdCasas; i++) {
            casas.add(FabricaCasa.criarCasa(i, 0));
        }

        System.out.print("Deseja adicionar casas especiais? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        while (resposta.equals("s")) {
            System.out.print("Digite o número da casa especial (0 a " + (qtdCasas - 1) + "): ");
            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero < 0 || numero >= qtdCasas) {
                System.out.println("Número inválido.");
                continue;
            }

            System.out.println("Tipos de casas especiais:");
            System.out.println("1 - Sorte | 2 - Prisão | 3 - Surpresa | 4 - Reversa");
            System.out.println("5 - Azar  | 6 - Joga de Novo | 7 - Derrota");
            System.out.print("Escolha o tipo da casa (número ou nome): ");
            String tipoStr = scanner.nextLine().trim().toLowerCase();

            int tipoCasa;
            switch (tipoStr) {
                case "1", "sorte"        -> tipoCasa = 1;
                case "2", "prisao"       -> tipoCasa = 2;
                case "3", "surpresa"     -> tipoCasa = 3;
                case "4", "reversa"      -> tipoCasa = 4;
                case "5", "azar"         -> tipoCasa = 5;
                case "6", "joga de novo" -> tipoCasa = 6;
                case "7", "derrota"      -> tipoCasa = 7;
                default -> {
                    System.out.println("Tipo inválido, usando Sorte como padrão.");
                    tipoCasa = 1;
                }
            }

            CasaGeral novaCasa = FabricaCasa.criarCasa(numero, tipoCasa);
            casas.set(numero, novaCasa);

            System.out.print("Deseja adicionar outra casa especial? (s/n): ");
            resposta = scanner.nextLine().trim().toLowerCase();
        }
    }

    public void config(int qtdJogadores) {
        jogadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < qtdJogadores; i++) {
            System.out.println("Jogador " + (i + 1));
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("1 - Normal | 2 - Sortudo | 3 - Azarado");
            System.out.print("Escolha o tipo (número ou nome): ");
            String tipoStr = scanner.nextLine().trim().toLowerCase();

            int tipo;
            switch (tipoStr) {
                case "1", "normal"   -> tipo = 1;
                case "2", "sortudo"  -> tipo = 2;
                case "3", "azarado"  -> tipo = 3;
                default -> {
                    System.out.println("Tipo inválido, usando Normal como padrão.");
                    tipo = 1;
                }
            }

            JogadorGeral jogador = FabricaJogador.criarJogador(nome, tipo);
            jogadores.add(jogador);
        }

        tabuleiro = Tabuleiro.getInstance(jogadores, casas);
    }

    public void printTabuleiro() {
    System.out.println("\n== Casas do Tabuleiro ==");
    for (CasaGeral casa : casas) {
        if (casa instanceof CasaComEstrategia estrategia) {
            String tipo = estrategia.getEstrategia().getClass().getSimpleName().replace("Estrategia", "");

            if (tipo.equalsIgnoreCase("Simples")) {
                System.out.println("Casa " + casa.getNumero() + ": Simples");
            } else {
                System.out.println("Casa " + casa.getNumero() + ": Especial (" + tipo + ")");
            }
        } else {
            System.out.println("Casa " + casa.getNumero() + ": Simples");
        }
    }
    System.out.println("=========================\n");
}

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ativar modo DEBUG? (s/n): ");
        String modoDebug = scanner.nextLine().trim().toLowerCase();
        boolean debugAtivo = modoDebug.equals("s") || modoDebug.equals("sim");
        tabuleiro.setDebug(debugAtivo);
        tabuleiro.iniciar();
    }
}
