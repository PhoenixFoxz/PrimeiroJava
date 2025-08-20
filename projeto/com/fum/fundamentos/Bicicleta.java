package com.fum.fundamentos;

import java.math.BigDecimal;

// Classe que representa uma Bicicleta com seus atributos básicos
public class Bicicleta {
    String cor;
    int marcha;
    int velocidade;
    BigDecimal valor;
    
    @Override
    public String toString() {
        return "Bicicleta [cor=" + cor +
               ", velocidade=" + velocidade +
               ", marcha=" + marcha +
               ", valor=" + valor + "]";
    }

    public static void main(String[] args) {
        // Criando uma instância da classe Bicicleta
        Bicicleta bicicleta1 = new Bicicleta();

        // Atribuindo valores aos atributos
        bicicleta1.cor = "Azul";
        bicicleta1.velocidade = 0;
        bicicleta1.marcha = 1;
        bicicleta1.valor = new BigDecimal("799.99");

        // Imprimindo o estado do objeto usando o método toString()
        System.out.println("Detalhes da Bicicleta 1:");
        System.out.println(bicicleta1);

        System.out.println("----------------------------");

        // Criando a segunda instância
        Bicicleta bicicleta2 = new Bicicleta();

        // Atribuindo valores aos atributos
        bicicleta2.cor = "Vermelha";
        bicicleta2.velocidade = 15;
        bicicleta2.marcha = 18;
        bicicleta2.valor = new BigDecimal("1450.50");

        System.out.println("Detalhes da Bicicleta 2:");
        System.out.println(bicicleta2);
        
    }
}