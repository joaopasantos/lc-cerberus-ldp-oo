import java.math.BigDecimal;

import br.com.bb.lc.models.Agencia;
import br.com.bb.lc.models.Endereco;
import br.com.bb.lc.models.conta.Conta;
import br.com.bb.lc.models.conta.ContaInvestimento;
import br.com.bb.lc.models.conta.TipoConta;
import br.com.bb.lc.models.pessoa.Pessoa;
import br.com.bb.lc.models.pessoa.PessoaFisica;
import br.com.bb.lc.models.pessoa.PessoaJuridica;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Endereco e = new Endereco("73733-900", "Distrito Federal", "Brasília", "Sobradinho", "CABV", "15", "BR-020");
        Pessoa p = new PessoaFisica("111.111.111-11", "João Pedro", e, "61911111111");
        Agencia a = new Agencia("1226", e);
        Conta cC = p.abrirConta(TipoConta.CORRENTE, "8877799", a);
        ContaInvestimento cI = (ContaInvestimento) p.abrirConta(TipoConta.INVESTIMENTO, "8877799", a);
        cC.depositar(BigDecimal.valueOf(1000));
        System.out.println(cC.consultarSaldo());
        cC.sacar(BigDecimal.valueOf(400));
        System.out.println(cC.consultarSaldo());
        System.out.println(cI.consultarSaldo());
        cC.transferir(cI, BigDecimal.valueOf(400));
        System.out.println(cC.consultarSaldo());
        System.out.println(cI.consultarSaldo());
        cI.investir(BigDecimal.valueOf(400));
        System.out.println(cI.consultarSaldo());
    }
}
