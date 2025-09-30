package com.fum.fundamentos;

public class SistemaFreio {
    private String tipo;     // ex: "Disco", "V-Brake"
    private String material; // exemplo
    private boolean ativo;

    public SistemaFreio() {
        this("Disco", "Aço");
    }

    public SistemaFreio(String tipo, String material) {
        this.tipo = (tipo != null) ? tipo : "Desconhecido";
        this.material = (material != null) ? material : "Desconhecido";
        this.ativo = false;
    }

    // Métodos solicitados no exercício
    public void acionar() {
        this.ativo = true;
        System.out.println("Sistema de Freio: ACIONADO (" + tipo + ", " + material + ")");
    }

    public void liberar() {
        this.ativo = false;
        System.out.println("Sistema de Freio: LIBERADO");
    }

    public boolean verificarStatus() {
        return this.ativo;
    }

    // Alias por compatibilidade
    public void acionarFreio() { acionar(); }
    public void soltarFreio() { liberar(); }

    @Override
    public String toString() {
        return "SistemaFreio{tipo='" + tipo + "', material='" + material + "', ativo=" + ativo + "}";
    }
}
