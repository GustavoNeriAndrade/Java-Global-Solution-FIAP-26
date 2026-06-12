package br.com.fiap.bean;

import java.time.LocalDate;

public class Coleta {

    // Atributos
    private int idColeta;
    private LocalDate dataColeta;
    private String horaColeta;
    private String tipoDado;
    private String statusProcessamento;
    private Regiao regiao;
    private Satelite satelite;

    // Construtores
    public Coleta() {
    }

    public Coleta(int idColeta, LocalDate dataColeta, String horaColeta,
                  String tipoDado, String statusProcessamento,
                  Regiao regiao, Satelite satelite) {
        this.idColeta = idColeta;
        this.dataColeta = dataColeta;
        this.horaColeta = horaColeta;
        this.tipoDado = tipoDado;
        this.statusProcessamento = statusProcessamento;
        this.regiao = regiao;
        this.satelite = satelite;
    }

    // Getters e Setters
    public int getIdColeta() {
        return idColeta;
    }

    public void setIdColeta(int idColeta) {
        this.idColeta = idColeta;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getHoraColeta() {
        return horaColeta;
    }

    public void setHoraColeta(String horaColeta) {
        this.horaColeta = horaColeta;
    }

    public String getTipoDado() {
        return tipoDado;
    }

    public void setTipoDado(String tipoDado) {
        this.tipoDado = tipoDado;
    }

    public String getStatusProcessamento() {
        return statusProcessamento;
    }

    public void setStatusProcessamento(String statusProcessamento) {
        this.statusProcessamento = statusProcessamento;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Satelite getSatelite() {
        return satelite;
    }

    public void setSatelite(Satelite satelite) {
        this.satelite = satelite;
    }

    @Override
    public String toString() {
        return "Coleta{" +
                "idColeta=" + idColeta +
                ", dataColeta=" + dataColeta +
                ", horaColeta='" + horaColeta + '\'' +
                ", tipoDado='" + tipoDado + '\'' +
                ", statusProcessamento='" + statusProcessamento + '\'' +
                ", regiao=" + (regiao != null ? regiao.getNomeRegiao() : "N/A") +
                ", satelite=" + (satelite != null ? satelite.getNomeSatelite() : "N/A") +
                '}';
    }
}
