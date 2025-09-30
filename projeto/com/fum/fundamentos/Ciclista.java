package com.fum.fundamentos;

public class Ciclista {
    private String nome;
    private int idade;
    private Bicicleta bicicleta;

    public Ciclista(String nome, int idade, Bicicleta bicicleta) {
        this.nome = (nome != null) ? nome : "Ciclista sem nome";
        this.idade = idade;
        this.bicicleta = bicicleta;
    }

    public void pedalar() {
        if (bicicleta == null) {
            System.out.println(nome + " não tem bicicleta para pedalar.");
            return;
        }
        System.out.println(nome + " começou a pedalar.");
        bicicleta.iniciarMonitoramentoViagem();
        bicicleta.acelerar(10);
        bicicleta.acelerar(15);
        bicicleta.mudarMarcha(3);
    }

    public void frear() {
        if (bicicleta == null) {
            System.out.println(nome + " não tem bicicleta para frear.");
            return;
        }
        System.out.println(nome + " freando.");
        bicicleta.frear(8);
        // soltar freio depois da frenagem
        bicicleta.getFreio().liberar();
    }

    @Override
    public String toString() {
        return "Ciclista{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", bicicleta=" + bicicleta +
               '}';
    }
}
