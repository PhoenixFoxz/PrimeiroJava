package com.fum.fundamentos;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private List<Bicicleta> estoque;

    public Loja(String nome) {
        this.nome = nome;
        this.estoque = new ArrayList<>();
    }

    public void adicionarBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            estoque.add(bicicleta);
            System.out.println("Bicicleta adicionada ao estoque: " + bicicleta.getCor());
        }
    }

    public void venderBicicleta(Cliente cliente, Bicicleta bicicleta) {
        if (estoque.contains(bicicleta)) {
            estoque.remove(bicicleta);
            cliente.setBicicletaComprada(bicicleta);
            System.out.println("Venda realizada para o cliente " + cliente.getNome());
        } else {
            System.out.println("Bicicleta não disponível no estoque.");
        }
    }

    public void listarEstoque() {
        System.out.println("Estoque da loja " + nome + ":");
        for (Bicicleta bicicleta : estoque) {
            System.out.println(bicicleta);
        }
    }
}
