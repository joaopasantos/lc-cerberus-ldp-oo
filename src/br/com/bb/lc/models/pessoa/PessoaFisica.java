package br.com.bb.lc.models.pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;

    @Override
    public void setIdentificador(String id) {
        this.cpf = id;
    }

    @Override
    public String getIdentificador() {
        return this.cpf;
    }
}
