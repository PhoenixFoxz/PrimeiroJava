package com.fum.fundamentos;

public class Quadro {
    private String material;
    private int tamanho; // em polegadas

    public Quadro(String material, int tamanho) {
        this.material = material;
        this.tamanho = tamanho;
    }

    // Getters
    public String getMaterial() { return material; }
    public int getTamanho() { return tamanho; }

    // Setters
    public void setMaterial(String material) { this.material = material; }
    public void setTamanho(int tamanho) { this.tamanho = tamanho; }

    @Override
    public String toString() {
        return "Quadro{" +
               "material='" + material + '\'' +
               ", tamanho=" + tamanho + "''" +
               '}';
    }
}
