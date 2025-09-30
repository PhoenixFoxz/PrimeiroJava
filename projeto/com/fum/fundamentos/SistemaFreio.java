package com.fum.fundamentos;

public class SistemaFreio {
    private String tipo;       // Ex: "Disco", "V-Brake"
    private String material;   // Ex: "Aço", "Carbono"
    private boolean ligado;    // true = freio acionado, false = solto

    // Construtor padrão
    public SistemaFreio() {
        this("Disco", "Aço");
    }

    // Construtor completo
    public SistemaFreio(String tipo, String material) {
        this.tipo = (tipo != null) ? tipo : "Desconhecido";
        this.material = (material != null) ? material : "Desconhecido";
        this.ligado = false; // começa desligado (não freando)
    }

    // Novo padrão: ligar/desligar
    public void ligar() {
        ligado = true;
        System.out.println("Sistema de Freio LIGADO (" + tipo + ", " + material + ")");
    }

    public void desligar() {
        ligado = false;
        System.out.println("Sistema de Freio DESLIGADO");
    }

    // Compatibilidade com código antigo (acionar/liberar)
    public void acionar() {
        ligar();
    }

    public void liberar() {
        desligar();
    }

    public boolean isLigado() {
        return ligado;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "SistemaFreio{" +
                "tipo='" + tipo + '\'' +
                ", material='" + material + '\'' +
                ", ligado=" + ligado +
                '}';
    }
}
