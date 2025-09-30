package com.fum.fundamentos;

public class SistemaPilha {
    public static void main(String[] args) {
        System.out.println("=== Demonstração Pilha Ruim (Herança) ===");
        PilhaRuim pilhaRuim = new PilhaRuim();
        pilhaRuim.push("A");
        pilhaRuim.push("B");
        System.out.println("Topo: " + pilhaRuim.peek());
        System.out.println("Removido: " + pilhaRuim.pop());

        System.out.println("\n=== Demonstração Pilha Boa (Composição) ===");
        PilhaBoa pilhaBoa = new PilhaBoa();
        pilhaBoa.push("X");
        pilhaBoa.push("Y");
        System.out.println("Topo: " + pilhaBoa.peek());
        System.out.println("Removido: " + pilhaBoa.pop());
    }
}
