package com.fum.fundamentos;

import java.util.Objects;

public class Pneu {
    private String tipo; // Ex: "Estrada", "Mountain Bike", "Urbano"
    private int diametroPolegadas;
    private int calibragemMaxPsi;

    public Pneu(String tipo, int diametroPolegadas, int calibragemMaxPsi) {
        this.tipo = tipo;
        this.diametroPolegadas = diametroPolegadas;
        this.calibragemMaxPsi = calibragemMaxPsi;
    }

    // Getters
    public String getTipo() { return tipo; }
    public int getDiametroPolegadas() { return diametroPolegadas; }
    public int getCalibragemMaxPsi() { return calibragemMaxPsi; }

    // Setters
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setDiametroPolegadas(int diametroPolegadas) { this.diametroPolegadas = diametroPolegadas; }
    public void setCalibragemMaxPsi(int calibragemMaxPsi) { this.calibragemMaxPsi = calibragemMaxPsi; }

    @Override
    public String toString() {
        return "Pneu{" +
               "tipo='" + tipo + '\'' +
               ", diametro=" + diametroPolegadas + "''" +
               ", calibragemMax=" + calibragemMaxPsi + "psi" +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pneu pneu = (Pneu) o;
        return diametroPolegadas == pneu.diametroPolegadas &&
               calibragemMaxPsi == pneu.calibragemMaxPsi &&
               Objects.equals(tipo, pneu.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, diametroPolegadas, calibragemMaxPsi);
    }
}
