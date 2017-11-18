package br.com.ricardosander.imobiliaria.model;

public class Cliente {

    private final Long id;
    private final String nome;

    public Cliente(Long id, String nome) {

        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
