package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        // Criando bicicletas
        Bicicleta bike1 = new Bicicleta("Vermelha", new BigDecimal("1200.00"));
        Bicicleta bike2 = new Bicicleta("Azul", new BigDecimal("1500.00"));
        Bicicleta bike3 = new Bicicleta("Preta", new BigDecimal("1800.00"));

        // Adicionando alguns recursos extras
        bike1.setRecursos(EnumSet.of(RecursoExtra.FAROL, RecursoExtra.BUZINA));
        bike2.setRecursos(EnumSet.of(RecursoExtra.CESTA));
        bike3.setRecursos(EnumSet.of(RecursoExtra.BAGAGEIRO));

        System.out.println("\n--- Testando aceleração ---");
        bike1.acelerar(10);
        bike2.acelerar(5);
        bike3.acelerar(20);

        System.out.println("\n--- Testando frenagem ---");
        bike1.frear(3);
        bike2.frear(2);
        bike3.frear(5);

        System.out.println("\n--- Testando mudança de marcha ---");
        bike1.mudarMarcha(3);
        bike2.mudarMarcha(5);
        bike3.mudarMarcha(7);

        System.out.println("\n--- Estados finais das bicicletas ---");
        System.out.println(bike1);
        System.out.println(bike2);
        System.out.println(bike3);
    }
}
