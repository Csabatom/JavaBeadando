package toto.tarolo;

public class Talalat {
    private int talalatokSzama;
    private int nyertTalalatokSzama;
    private int nyeremeny;

    public Talalat(int talalatokSzama, int nyertTalalatokSzama, int nyeremeny)
    {
        this.talalatokSzama = talalatokSzama;
        this.nyertTalalatokSzama = nyertTalalatokSzama;
        this.nyeremeny = nyeremeny;
    }

    public int getTalalatokSzama() {
        return this.talalatokSzama;
    }

    public int getNyertTalalatokSzama() {
        return this.nyertTalalatokSzama;
    }

    public int getNyeremeny() {
        return this.nyeremeny;
    }
}
