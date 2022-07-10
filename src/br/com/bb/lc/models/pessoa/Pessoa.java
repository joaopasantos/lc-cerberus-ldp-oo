package br.com.bb.lc.models.pessoa;

import br.com.bb.lc.models.Agencia;
import br.com.bb.lc.models.Endereco;
import br.com.bb.lc.models.conta.Conta;
import br.com.bb.lc.models.conta.ContaCorrente;
import br.com.bb.lc.models.conta.ContaInvestimento;
import br.com.bb.lc.models.conta.ContaPoupanca;
import br.com.bb.lc.models.conta.TipoConta;

public abstract class Pessoa {
    private Endereco endereco;
    private String telefone;
    private String nome;

    public Pessoa(Endereco endereco, String telefone, String nome) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
    }

    // protected abstract void setIdentificador(String id);

    public abstract String getIdentificador();

    public Conta abrirConta(TipoConta tipo, String numero, Agencia agencia) {
        if (tipo == null)
            throw new RuntimeException("Tipo de Conta não pode ser nulo.");
        switch (tipo) {
            case CORRENTE:
                return new ContaCorrente(numero, agencia, this);
            case INVESTIMENTO:
                return new ContaInvestimento(numero, agencia, this);
            case POUPANCA:
                if (this instanceof PessoaJuridica)
                    throw new RuntimeException("Cliente PJ não pode abrir Conta-Poupança.");
                return new ContaPoupanca(numero, agencia, this);
            default:
                throw new RuntimeException("Tipo de Conta inválido");
        }
    }
}
