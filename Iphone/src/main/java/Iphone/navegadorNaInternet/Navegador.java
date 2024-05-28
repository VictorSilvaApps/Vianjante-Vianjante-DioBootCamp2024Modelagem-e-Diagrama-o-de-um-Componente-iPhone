package Iphone.navegadorNaInternet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navegador {
    private List<String> abas;
    private int abaAtual;
    private Scanner scanner;

    public Navegador() {
        this.abas = new ArrayList<>();
        this.abaAtual = -1; // Nenhuma aba aberta no início
        this.scanner = new Scanner(System.in);
    }

    public void exibirPagina(String url) {
        if (abaAtual != -1) {
            System.out.println("Exibindo página: " + url);
            abas.set(abaAtual, url);
            voltarMenu();
        } else {
            System.out.println("Nenhuma aba aberta. Adicione uma nova aba.");
            voltarMenu();
        }
    }

    public void adicionarNovaAba() {
        abas.add("");
        abaAtual = abas.size() - 1;
        System.out.println("Nova aba adicionada. Aba atual: " + (abaAtual + 1));
        voltarMenu();
    }

    public void atualizarPagina() {
        if (abaAtual != -1) {
            String url = abas.get(abaAtual);
            System.out.println("Atualizando página: " + url);
            voltarMenu();
        } else {
            System.out.println("Nenhuma aba aberta. Adicione uma nova aba.");
            voltarMenu();
        }
    }

    public void fecharNavegador() {
        System.out.println("Fechando navegador.");
    }

    public void voltarMenu() {
        System.out.println("Deseja voltar ao menu principal?");
        System.out.println("1. Sim");
        System.out.println("2. Fechar Navegador");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                menu();
                break;
            case 2:
                fecharNavegador();
                break;
            default:
                System.out.println("Opção inválida. O navegador será fechado.");
                fecharNavegador();
        }
    }

    public void menu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Exibir Página");
            System.out.println("2. Adicionar Nova Aba");
            System.out.println("3. Atualizar Página");
            System.out.println("4. Fechar Navegador");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    if (abaAtual != -1) {
                        System.out.println("Digite a URL:");
                        String url = scanner.nextLine();
                        exibirPagina(url);
                    } else {
                        System.out.println("Nenhuma aba aberta. Adicione uma nova aba.");
                        voltarMenu();
                    }
                    break;
                case 2:
                    adicionarNovaAba();
                    break;
                case 3:
                    atualizarPagina();
                    break;
                case 4:
                    fecharNavegador();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }

    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        navegador.menu();
    }
}