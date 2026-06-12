package br.com.fiap.bean;

import java.time.LocalDate;

public class Satelite {

    // Atributos
    private int idSatelite;
    private String nomeSatelite;
    private String agenciaOperadora;
    private double altitudeOrbitalKm;
    private LocalDate dataLancamento;

    // Construtores
    public Satelite() {
    }

    public Satelite(int idSatelite, String nomeSatelite, String agenciaOperadora,
                    double altitudeOrbitalKm, LocalDate dataLancamento) {
        this.idSatelite = idSatelite;
        this.nomeSatelite = nomeSatelite;
        this.agenciaOperadora = agenciaOperadora;
        this.altitudeOrbitalKm = altitudeOrbitalKm;
        this.dataLancamento = dataLancamento;
    }

    // Getters e Setters
    public int getIdSatelite() {
        return idSatelite;
    }

    public void setIdSatelite(int idSatelite) {
        this.idSatelite = idSatelite;
    }

    public String getNomeSatelite() {
        return nomeSatelite;
    }

    public void setNomeSatelite(String nomeSatelite) {
        this.nomeSatelite = nomeSatelite;
    }

    public String getAgenciaOperadora() {
        return agenciaOperadora;
    }

    public void setAgenciaOperadora(String agenciaOperadora) {
        this.agenciaOperadora = agenciaOperadora;
    }

    public double getAltitudeOrbitalKm() {
        return altitudeOrbitalKm;
    }

    public void setAltitudeOrbitalKm(double altitudeOrbitalKm) {
        this.altitudeOrbitalKm = altitudeOrbitalKm;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Satelite{" +
                "idSatelite=" + idSatelite +
                ", nomeSatelite='" + nomeSatelite + '\'' +
                ", agenciaOperadora='" + agenciaOperadora + '\'' +
                ", altitudeOrbitalKm=" + altitudeOrbitalKm +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
