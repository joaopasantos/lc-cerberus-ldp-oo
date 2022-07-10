package br.com.bb.lc.models.pessoa;

import br.com.bb.lc.models.Endereco;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String cnpj, String nome, Endereco endereco, String telefone) {
        super(endereco, telefone, nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getIdentificador() {
        return this.cnpj;
    }
}
