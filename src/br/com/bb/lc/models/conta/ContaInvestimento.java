package br.com.bb.lc.models.conta;

import java.math.BigDecimal;

import br.com.bb.lc.models.Agencia;
import br.com.bb.lc.models.pessoa.Pessoa;
import br.com.bb.lc.models.pessoa.PessoaJuridica;

public class ContaInvestimento extends Conta {
    final static BigDecimal TAXA_DE_RENDIMENTO_BASE = new BigDecimal("0.5");

    public ContaInvestimento(String numero, Agencia agencia, Pessoa titular) {
        super(numero, agencia, titular);
    }

    public BigDecimal investir(BigDecimal valor) {
        if (this.consultarSaldo().compareTo(valor) < 0)
            throw new RuntimeException("Conta não possui saldo suficiente para investimento");
        BigDecimal rendimento;
        BigDecimal taxa = TAXA_DE_RENDIMENTO_BASE;

        if (this.getTitular() instanceof PessoaJuridica)
            taxa = taxa.add(BigDecimal.valueOf(2));

        rendimento = valor
                .multiply(taxa)
                .divide(BigDecimal.valueOf(100));

        this.depositar(rendimento);

        return rendimento;
    }

}
