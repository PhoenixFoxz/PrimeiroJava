package com.fum.fundamentos;

import java.math.BigDecimal;

public class SistemaComposicao {
    public static void main(String[] args) {
        System.out.println("=== Demonstração de Composição com Bicicleta e Computador de Bordo ===");

        // Usando o construtor cor + valor (compatível com a Bicicleta da base)
        Bicicleta bike = new Bicicleta("Preta", new BigDecimal("1200.00"));
        bike.iniciarMonitoramentoViagem();
        bike.acelerar(10);
        bike.acelerar(5);
        bike.frear(3);
        bike.pararMonitoramentoViagem();

        System.out.println(bike);
        bike.exibirDadosViagem();

        bike.destruirBicicleta();
        System.out.println("Bicicleta destruída: " + bike);
    }
}
