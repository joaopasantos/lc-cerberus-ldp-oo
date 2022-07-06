package br.com.bb.lc.models.pessoa;

public class PessoaJuridica extends Pessoa {
    private String CNPJ;

    @Override
    public void setIdentificador(String id) {
        this.CNPJ = id;
    }

    @Override
    public String getIdentificador() {
        return this.CNPJ;
    }
}
