package br.com.bb.lc.models.pessoa;

import br.com.bb.lc.models.Endereco;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String cpf, String nome, Endereco endereco, String telefone) {
        super(endereco, telefone, nome);
        this.cpf = cpf;
    }

    @Override
    public String getIdentificador() {
        return this.cpf;
    }
}
