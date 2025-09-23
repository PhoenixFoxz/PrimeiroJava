package com.fum.fundamentos;

public class Oficina {

    public void revisarBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            System.out.println("Revisando a bicicleta: " + bicicleta.getCor());
            System.out.println("Quadro: " + bicicleta.getQuadro());
            System.out.println("Pneu dianteiro: " + bicicleta.getPneuDianteiro());
            System.out.println("Pneu traseiro: " + bicicleta.getPneuTraseiro());
        } else {
            System.out.println("Nenhuma bicicleta para revisar.");
        }
    }

    public void trocarPneu(Bicicleta bicicleta, Pneu novoPneu) {
        if (bicicleta != null && novoPneu != null) {
            bicicleta.setPneuDianteiro(novoPneu);
            bicicleta.setPneuTraseiro(novoPneu);
            System.out.println("Pneus trocados com sucesso!");
        }
    }

    public void ajustarMarcha(Bicicleta bicicleta, int novaMarcha) {
        if (bicicleta != null) {
            bicicleta.mudarMarcha(novaMarcha);
        }
    }
}
