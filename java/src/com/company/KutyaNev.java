package com.company;

public class KutyaNev {
    private int id;
    private String nev;

    public KutyaNev(String sor) {
        String[] adatok = sor.split(";");
        this.id = Integer.parseInt(adatok[0]);
        this.nev = adatok[1];
    }

    public int getId() { return id; }

    public String getNev() { return nev; }

    public void setId(int id) { this.id = id; }

    public void setNev(String nev) { this.nev = nev; }

    @Override
    public String toString() {
        return "KutyaNevek{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                '}';
    }
}
