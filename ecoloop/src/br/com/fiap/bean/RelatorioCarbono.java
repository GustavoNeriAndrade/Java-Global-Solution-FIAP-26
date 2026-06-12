package br.com.fiap.bean;

import java.time.LocalDate;

public class RelatorioCarbono {

    // Atributos
    private int idRelatorio;
    private double co2EstimadoTonelada;
    private String metodologia;
    private LocalDate dataGeracao;
    private Alerta alerta;

    // Construtores
    public RelatorioCarbono() {
    }

    public RelatorioCarbono(int idRelatorio, double co2EstimadoTonelada,
                            String metodologia, LocalDate dataGeracao, Alerta alerta) {
        this.idRelatorio = idRelatorio;
        this.co2EstimadoTonelada = co2EstimadoTonelada;
        this.metodologia = metodologia;
        this.dataGeracao = dataGeracao;
        this.alerta = alerta;
    }

    // Getters e Setters
    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public double getCo2EstimadoTonelada() {
        return co2EstimadoTonelada;
    }

    public void setCo2EstimadoTonelada(double co2EstimadoTonelada) {
        this.co2EstimadoTonelada = co2EstimadoTonelada;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    // Métodos da classe
    public double calcularCarbono() {
        if (alerta == null) {
            return 0;
        }
        double fatorCO2PorHectare = 200.0;
        return alerta.getAreaDesmatadaHa() * fatorCO2PorHectare;
    }

    public void exibirResumoRelatorio() {
        System.out.println("========================================");
        System.out.println("     RELATÓRIO DE CARBONO - EcoLoop     ");
        System.out.println("========================================");
        System.out.println("Relatório ID  : " + idRelatorio);
        System.out.println("Data de Geração: " + dataGeracao);
        System.out.println("Metodologia   : " + metodologia);

        if (alerta != null) {
            System.out.println("----------------------------------------");
            System.out.println("Alerta ID     : " + alerta.getIdAlerta());
            System.out.println("Status Alerta : " + alerta.getStatusAlerta());
            System.out.println("Área Desmatada: " + alerta.getAreaDesmatadaHa() + " ha");
            System.out.println("Severidade    : " + alerta.getNivelSeveridade());

            if (alerta.getColeta() != null && alerta.getColeta().getRegiao() != null) {
                System.out.println("Região        : " + alerta.getColeta().getRegiao().getNomeRegiao());
                System.out.println("Bioma         : " + alerta.getColeta().getRegiao().getBiomaRegiao());
                System.out.println("Estado        : " + alerta.getColeta().getRegiao().getEstadoRegiao());
            }

            if (alerta.getAnalista() != null) {
                System.out.println("Analista      : " + alerta.getAnalista().getNomeAnalista());
                System.out.println("Órgão         : " + alerta.getAnalista().getOrgaoVinculado());
            }

            System.out.println("----------------------------------------");
            System.out.printf("CO2 Estimado  : %.2f toneladas métricas%n", co2EstimadoTonelada);
        }
        System.out.println("========================================");
    }

    @Override
    public String toString() {
        return "RelatorioCarbono{" +
                "idRelatorio=" + idRelatorio +
                ", co2EstimadoTonelada=" + co2EstimadoTonelada +
                ", metodologia='" + metodologia + '\'' +
                ", dataGeracao=" + dataGeracao +
                ", alertaId=" + (alerta != null ? alerta.getIdAlerta() : "N/A") +
                '}';
    }
}
