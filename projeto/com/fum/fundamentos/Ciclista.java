package com.fum.fundamentos;

import java.util.Objects;

public class Ciclista {
    private String nome;
    private int idade;
    private Bicicleta bicicleta;

    public Ciclista(String nome, int idade, Bicicleta bicicleta) {
        this.nome = nome;
        this.idade = idade;
        this.bicicleta = bicicleta;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) {
        if (idade > 0) this.idade = idade;
    }

    public Bicicleta getBicicleta() { return bicicleta; }
    public void setBicicleta(Bicicleta bicicleta) { this.bicicleta = bicicleta; }

    // Métodos
    public void pedalar() {
        if (bicicleta != null) {
            bicicleta.acelerar(5);
            System.out.println(nome + " está pedalando!");
        }
    }

    public void frear() {
        if (bicicleta != null) {
            bicicleta.frear(3);
            System.out.println(nome + " está freando!");
        }
    }

    @Override
    public String toString() {
        return "Ciclista{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", bicicleta=" + bicicleta +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ciclista)) return false;
        Ciclista ciclista = (Ciclista) o;
        return idade == ciclista.idade && Objects.equals(nome, ciclista.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
