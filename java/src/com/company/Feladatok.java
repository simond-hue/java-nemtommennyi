package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Feladatok {
    private ArrayList<Kutya> kutyak;
    private ArrayList<KutyaFajta> kutya_fajtak;
    private ArrayList<KutyaNev> kutya_nevek;

    public Feladatok() {
        this.Beolvasas();
    }
    private void Beolvasas(){
        try{
            Scanner scKutyak = new Scanner(new File("Kutyák.csv"));
            Scanner scKutyanev = new Scanner(new File("KutyaNevek.csv"));
            Scanner scKutyafajta = new Scanner(new File("KutyaFajták.csv"));

            this.kutyak=new ArrayList<Kutya>();
            this.kutya_fajtak=new ArrayList<KutyaFajta>();
            this.kutya_nevek=new ArrayList<KutyaNev>();

            scKutyak.nextLine();
            scKutyanev.nextLine();
            scKutyafajta.nextLine();

            while(scKutyak.hasNext()){
                kutyak.add(new Kutya(scKutyak.nextLine()));
            }
            while(scKutyanev.hasNext()){
                kutya_nevek.add(new KutyaNev(scKutyanev.nextLine()));
            }
            while(scKutyafajta.hasNext()){
                kutya_fajtak.add(new KutyaFajta(scKutyafajta.nextLine()));
            }
        }
        catch(Exception e){
            System.out.println("Hiba!" + e.getMessage());
        }
    }

    public String Harmadik(){
        return String.format("3. feladat: Kutyanevek száma: %d",this.kutya_nevek.size());
    }

    public String Hatodik(){
        int sum = 0;
        for (Kutya k : this.kutyak) {
            sum+=k.getEletkor();
        }
        DecimalFormat f = new DecimalFormat("##.00");
        return String.format("6. feladat: Kutyák átlag életkora: "+f.format((double)Math.round(sum*1.0/kutyak.size()*100)/100));
    }

    public String Hetedik(){
        Kutya legidosebb = kutyak.get(0);
        for (Kutya k: this.kutyak) {
            if(legidosebb.getEletkor() < k.getEletkor()){
                legidosebb = k;
            }
        }

        return String.format("7. feladat: Legidősebb kutya neve és fajtája: "+ this.kutya_nevek.get(legidosebb.getNev_id()-1).getNev() + ", " + this.kutya_fajtak.get(legidosebb.getFajta_id()-1).getNev());
    }

    public String Nyolcadik(){
        ArrayList<Kutya> kezelt = new ArrayList<Kutya>();
        Date datum = new Date(2018,1,10);
        for (Kutya k : kutyak) {
            if(k.getOrvosiEll().compareTo(datum) == datum.compareTo(k.getOrvosiEll())){
                kezelt.add(k);
            }
        }
        ArrayList<Integer> id = new ArrayList<Integer>();
        ArrayList<Integer> count = new ArrayList<Integer>();

        for (Kutya k: kezelt) {
            if(!id.contains(k.getFajta_id())){
                id.add(k.getFajta_id());
                count.add(1);
            }
            else{
                int index = kezelt.indexOf(k.getFajta_id());
                int countamount = count.get(index);
                countamount++;
                count.set(index,countamount);
            }
        }

        String endstring = "\n";

        for(int i = 0; i < id.size(); i++){
            endstring+="\t";
            endstring+=this.kutya_fajtak.get(id.get(i)-1).getNev() + ": ";
            endstring+=count.get(i) +" kutya";
            if(i != id.size()-1) endstring+="\n";
        }

        return String.format("8. feladat: Január 10.-én vizsgált kutya fajták:" + endstring);
    }

    public String Kilencedik(){
        ArrayList<Date> datumok = new ArrayList<Date>();
        ArrayList<Integer> count = new ArrayList<Integer>();

        for (Kutya k : this.kutyak) {
            if (!datumok.contains(k.getOrvosiEll())) {
                datumok.add(k.getOrvosiEll());
                count.add(1);
            } else {
                int index = datumok.indexOf(k.getOrvosiEll());
                int amount = count.get(index);
                amount++;
                count.set(index, amount);
            }
        }
        int maxind = 0;
        for(int i = 1; i < datumok.size(); i++){
            if(count.get(maxind) < count.get(i)){
                maxind = i;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yy. MM. d.");
        return String.format("9. feladat: Legjobban leterhelt nap: " + sdf.format(datumok.get(maxind)) + ": " + count.get(maxind) + " kutya");
    }
}
