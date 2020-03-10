package com.company;

import java.util.Date;

public class Kutya {
    private int id;
    private int fajta_id;
    private int nev_id;
    private int eletkor;
    private Date orvosiEll;

    public Kutya(String sor) {
        this.id = Integer.parseInt(sor.split(";")[0]);
        this.fajta_id = Integer.parseInt(sor.split(";")[1]);
        this.nev_id = Integer.parseInt(sor.split(";")[2]);
        this.eletkor = Integer.parseInt(sor.split(";")[3]);
        String[] datum = sor.split(";")[4].split("\\.");
        this.orvosiEll = new Date(Integer.parseInt(datum[0]),Integer.parseInt(datum[1]),Integer.parseInt(datum[2]));
    }

    public int getId() { return id; }

    public int getFajta_id() { return fajta_id; }

    public int getNev_id() { return nev_id; }

    public int getEletkor() { return eletkor; }

    public Date getOrvosiEll() { return orvosiEll; }

    public void setId(int id) { this.id = id; }

    public void setFajta_id(int fajta_id) { this.fajta_id = fajta_id; }

    public void setNev_id(int nev_id) { this.nev_id = nev_id; }

    public void setEletkor(int eletkor) { this.eletkor = eletkor; }

    public void setOrvosiEll(Date orvosiEll) { this.orvosiEll = orvosiEll; }

    @Override
    public String toString() {
        return "Kutya{" +
                "id=" + id +
                ", fajta_id=" + fajta_id +
                ", nev_id=" + nev_id +
                ", eletkor=" + eletkor +
                ", orvosiEll=" + orvosiEll +
                '}';
    }
}
