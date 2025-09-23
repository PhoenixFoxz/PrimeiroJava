package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SistemaLojaPolimorfica {

    public static void main(String[] args) {
        System.out.println("--- Gerenciando Estoque com Polimorfismo ---");

        // Criando uma lista que pode armazenar qualquer tipo de Bicicleta
        List<Bicicleta> estoqueLoja = new ArrayList<>();

        // Adicionando diferentes tipos de bicicletas
        Bicicleta bikeComum = new Bicicleta(
            "Azul", new BigDecimal("1200.00"),
            new Quadro("Alumínio", 18),
            "Urbano", 26, 40
        );
        bikeComum.setRecursos(EnumSet.of(RecursoExtra.CESTA));
        estoqueLoja.add(bikeComum);

        BicicletaEletrica bikeEletrica = new BicicletaEletrica(
            "Preta", new BigDecimal("4500.00"),
            new Quadro("Carbono", 19),
            "Híbrido", 28, 60,
            250, 500
        );
        estoqueLoja.add(bikeEletrica);

        BicicletaDeCarga bikeCarga = new BicicletaDeCarga(
            "Verde Escuro", new BigDecimal("3000.00"),
            new Quadro("Aço Reforçado", 20),
            "Carga", 24, 50,
            150.0, "Madeira" // 150 kg de capacidade de carga
        );
        estoqueLoja.add(bikeCarga);
        
        System.out.println("\n--- Exibindo e Testando todas as Bicicletas no Estoque ---");
        for (Bicicleta bike : estoqueLoja) {
            System.out.println("\n========================================");
            System.out.println("Tipo: " + bike.getClass().getSimpleName()); // Mostra o tipo real
            System.out.println(bike);

            bike.acelerar(20); // Chama o método acelerar() apropriado para cada tipo!

            // Podemos interagir com métodos específicos usando instanceof e downcasting
            if (bike instanceof BicicletaEletrica) {
                BicicletaEletrica be = (BicicletaEletrica) bike;
                be.ativarMotor();
                be.acelerar(10); // Acelera com motor
                be.desativarMotor();
            } else if (bike instanceof BicicletaDeCarga) {
                BicicletaDeCarga bc = (BicicletaDeCarga) bike;
                bc.carregarCarga(50);
                bc.acelerar(15); // Acelera com carga
            }
        }
        System.out.println("\n--- Fim da Demonstração --- ");
    }
}
