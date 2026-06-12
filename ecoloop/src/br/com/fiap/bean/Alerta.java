package br.com.fiap.bean;

import java.time.LocalDate;

public class Alerta {

    // Atributos
    private int idAlerta;
    private double areaDesmatadaHa;
    private String nivelSeveridade;
    private String statusAlerta;
    private LocalDate dataRegistro;
    private Analista analista;
    private Coleta coleta;

    // Construtores
    public Alerta() {
    }

    public Alerta(int idAlerta, double areaDesmatadaHa, String statusAlerta,
                  LocalDate dataRegistro, Analista analista, Coleta coleta) {
        this.idAlerta = idAlerta;
        this.areaDesmatadaHa = areaDesmatadaHa;
        this.statusAlerta = statusAlerta;
        this.dataRegistro = dataRegistro;
        this.analista = analista;
        this.coleta = coleta;
        this.nivelSeveridade = classificarSeveridade();
    }

    // Getters e Setters
    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public double getAreaDesmatadaHa() {
        return areaDesmatadaHa;
    }

    public void setAreaDesmatadaHa(double areaDesmatadaHa) {
        this.areaDesmatadaHa = areaDesmatadaHa;
        this.nivelSeveridade = classificarSeveridade();
    }

    public String getNivelSeveridade() {
        return nivelSeveridade;
    }

    public void setNivelSeveridade(String nivelSeveridade) {
        this.nivelSeveridade = nivelSeveridade;
    }

    public String getStatusAlerta() {
        return statusAlerta;
    }

    public void setStatusAlerta(String statusAlerta) {
        this.statusAlerta = statusAlerta;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Analista getAnalista() {
        return analista;
    }

    public void setAnalista(Analista analista) {
        this.analista = analista;
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    // Métodos da classe
    public String classificarSeveridade() {
        if (areaDesmatadaHa <= 0) {
            return "Inválido";
        } else if (areaDesmatadaHa <= 50) {
            return "Baixo";
        } else if (areaDesmatadaHa <= 200) {
            return "Médio";
        } else if (areaDesmatadaHa <= 500) {
            return "Alto";
        } else {
            return "Crítico";
        }
    }

    public RelatorioCarbono confirmarAlerta(int idRelatorio, String metodologia) {
        if (this.statusAlerta.equalsIgnoreCase("Pendente")) {
            this.statusAlerta = "Confirmado";
            System.out.println("Alerta #" + idAlerta + " confirmado com sucesso!");
            RelatorioCarbono relatorio = new RelatorioCarbono();
            relatorio.setIdRelatorio(idRelatorio);
            relatorio.setMetodologia(metodologia);
            relatorio.setDataGeracao(LocalDate.now());
            relatorio.setAlerta(this);
            relatorio.setCo2EstimadoTonelada(relatorio.calcularCarbono());
            return relatorio;
        } else {
            System.out.println("Alerta #" + idAlerta + " já está com status: " + statusAlerta
                    + ". Não é possível confirmar novamente.");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "idAlerta=" + idAlerta +
                ", areaDesmatadaHa=" + areaDesmatadaHa +
                ", nivelSeveridade='" + nivelSeveridade + '\'' +
                ", statusAlerta='" + statusAlerta + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", analista=" + (analista != null ? analista.getNomeAnalista() : "N/A") +
                ", regiao=" + (coleta != null && coleta.getRegiao() != null
                        ? coleta.getRegiao().getNomeRegiao() : "N/A") +
                '}';
    }
}
