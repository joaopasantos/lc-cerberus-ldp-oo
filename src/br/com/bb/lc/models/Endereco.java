package br.com.bb.lc.models;

public class Endereco {
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numeroResidencia;
    private String complemento;

    public Endereco(String cep, String estado, String cidade, String bairro, String logradouro, String numeroResidencia,
            String complemento) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.complemento = complemento;
    }
}
