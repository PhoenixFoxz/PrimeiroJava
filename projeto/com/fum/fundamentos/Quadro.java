package com.fum.fundamentos;

public class Quadro {
    private String material;
    private int tamanho;

    public Quadro(String material, int tamanho) {
        this.material = material;
        this.tamanho = tamanho;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public int getTamanho() { return tamanho; }
    public void setTamanho(int tamanho) { this.tamanho = tamanho; }

    @Override
    public String toString() {
        return "[Material: " + material + ", Tamanho: " + tamanho + "]";
    }
}
