package com.fum.fundamentos;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private List<Bicicleta> estoque;

    public Loja(String nome) {
        this.nome = (nome != null) ? nome : "Loja sem nome";
        this.estoque = new ArrayList<>();
    }

    public void adicionarBicicleta(Bicicleta bicicleta) {
        if (bicicleta == null) {
            System.out.println("Impossível adicionar: bicicleta é nula.");
            return;
        }
        estoque.add(bicicleta);
        System.out.println("Bicicleta adicionada ao estoque: " + bicicleta.getCor());
    }

    /**
     * Vende a instância exata de Bicicleta ao cliente (remover por identidade).
     * Retorna true se a venda foi realizada.
     */
    public boolean venderBicicleta(Cliente cliente, Bicicleta bicicleta) {
        if (cliente == null) {
            System.out.println("Cliente inválido (nulo).");
            return false;
        }
        if (bicicleta == null) {
            System.out.println("Bicicleta inválida (nula).");
            return false;
        }

        // Procura por identidade para evitar remover outra bicicleta com os mesmos atributos
        int idx = -1;
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i) == bicicleta) {
                idx = i;
                break;
            }
        }

        if (idx >= 0) {
            Bicicleta vendida = estoque.remove(idx);
            cliente.setBicicletaComprada(vendida);
            System.out.println("Venda realizada para o cliente " + cliente.getNome() + ". Bicicleta: " + vendida.getCor());
            return true;
        } else {
            System.out.println("Bicicleta não disponível no estoque.");
            return false;
        }
    }

    public void listarEstoque() {
        System.out.println("Estoque da loja " + nome + ":");
        if (estoque.isEmpty()) {
            System.out.println("  (estoque vazio)");
            return;
        }
        for (Bicicleta bicicleta : estoque) {
            System.out.println(" - " + bicicleta);
        }
    }

    public List<Bicicleta> getEstoque() {
        return new ArrayList<>(estoque); // cópia defensiva
    }

    public String getNome() { return nome; }
}
