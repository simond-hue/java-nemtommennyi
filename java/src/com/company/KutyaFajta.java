package com.company;

public class KutyaFajta {
    private int id;
    private String nev;
    private String eredeti_nev;

    public KutyaFajta(String sor) {
        String[] adatok = sor.split(";");
        this.id = Integer.parseInt(adatok[0]);
        this.nev = adatok[1];
        if(adatok.length == 2){
            this.eredeti_nev = "";
        }
        else{
            this.eredeti_nev = adatok[2];
        }
    }

    public int getId() { return id; }

    public String getNev() { return nev; }

    public String getEredeti_nev() { return eredeti_nev; }

    public void setId(int id) { this.id = id; }

    public void setNev(String nev) { this.nev = nev; }

    public void setEredeti_nev(String eredeti_nev) { this.eredeti_nev = eredeti_nev; }

    @Override
    public String toString() {
        return "KutyaFajta{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", eredeti_nev='" + eredeti_nev + '\'' +
                '}';
    }
}
