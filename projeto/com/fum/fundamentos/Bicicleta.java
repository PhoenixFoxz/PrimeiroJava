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

    // Componentes via composição (Aula 8)
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
            System.out.println("Acelerando... Nova velocidade: " + this.velocidade + " km/h");
            // Simulação simples: converte incremento em distância (ex.: 0.05 km por unidade)
            computador.atualizarDados(incremento * 0.05, 1.0);
        } else {
            System.out.println("O incremento de velocidade deve ser positivo.");
        }
    }

    public void frear(int decremento) {
        if (decremento > 0) {
            this.velocidade = Math.max(0, this.velocidade - decremento);
            System.out.println("Freando... Nova velocidade: " + this.velocidade + " km/h");
            // Aciona sistema de freio e registra (se estiver registrando)
            freio.acionar();
            computador.atualizarDados(0.0, 1.0);
        } else {
            System.out.println("O decremento de velocidade deve ser positivo.");
        }
    }

    public void mudarMarcha(int novaMarcha) {
        setMarcha(novaMarcha);
        System.out.println("Marcha alterada para: " + this.marcha);
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
        return "Bicicleta{" +
               "cor='" + cor + '\'' +
               ", velocidade=" + velocidade +
               ", marcha=" + marcha +
               ", valor=" + valor +
               ", recursos=" + recursos +
               ", quadro=" + quadro +
               ", pneuDianteiro=" + pneuDianteiro +
               ", pneuTraseiro=" + pneuTraseiro +
               ", computador=" + computador +
               ", freio=" + freio +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicicleta)) return false;
        Bicicleta that = (Bicicleta) o;
        // Observação: equals baseado em cor e valor (conforme sua implementação original).
        // Para distinguir instâncias, seria melhor acrescentar um id único.
        return Objects.equals(cor, that.cor) && valor.compareTo(that.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor, valor);
    }
}
