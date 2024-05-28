package Iphone.reprodutorMusical;

public enum Musica {

    GAROTA_DE_IPANEMA("Garota de Ipanema"),
    AGUAS_DE_MARCO("Águas de Março"),
    CONSTRUCAO("Construção");

    private String name;

    Musica(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
