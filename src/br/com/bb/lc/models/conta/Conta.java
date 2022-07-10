package br.com.bb.lc.models.conta;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.bb.lc.models.Agencia;
import br.com.bb.lc.models.pessoa.Pessoa;
import br.com.bb.lc.models.pessoa.PessoaJuridica;

//sacar, depositar, transferência, investir e consultar saldo (poupança e corrente).
//sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência.
public abstract class Conta {
    private String numero;
    private Agencia agencia;
    private Pessoa titular;
    private BigDecimal saldo;

    public Conta(String numero, Agencia agencia, Pessoa titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public BigDecimal sacar(BigDecimal valor) {
        if (valor.signum() == -1)
            throw new RuntimeException("Valor de saque inválido");
        // Para PJ, existe a cobrança de uma taxa de 0.5% para cada saque ou
        // transferência.
        if (this.titular instanceof PessoaJuridica)
            valor.multiply(new BigDecimal("1.05"));

        if (this.saldo.compareTo(valor) == -1)
            throw new RuntimeException("Saldo insuficiente para operação");

        this.saldo = saldo.subtract(valor);
        return valor;
    }

    public BigDecimal depositar(BigDecimal valor) {
        if (valor.signum() == -1)
            throw new RuntimeException("Valor de depósito inválido");
        this.saldo = saldo.add(valor);
        return valor;
    }

    public BigDecimal transferir(Conta destino, BigDecimal valor) {
        if (valor.signum() == -1)
            throw new RuntimeException("Valor de transferência inválido");
        BigDecimal valorRetirado = this.sacar(valor);
        destino.depositar(valor);
        return valorRetirado;
    }

    public BigDecimal consultarSaldo() {
        return saldo.setScale(2, RoundingMode.DOWN);
    }
}
