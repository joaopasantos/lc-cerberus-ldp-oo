package br.com.bb.lc.models.pessoa;

import br.com.bb.lc.models.Endereco;

public abstract class Pessoa {
    private Endereco endereco;
    private String telefone;
    private String nome;

    public abstract void setIdentificador(String id);

    public abstract String getIdentificador();
}
