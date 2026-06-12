package br.com.fiap.bean;

public class Analista {

    // Atributos
    private int idAnalista;
    private String nomeAnalista;
    private String emailAnalista;
    private String orgaoVinculado;
    private String nivelAcesso;

    // Construtores
    public Analista() {
    }

    public Analista(int idAnalista, String nomeAnalista, String emailAnalista,
                    String orgaoVinculado, String nivelAcesso) {
        this.idAnalista = idAnalista;
        this.nomeAnalista = nomeAnalista;
        this.emailAnalista = emailAnalista;
        this.orgaoVinculado = orgaoVinculado;
        this.nivelAcesso = nivelAcesso;
    }

    // Getters e Setters
    public int getIdAnalista() {
        return idAnalista;
    }

    public void setIdAnalista(int idAnalista) {
        this.idAnalista = idAnalista;
    }

    public String getNomeAnalista() {
        return nomeAnalista;
    }

    public void setNomeAnalista(String nomeAnalista) {
        this.nomeAnalista = nomeAnalista;
    }

    public String getEmailAnalista() {
        return emailAnalista;
    }

    public void setEmailAnalista(String emailAnalista) {
        this.emailAnalista = emailAnalista;
    }

    public String getOrgaoVinculado() {
        return orgaoVinculado;
    }

    public void setOrgaoVinculado(String orgaoVinculado) {
        this.orgaoVinculado = orgaoVinculado;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "Analista{" +
                "idAnalista=" + idAnalista +
                ", nomeAnalista='" + nomeAnalista + '\'' +
                ", emailAnalista='" + emailAnalista + '\'' +
                ", orgaoVinculado='" + orgaoVinculado + '\'' +
                ", nivelAcesso='" + nivelAcesso + '\'' +
                '}';
    }
}
