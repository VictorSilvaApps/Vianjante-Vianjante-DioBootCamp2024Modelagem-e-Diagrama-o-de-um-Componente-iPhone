package Iphone.reprodutorMusical;

import java.util.Scanner;

public class Reprodutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldExit = false;
        boolean isPlaying = false;
        Musica currentMusic = null;

        while (!shouldExit) {
            if (!isPlaying) {
                System.out.println("Escolha uma música para tocar:");
                System.out.println("1. Garota de Ipanema");
                System.out.println("2. Águas de Março");
                System.out.println("3. Construção");
                System.out.println("4. Sair");
                System.out.println("5. Pausar música");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                switch (choice) {
                    case 1:
                        currentMusic = Musica.GAROTA_DE_IPANEMA;
                        playMusic(currentMusic);
                        isPlaying = true;
                        break;
                    case 2:
                        currentMusic = Musica.AGUAS_DE_MARCO;
                        playMusic(currentMusic);
                        isPlaying = true;
                        break;
                    case 3:
                        currentMusic = Musica.CONSTRUCAO;
                        playMusic(currentMusic);
                        isPlaying = true;
                        break;
                    case 4:
                        shouldExit = true;
                        break;
                    case 5:
                        System.out.println("Música pausada.");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                }
            } else {
                System.out.println("1. Continuar música");
                System.out.println("2. Pausar música");
                System.out.println("3. Voltar ao menu");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                switch (choice) {
                    case 1:
                        System.out.println("Continuando a música \"" + currentMusic.getName() + "\"");
                        break;
                    case 2:
                        System.out.println("Música pausada.");
                        break;
                    case 3:
                        isPlaying = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                }
            }
        }
    }

    public static void playMusic(Musica music) {
        System.out.println("Tocando a música \"" + music.getName() + "\"");
    }

}
