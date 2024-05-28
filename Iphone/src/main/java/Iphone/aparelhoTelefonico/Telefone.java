package Iphone.aparelhoTelefonico;

import java.util.Scanner;



public class Telefone {
    private boolean ligacaoAtiva = false;
    private Scanner scanner;

    public Telefone() {
        this.scanner = new Scanner(System.in);
    }

    public void ligar(String numero) {
        if (!ligacaoAtiva) {
            System.out.println("Chamando " + numero);
            ligacaoAtiva = true;
            realizarChamada();
        } else {
            System.out.println("Você já está em uma ligação. Encerre a ligação atual para fazer uma nova chamada.");
        }
    }

    public void ligar(Contatos.Contato contato) {
        ligar(contato.getNumero());
    }

    private void realizarChamada() {
        System.out.println("Pressione 1 para encerrar a chamada.");
        while (ligacaoAtiva) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                encerrarChamada();
            } else {
                System.out.println("Opção inválida. Pressione 1 para encerrar a chamada.");
            }
        }
    }

    private void encerrarChamada() {
        System.out.println("Chamada encerrada.");
        ligacaoAtiva = false;
    }

    public void atender() {
        if (ligacaoAtiva) {
            System.out.println("Ligação atendida.");
            ligacaoAtiva = false;
        } else {
            System.out.println("Não há nenhuma ligação para atender.");
        }
    }

    public void iniciarCorreioVoz() {
        if (ligacaoAtiva) {
            System.out.println("Iniciando correio de voz...");
            ligacaoAtiva = false;
        } else {
            System.out.println("Não há nenhuma ligação para iniciar o correio de voz.");
        }
    }

    public static void main(String[] args) {
        Telefone telefone = new Telefone();
        Contatos.Contato[] contatos = Contatos.Contato.values();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Ligar");
            System.out.println("2. Ligar para um contato");
            System.out.println("3. Atender");
            System.out.println("4. Iniciar Correio de Voz");
            if (telefone.ligacaoAtiva) {
                System.out.println("5. Encerrar Chamada");
            }
            System.out.println("6. Encerrar Aplicação");

            String opcao = telefone.scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite o número para ligar:");
                    String numero = telefone.scanner.nextLine();
                    telefone.ligar(numero);
                    break;
                case "2":
                    System.out.println("Escolha um contato:");
                    for (int i = 0; i < contatos.length; i++) {
                        System.out.println((i + 1) + ". " + contatos[i].getNome());
                    }
                    int escolha = Integer.parseInt(telefone.scanner.nextLine());
                    if (escolha >= 1 && escolha <= contatos.length) {
                        telefone.ligar(contatos[escolha - 1]);
                    } else {
                        System.out.println("Opção inválida. Escolha novamente.");
                    }
                    break;
                case "3":
                    telefone.atender();
                    break;
                case "4":
                    telefone.iniciarCorreioVoz();
                    break;
                case "5":
                    if (telefone.ligacaoAtiva) {
                        telefone.encerrarChamada();
                    } else {
                        System.out.println("Opção inválida. Escolha novamente.");
                    }
                    break;
                case "6":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }

    
    }
}