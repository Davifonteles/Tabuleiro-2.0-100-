package Jogodetabuleiro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jogo jogo = new Jogo();

        System.out.print("Digite o número de casas do tabuleiro: ");
        int numCasas = scanner.nextInt();

        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();
        scanner.nextLine();

        jogo.configTabuleiro(numCasas);
        jogo.config(numJogadores);
        jogo.printTabuleiro();
        jogo.start();

        scanner.close();
    }
}


