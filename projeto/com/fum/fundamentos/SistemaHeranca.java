package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SistemaHeranca {

    public static void main(String[] args) {
        System.out.println("--- Demonstração de Herança em Java ---");

        // --- 1. Instanciando a Superclasse (Bicicleta) ---
        System.out.println("\n### Instância da Superclasse (Bicicleta Comum) ###");
        Bicicleta bikeComum = new Bicicleta(
            "Amarela", new BigDecimal("1200.00"),
            new Quadro("Aço", 17),
            "Urbano", 26, 40
        );
        bikeComum.setRecursos(EnumSet.of(RecursoExtra.CESTA, RecursoExtra.PARALAMA));
        System.out.println(bikeComum);
        bikeComum.acelerar(10);
        bikeComum.mudarMarcha(3);
        bikeComum.frear(5);

        // --- 2. Instanciando a Subclasse (BicicletaEletrica) ---
        System.out.println("\n### Instância da Subclasse (Bicicleta Elétrica) ###");
        BicicletaEletrica bikeEletrica = new BicicletaEletrica(
            "Preta Fosca", new BigDecimal("4500.00"),
            new Quadro("Alumínio Leve", 19),
            "Híbrido", 28, 60,
            250, 500 // Potência do motor e capacidade da bateria
        );
        System.out.println(bikeEletrica);

        // Métodos herdados da Superclasse Bicicleta
        bikeEletrica.mudarMarcha(7); // Herdado
        System.out.println("Cor da bike elétrica: " + bikeEletrica.getCor()); // Herdado

        // Métodos específicos da Subclasse BicicletaEletrica
        bikeEletrica.carregarBateria();
        bikeEletrica.ativarMotor();
        bikeEletrica.acelerar(15); // Método sobrescrito
        bikeEletrica.desativarMotor();
        bikeEletrica.acelerar(10); // Acelera sem o boost do motor

        // --- 3. Demonstração de Polimorfismo ---
        System.out.println("\n### Demonstração de Polimorfismo ###");
        List<Bicicleta> veiculos = new ArrayList<>();
        veiculos.add(bikeComum);
        veiculos.add(bikeEletrica); // Uma BicicletaEletrica é também uma Bicicleta!

        System.out.println("\nPercorrendo uma lista de Bicicletas (polimorfismo):");
        for (Bicicleta b : veiculos) {
            System.out.println("--------------------------------");
            System.out.println("Tipo: " + b.getClass().getSimpleName()); // Mostra o tipo real do objeto
            System.out.println("Cor: " + b.getCor() + ", Valor: " + b.getValor());
            b.acelerar(5); // Chama o 'acelerar' apropriado para o tipo real do objeto
            if (b instanceof BicicletaEletrica) { // Verificando o tipo real para usar métodos específicos
                BicicletaEletrica be = (BicicletaEletrica) b; // Downcasting seguro
                be.ativarMotor();
                be.acelerar(5);
                be.desativarMotor();
            }
        }
        System.out.println("--------------------------------");
    }
}
