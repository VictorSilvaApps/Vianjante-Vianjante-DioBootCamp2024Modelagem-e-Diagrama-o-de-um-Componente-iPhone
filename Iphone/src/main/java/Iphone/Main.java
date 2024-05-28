package Iphone;
import java.util.Scanner;

import Iphone.aparelhoTelefonico.Telefone;
import Iphone.navegadorNaInternet.Navegador;
import Iphone.reprodutorMusical.Reprodutor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
   boolean app = false;
    while (!app) {
        
   Scanner scanner = new Scanner(System.in);
    System.out.println("Olá, selecione uma das opções a seguir: ");
    System.out.println("1- Reprodutor de música");
    System.out.println("2- Aparelho eletronico");
    System.out.println("3- Navegador na internet");
   Integer opcao = scanner.nextInt();
   switch (opcao) {
    case 1:
        Reprodutor.main(args);
        break;
    case 2:
        Telefone.main(args);
        break;
    case 3:
        Navegador.main(args);
        break;
    default:
    System.out.println("Opção invalida!");
        break;
   }
   }
  }
}
