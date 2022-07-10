package br.com.bb.lc.models.conta;

import br.com.bb.lc.models.Agencia;
import br.com.bb.lc.models.pessoa.Pessoa;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, Agencia agencia, Pessoa titular) {
        super(numero, agencia, titular);
    }

}
