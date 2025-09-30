package com.fum.fundamentos;

public class Cliente {
    private String nome;
    private String email;
    private Bicicleta bicicletaComprada;

    public Cliente(String nome) {
        this(nome, null);
    }

    public Cliente(String nome, String email) {
        this.nome = (nome != null) ? nome : "Cliente sem nome";
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public Bicicleta getBicicletaComprada() { return bicicletaComprada; }
    public void setBicicletaComprada(Bicicleta bicicletaComprada) { this.bicicletaComprada = bicicletaComprada; }

    @Override
    public String toString() {
        return "Cliente{" +
               "nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               ", bicicletaComprada=" + bicicletaComprada +
               '}';
    }
}
