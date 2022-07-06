package br.com.bb.lc.models;

import java.math.BigDecimal;

//sacar, depositar, transferência, investir e consultar saldo (poupança e corrente).
//sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência.
public abstract class Conta {
    private String numero;
    private Agencia agencia;
    private Pessoa titular;
    private BigDecimal saldo;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

}
