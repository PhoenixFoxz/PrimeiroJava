package com.fum.fundamentos;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Objects;

public class Bicicleta {
    private String cor;
    private int velocidade;
    private int marcha;
    private BigDecimal valor;
    private EnumSet<RecursoExtra> recursos;
    private Quadro quadro;
    private Pneu pneuDianteiro;
    private Pneu pneuTraseiro;

    // Componentes via composição
    private ComputadorDeBordo computador;
    private SistemaFreio freio;

    // Construtores
    public Bicicleta() {
        this.velocidade = 0;
        this.marcha = 1;
        this.valor = BigDecimal.ZERO;
        this.cor = "Não Definida";
        this.recursos = EnumSet.noneOf(RecursoExtra.class);
        this.quadro = new Quadro("Alumínio", 18);
        this.pneuDianteiro = new Pneu("Urbano", 26, 40);
        this.pneuTraseiro = new Pneu("Urbano", 26, 40);

        this.computador = new ComputadorDeBordo();
        this.freio = new SistemaFreio();
    }

    public Bicicleta(String cor, BigDecimal valor) {
        this();
        this.cor = cor;
        if (valor != null && valor.compareTo(BigDecimal.ZERO) >= 0) {
            this.valor = valor;
        } else {
            System.out.println("Valor inválido. Usando zero.");
            this.valor = BigDecimal.ZERO;
        }
    }

    public Bicicleta(String cor, BigDecimal valor, Quadro quadro) {
        this(cor, valor);
        if (quadro != null) this.quadro = quadro;
    }

    public Bicicleta(String cor, BigDecimal valor, Quadro quadro,
                     String tipoPneu, int diametroPneu, int calibragemPneu) {
        this(cor, valor, quadro);
        this.pneuDianteiro = new Pneu(tipoPneu, diametroPneu, calibragemPneu);
        this.pneuTraseiro = new Pneu(tipoPneu, diametroPneu, calibragemPneu);
    }

    // Getters e Setters
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public int getVelocidade() { return velocidade; }
    public void setVelocidade(int velocidade) { if (velocidade >= 0) this.velocidade = velocidade; }

    public int getMarcha() { return marcha; }
    public void setMarcha(int marcha) { if (marcha >= 1 && marcha <= 21) this.marcha = marcha; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { if (valor != null && valor.compareTo(BigDecimal.ZERO) >= 0) this.valor = valor; }

    public EnumSet<RecursoExtra> getRecursos() { return recursos; }
    public void setRecursos(EnumSet<RecursoExtra> recursos) { this.recursos = (recursos != null) ? recursos : EnumSet.noneOf(RecursoExtra.class); }

    public Quadro getQuadro() { return quadro; }
    public void setQuadro(Quadro quadro) { if (quadro != null) this.quadro = quadro; }

    public Pneu getPneuDianteiro() { return pneuDianteiro; }
    public void setPneuDianteiro(Pneu pneuDianteiro) { this.pneuDianteiro = pneuDianteiro; }

    public Pneu getPneuTraseiro() { return pneuTraseiro; }
    public void setPneuTraseiro(Pneu pneuTraseiro) { this.pneuTraseiro = pneuTraseiro; }

    public ComputadorDeBordo getComputador() { return computador; }
    public SistemaFreio getFreio() { return freio; }

    // Métodos de comportamento
    public void acelerar(int incremento) {
        if (incremento > 0) {
            this.velocidade += incremento;
            System.out.println(">>> Acelerando... Nova velocidade: " + this.velocidade + " km/h");
            computador.atualizarDados(incremento * 0.05, 1.0);
        } else {
            System.out.println("O incremento de velocidade deve ser positivo.");
        }
    }

    public void frear(int decremento) {
        if (decremento > 0) {
            this.velocidade = Math.max(0, this.velocidade - decremento);
            System.out.println(">>> Freando... Nova velocidade: " + this.velocidade + " km/h");
            freio.acionar();
            computador.atualizarDados(0.0, 1.0);
        } else {
            System.out.println("O decremento de velocidade deve ser positivo.");
        }
    }

    public void mudarMarcha(int novaMarcha) {
        setMarcha(novaMarcha);
        System.out.println(">>> Marcha alterada para: " + this.marcha);
    }

    // Métodos delegados ao computador de bordo
    public void iniciarMonitoramentoViagem() { computador.iniciarRegistro(); }
    public void pararMonitoramentoViagem() { computador.pararRegistro(); }
    public void exibirDadosViagem() { System.out.println(computador); }

    public void destruirBicicleta() {
        System.out.println("Destruindo a bicicleta " + this.cor + "...");
        this.quadro = null;
        this.recursos = null;
        this.pneuDianteiro = null;
        this.pneuTraseiro = null;
        this.computador = null;
        this.freio = null;
        System.out.println("Componentes desassociados.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Bicicleta ===\n");
        sb.append("Cor: ").append(cor).append("\n");
        sb.append("Velocidade: ").append(velocidade).append(" km/h\n");
        sb.append("Marcha: ").append(marcha).append("\n");
        sb.append("Valor: R$ ").append(valor).append("\n");

        sb.append("Quadro: ").append(quadro != null ? quadro : "Indefinido").append("\n");
        sb.append("Pneu Dianteiro: ").append(pneuDianteiro != null ? pneuDianteiro : "Indefinido").append("\n");
        sb.append("Pneu Traseiro: ").append(pneuTraseiro != null ? pneuTraseiro : "Indefinido").append("\n");

        sb.append("Recursos Extras: ").append(
            (recursos != null && !recursos.isEmpty()) ? recursos : "Nenhum"
        ).append("\n");

        sb.append("Computador de Bordo: ").append(
            computador != null ? computador : "Não disponível"
        ).append("\n");

        sb.append("Sistema de Freio: ").append(
            freio != null ? freio : "Não disponível"
        ).append("\n");

        sb.append("=================\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicicleta)) return false;
        Bicicleta that = (Bicicleta) o;
        return Objects.equals(cor, that.cor) && valor.compareTo(that.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor, valor);
    }
}
