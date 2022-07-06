package br.com.bb.lc.models;

public class PessoaFisica extends Pessoa {
    private String CPF;

    @Override
    public void setIdentificador(String id) {
        this.CPF = id;
    }

    @Override
    public String getIdentificador() {
        return this.CPF;
    }
}
