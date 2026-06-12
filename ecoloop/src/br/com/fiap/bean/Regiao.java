package br.com.fiap.bean;

public class Regiao {

    private int idRegiao;
    private String nomeRegiao;
    private String biomaRegiao;
    private String estadoRegiao;
    private double latitude;
    private double longitude;
    private double areaTotalKm2;

    // Construtores
    public Regiao() {
    }

    public Regiao(int idRegiao, String nomeRegiao, String biomaRegiao,
                  String estadoRegiao, double latitude, double longitude,
                  double areaTotalKm2) {
        this.idRegiao = idRegiao;
        this.nomeRegiao = nomeRegiao;
        this.biomaRegiao = biomaRegiao;
        this.estadoRegiao = estadoRegiao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaTotalKm2 = areaTotalKm2;
    }

    // Getters e Setters
    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public String getBiomaRegiao() {
        return biomaRegiao;
    }

    public void setBiomaRegiao(String biomaRegiao) {
        this.biomaRegiao = biomaRegiao;
    }

    public String getEstadoRegiao() {
        return estadoRegiao;
    }

    public void setEstadoRegiao(String estadoRegiao) {
        this.estadoRegiao = estadoRegiao;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAreaTotalKm2() {
        return areaTotalKm2;
    }

    public void setAreaTotalKm2(double areaTotalKm2) {
        this.areaTotalKm2 = areaTotalKm2;
    }

    @Override
    public String toString() {
        return "Regiao{" +
                "idRegiao=" + idRegiao +
                ", nomeRegiao='" + nomeRegiao + '\'' +
                ", biomaRegiao='" + biomaRegiao + '\'' +
                ", estadoRegiao='" + estadoRegiao + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", areaTotalKm2=" + areaTotalKm2 +
                '}';
    }
}
