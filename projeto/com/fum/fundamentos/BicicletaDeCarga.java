package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.EnumSet;

public class BicicletaDeCarga extends Bicicleta {
    private double capacidadeCargaKg;
    private String plataformaCargaMaterial;

    public BicicletaDeCarga(String cor, BigDecimal valor, Quadro quadro,
                            String tipoPneu, int diametroPneu, int calibragemPneu,
                            double capacidadeCargaKg, String plataformaCargaMaterial) {
        super(cor, valor, quadro, tipoPneu, diametroPneu, calibragemPneu);
        this.capacidadeCargaKg = capacidadeCargaKg;
        this.plataformaCargaMaterial = plataformaCargaMaterial;

        // Bicicletas de carga geralmente vêm com bagageiro e talvez para-lama
        EnumSet<RecursoExtra> recursosAtuais = getRecursos();
        if (!recursosAtuais.contains(RecursoExtra.BAGAGEIRO)) {
            recursosAtuais.add(RecursoExtra.BAGAGEIRO);
        }
        if (!recursosAtuais.contains(RecursoExtra.PARALAMA)) {
            recursosAtuais.add(RecursoExtra.PARALAMA);
        }
        setRecursos(recursosAtuais);
    }

    // Getters específicos da BicicletaDeCarga
    public double getCapacidadeCargaKg() { return capacidadeCargaKg; }
    public String getPlataformaCargaMaterial() { return plataformaCargaMaterial; }

    // Métodos específicos
    public void carregarCarga(double peso) {
        if (peso > 0 && peso <= capacidadeCargaKg) {
            System.out.println("Carregando " + peso + " kg na bicicleta de carga.");
        } else {
            System.out.println("Peso " + peso + " kg excede a capacidade de carga ou é inválido.");
        }
    }

    public void descarregarCarga() {
        System.out.println("Descarrregando carga da bicicleta de carga.");
    }

    // Sobrescrita do método acelerar()
    @Override
    public void acelerar(int incremento) {
        System.out.print("Bicicleta de Carga: ");
        // Acelera mais lentamente devido ao peso potencial
        super.acelerar(incremento / 2); // Apenas metade do incremento efetivo
        System.out.println("  (Devido à sua natureza, acelera mais devagar.)");
    }

    // Sobrescrita do toString()
    @Override
    public String toString() {
        return super.toString().replace("}", ", capacidadeCarga=" + capacidadeCargaKg + "kg" +
                                            ", plataforma=" + plataformaCargaMaterial +
                                            '}');
    }
}
