package org.brenomachado.cyberspeteria;

/**
 * Created by breno on 19/09/2016.
 */
public class Produto {
    private double valor;
    private String nome;
    private boolean isSelecionado;

    public Produto(String nome, double valor) {
        this.valor = valor;
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public boolean isSelecionado() {
        return isSelecionado;
    }

    public void setSelecionado(boolean selecionado) {
        isSelecionado = selecionado;
    }
}
