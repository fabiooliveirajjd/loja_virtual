package com.fabio.loja_virtual.enuns;

public enum StatusContaReceber {

    COBRANCA("Pagar"),
    VENCIDA("Vencida"),
    ABERTA("Aberta"),
    QUITADA("Quitada");


    private String descricao;

    private StatusContaReceber(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
