package com.fum.fundamentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Bicicleta> minhasBicicletas; // Agregação 1:N

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.minhasBicicletas = new ArrayList<>();
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public List<Bicicleta> getMinhasBicicletas() { return minhasBicicletas; }

    // Comportamentos
    public void comprarBicicleta(Bicicleta bike) {
        if (bike != null) {
            this.minhasBicicletas.add(bike);
            System.out.println(this.nome + " comprou a bicicleta: " + bike.getCor());
        } else {
            System.out.println("Não foi possível comprar uma bicicleta nula.");
        }
    }

    public void listarMinhasBicicletas() {
        if (minhasBicicletas.isEmpty()) {
            System.out.println(this.nome + " não possui bicicletas.");
            return;
        }
        System.out.println("\n--- Bicicletas de " + this.nome + " ---");
        for (Bicicleta bike : minhasBicicletas) {
            System.out.println("  - " + bike);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", numBicicletas=" + minhasBicicletas.size() +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf); // CPF como identificador único
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
