package br.com.bb.lc.models.pessoa;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    @Override
    public void setIdentificador(String id) {
        this.cnpj = id;
    }

    @Override
    public String getIdentificador() {
        return this.cnpj;
    }
}
