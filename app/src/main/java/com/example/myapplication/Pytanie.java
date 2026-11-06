package com.example.myapplication;

public class Pytanie {
    private  int idZdjecia;
    private String idPytanie;
    private boolean odpowiedz; //tak to tru a nie to false

    private boolean czyPoprawnaOdpowiedz;
    //udzielona odpowiedz


    private boolean wykorzystaniePodpowiedzi;
    private String Podpowiedz;

    public Pytanie(int idZdjecia, String idPytanie, boolean odpowiedz, String podpowiedz) {
        this.idZdjecia = idZdjecia;
        this.idPytanie = idPytanie;
        this.odpowiedz = odpowiedz;
        Podpowiedz = podpowiedz;
    }

    public Pytanie(int idZdjecia, String idPytanie, boolean odpowiedz) {
        this.idZdjecia = idZdjecia;
        this.idPytanie = idPytanie;
        this.odpowiedz = odpowiedz;
        czyPoprawnaOdpowiedz = false;
    }
    //gettery aby wszystko odczytać

    public int getIdZdjecia() {
        return idZdjecia;
    }

    public String getIdPytanie() {
        return idPytanie;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public boolean isCzyPoprawnaOdpowiedz() {
        return czyPoprawnaOdpowiedz;
    }

    //Setter
    public void setCzyPoprawnaOdpowiedz(boolean czyPoprawnaOdpowiedz) {
        this.czyPoprawnaOdpowiedz = czyPoprawnaOdpowiedz;
    }
}
