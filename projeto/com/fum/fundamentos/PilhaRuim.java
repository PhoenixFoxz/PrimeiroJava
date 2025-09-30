package com.fum.fundamentos;

import java.util.ArrayList;

public class PilhaRuim extends ArrayList<String> {
    public void push(String elemento) {
        add(elemento);
    }

    public String pop() {
        if (isEmpty()) return null;
        return remove(size() - 1);
    }

    public String peek() {
        if (isEmpty()) return null;
        return get(size() - 1);
    }
}
