package br.com.bb.lc.models.pessoa;

import br.com.bb.lc.models.Endereco;

public abstract class Pessoa {
    private Endereco endereco;
    private String telefone;
    private String nome;

    public abstract void setIdentificador(String id);

    public abstract String getIdentificador();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
