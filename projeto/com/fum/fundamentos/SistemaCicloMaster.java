package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.EnumSet;

public class SistemaCicloMaster {
    public static void main(String[] args) {
        // Criar quadro
        Quadro quadroCarbono = new Quadro("Carbono", 19);

        // Criar bicicletas
        Bicicleta bike1 = new Bicicleta("Vermelha", new BigDecimal("2500.00"), quadroCarbono,
                "Estrada", 28, 100);
        bike1.setRecursos(EnumSet.of(RecursoExtra.FAROL, RecursoExtra.BUZINA));

        Bicicleta bike2 = new Bicicleta("Azul", new BigDecimal("1800.00"));
        bike2.setRecursos(EnumSet.of(RecursoExtra.CESTA));

        // Criar loja e adicionar bicicletas
        Loja loja = new Loja("CicloMaster");
        loja.adicionarBicicleta(bike1);
        loja.adicionarBicicleta(bike2);

        // Criar cliente
        Cliente cliente = new Cliente("Felipe", "felipe@email.com");

        // Realizar venda
        loja.venderBicicleta(cliente, bike1);

        // Oficina revisando bicicleta do cliente
        Oficina oficina = new Oficina();
        oficina.revisarBicicleta(cliente.getBicicletaComprada());

        // Ciclista com sua bicicleta
        Ciclista ciclista = new Ciclista("Ashley", 25, cliente.getBicicletaComprada());
        ciclista.pedalar();
        ciclista.frear();

        // Listar estoque da loja após venda
        loja.listarEstoque();
    }
}
