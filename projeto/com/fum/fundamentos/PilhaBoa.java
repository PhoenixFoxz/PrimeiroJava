package com.fum.fundamentos;

import java.util.ArrayList;

public class PilhaBoa {
    private ArrayList<String> elementos;

    public PilhaBoa() {
        this.elementos = new ArrayList<>();
    }

    public void push(String elemento) {
        elementos.add(elemento);
    }

    public String pop() {
        if (isEmpty()) return null;
        return elementos.remove(elementos.size() - 1);
    }

    public String peek() {
        if (isEmpty()) return null;
        return elementos.get(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }
}
