package toto.tarolo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fordulo {
    private int ev;
    private int het;
    private int forduloAHeten;
    private LocalDate datum;
    private List<Talalat> talalatLista;
    private List<Eredmeny> eredmenyLista;

    public Fordulo(String sor) {

    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHet() {
        return het;
    }

    public void setHet(int het) {
        this.het = het;
    }

    public int getForduloAHeten() {
        return forduloAHeten;
    }

    public void setForduloAHeten(int forduloAHeten) {
        this.forduloAHeten = forduloAHeten;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public List<Talalat> getTalalatLista() {
        return talalatLista;
    }

    public void setTalalatLista(List<Talalat> talalatLista) {
        this.talalatLista = talalatLista;
    }

    public List<Eredmeny> getEredmenyLista() {
        return eredmenyLista;
    }

    public void setEredmenyLista(List<Eredmeny> eredmenyLista) {
        this.eredmenyLista = eredmenyLista;
    }
}
