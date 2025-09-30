package com.fum.fundamentos;

public class ComputadorDeBordo {
    private double odometroKm;
    private double tempoViagemMinutos;
    private double velocidadeMediaKmH;
    private boolean estaRegistrando;

    public ComputadorDeBordo() {
        this.odometroKm = 0.0;
        this.tempoViagemMinutos = 0.0;
        this.velocidadeMediaKmH = 0.0;
        this.estaRegistrando = false;
        System.out.println("Computador de Bordo inicializado.");
    }

    // Getters
    public double getOdometroKm() { return odometroKm; }
    public double getTempoViagemMinutos() { return tempoViagemMinutos; }
    public double getVelocidadeMediaKmH() { return velocidadeMediaKmH; }
    public boolean isEstaRegistrando() { return estaRegistrando; }

    public void iniciarRegistro() {
        if (!estaRegistrando) {
            this.estaRegistrando = true;
            System.out.println("Computador de Bordo: Iniciando registro de viagem.");
        } else {
            System.out.println("Computador de Bordo: Já está registrando.");
        }
    }

    public void pararRegistro() {
        if (estaRegistrando) {
            this.estaRegistrando = false;
            System.out.println("Computador de Bordo: Registro de viagem parado.");
        } else {
            System.out.println("Computador de Bordo: Não há registro ativo para parar.");
        }
    }

    /**
     * Atualiza dados do computador por distância percorrida (km) e tempo (minutos).
     * Ex.: atualizarDados(0.5, 1.0) -> +0.5 km e +1 min.
     */
    public void atualizarDados(double distanciaKm, double deltaTempoMinutos) {
        if (estaRegistrando) {
            this.tempoViagemMinutos += deltaTempoMinutos;
            this.odometroKm += distanciaKm;
            if (this.tempoViagemMinutos > 0) {
                this.velocidadeMediaKmH = (this.odometroKm / this.tempoViagemMinutos) * 60.0;
            } else {
                this.velocidadeMediaKmH = 0.0;
            }
        }
    }

    public void resetarDados() {
        this.odometroKm = 0.0;
        this.tempoViagemMinutos = 0.0;
        this.velocidadeMediaKmH = 0.0;
        this.estaRegistrando = false;
        System.out.println("Computador de Bordo: Dados resetados.");
    }

    @Override
    public String toString() {
        return "ComputadorDeBordo{" +
               "odometro=" + String.format("%.2f", odometroKm) + " km" +
               ", tempoViagem=" + String.format("%.1f", tempoViagemMinutos) + " min" +
               ", velocidadeMedia=" + String.format("%.2f", velocidadeMediaKmH) + " km/h" +
               ", registrando=" + estaRegistrando +
               '}';
    }
}
