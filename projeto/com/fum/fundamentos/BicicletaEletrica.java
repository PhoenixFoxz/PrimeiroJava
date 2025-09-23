package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.EnumSet;

public class BicicletaEletrica extends Bicicleta { // Herda de Bicicleta
    private int potenciaMotorWatts;
    private int capacidadeBateriaWh; // Watt-hora
    private boolean motorAtivo;

    // Construtor completo para BicicletaEletrica
    public BicicletaEletrica(String cor, BigDecimal valor, Quadro quadro,
                             String tipoPneu, int diametroPneu, int calibragemPneu,
                             int potenciaMotorWatts, int capacidadeBateriaWh) {
        // Chama o construtor da superclasse (Bicicleta)
        super(cor, valor, quadro, tipoPneu, diametroPneu, calibragemPneu);
        
        this.potenciaMotorWatts = potenciaMotorWatts;
        this.capacidadeBateriaWh = capacidadeBateriaWh;
        this.motorAtivo = false; // Motor inicia desativado por padrão
        
        // Bicicletas elétricas podem ter recursos adicionais específicos
        // Ex: adiciona FAROL e BUZINA se não tiverem, pois são importantes para bikes elétricas.
        EnumSet<RecursoExtra> recursosAtuais = getRecursos();
        if (!recursosAtuais.contains(RecursoExtra.FAROL)) {
            recursosAtuais.add(RecursoExtra.FAROL);
        }
        if (!recursosAtuais.contains(RecursoExtra.BUZINA)) {
            recursosAtuais.add(RecursoExtra.BUZINA);
        }
        setRecursos(recursosAtuais);
    }

    // Getters específicos da BicicletaEletrica
    public int getPotenciaMotorWatts() { return potenciaMotorWatts; }
    public int getCapacidadeBateriaWh() { return capacidadeBateriaWh; }
    public boolean isMotorAtivo() { return motorAtivo; }

    // Métodos específicos da BicicletaEletrica
    public void ativarMotor() {
        if (!motorAtivo) {
            this.motorAtivo = true;
            System.out.println("Motor elétrico ativado! Potência: " + potenciaMotorWatts + "W");
        } else {
            System.out.println("Motor já está ativo.");
        }
    }

    public void desativarMotor() {
        if (motorAtivo) {
            this.motorAtivo = false;
            System.out.println("Motor elétrico desativado.");
        } else {
            System.out.println("Motor já está desativado.");
        }
    }

    public void carregarBateria() {
        System.out.println("Carregando bateria de " + capacidadeBateriaWh + "Wh...");
        // Lógica real de carregamento (tempo, percentual) poderia ser implementada aqui
        System.out.println("Bateria carregada!");
    }

    // Sobrescrita do método acelerar() para adicionar o efeito do motor
    @Override
    public void acelerar(int incremento) {
        System.out.print("Bicicleta Elétrica: ");
        // Chama o método acelerar da superclasse (Bicicleta)
        super.acelerar(incremento); 
        if (motorAtivo) {
            // Se o motor está ativo, adiciona um "boost" extra
            int boost = potenciaMotorWatts / 100; // Boost proporcional à potência
            setVelocidade(getVelocidade() + boost); // Aumenta a velocidade usando o setter da superclasse
            System.out.println("  (Com assistência do motor, velocidade final: " + getVelocidade() + " km/h)");
        }
    }

    // Sobrescrita do método toString() para incluir detalhes elétricos
    @Override
    public String toString() {
        // Chama o toString da superclasse e adiciona informações específicas
        return super.toString().replace("}", ", potenciaMotor=" + potenciaMotorWatts + "W" +
                                            ", capacidadeBateria=" + capacidadeBateriaWh + "Wh" +
                                            ", motorAtivo=" + motorAtivo +
                                            '}');
    }
}
