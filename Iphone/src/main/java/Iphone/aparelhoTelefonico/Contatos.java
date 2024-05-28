package Iphone.aparelhoTelefonico;

public class Contatos {
    public enum Contato {
        AMIGO("Fernanda", "123456789"),
        FAMILIAR("Henrique", "987654321"),
        TRABALHO("Matheus", "555555555");

        private final String nome;
        private final String numero;

        Contato(String nome, String numero) {
            this.nome = nome;
            this.numero = numero;
        }

        public String getNome() {
            return nome;
        }

        public String getNumero() {
            return numero;
        }
    }
}
