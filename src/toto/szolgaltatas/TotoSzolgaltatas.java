package toto.szolgaltatas;

import toto.tarolo.Eredmeny;
import toto.tarolo.Fordulo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TotoSzolgaltatas {
    private List<Fordulo> forduloLista;

    public TotoSzolgaltatas() {
        this.forduloLista = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("toto.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String sor = bufferedReader.readLine();
            while (sor != null)
            {
                this.forduloLista.add(new Fordulo(sor));
                sor = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception error) {
            System.out.printf("Hiba történt: %s", error);
        }
    }

    public int getMaxNyeremenyListabol()
    {
        int max = 0;
        for (int i = 0; i < this.forduloLista.size(); i++)
        {
            if (max < this.forduloLista.get(i).getMaxNyeremeny())
            {
                max = this.forduloLista.get(i).getMaxNyeremeny();
            }
        }
        return max;
    }

    public int getElsoGyozelem()
    {
        int sum = 0;
        for (int i = 0; i < this.forduloLista.size(); i++)
        {
            for (int j = 0; j < this.forduloLista.get(i).getEredmenyekLista().size(); j++)
            {
                if (this.forduloLista.get(i).getEredmenyekLista().get(j).equals(Eredmeny._1))
                {
                    sum++;
                }
            }
        }
        return sum;
    }
    public int getMasikGyozelem()
    {
        int sum = 0;
        for (int i = 0; i < this.forduloLista.size(); i++)
        {
            for (int j = 0; j < this.forduloLista.get(i).getEredmenyekLista().size(); j++)
            {
                if (this.forduloLista.get(i).getEredmenyekLista().get(j).equals(Eredmeny._2))
                {
                    sum++;
                }
            }
        }
        return sum;
    }
    public int getDontetlen()
    {
        int sum = 0;
        for (int i = 0; i < this.forduloLista.size(); i++)
        {
            for (int j = 0; j < this.forduloLista.get(i).getEredmenyekLista().size(); j++)
            {
                if (this.forduloLista.get(i).getEredmenyekLista().get(j).equals(Eredmeny.X))
                {
                    sum++;
                }
            }
        }
        return sum;
    }

    public boolean vanEIlyenDatum(String segedDatum)
    {
        segedDatum = segedDatum.replace(".", "-");
        String[] datumok = segedDatum.split("-");
        LocalDate datum = LocalDate.of(Integer.parseInt(datumok[0]), Integer.parseInt(datumok[1]), Integer.parseInt(datumok[2]));
        boolean vanE = false;
        for (int i = 0; i < this.forduloLista.size(); i++)
        {
            if (this.forduloLista.get(i).getDatum().equals(datum))
            {
                vanE = true;
            }
        }
        return vanE;
    }

    public void getEredmeny(String segedDatum, String tipp)
    {
        segedDatum = segedDatum.replace(".", "-");
        String[] datumok = segedDatum.split("-");
        LocalDate datum = LocalDate.of(Integer.parseInt(datumok[0]), Integer.parseInt(datumok[1]), Integer.parseInt(datumok[2]));

        tipp = tipp.toUpperCase();
        String[] tippek = tipp.split("");
        List<Eredmeny> tippekLista = new ArrayList<>();
        for (int i = 0; i < tippek.length; i++)
        {
            switch (tippek[i])
            {
                case "1": tippekLista.add(Eredmeny._1); break;
                case "2": tippekLista.add(Eredmeny._2); break;
                case "X": tippekLista.add(Eredmeny.X); break;
            }
        }
        int talalat = 0;
        int nyeremeny = 0;
        boolean voltEJatek = false;
        for (int i = 0; i < this.forduloLista.size(); i++)
        {
            if (this.forduloLista.get(i).getDatum().equals(datum))
            {
                voltEJatek = true;
                for (int j = 0; j < this.forduloLista.get(i).getEredmenyekLista().size(); j++)
                {
                    if (this.forduloLista.get(i).getEredmenyekLista().get(j) == tippekLista.get(j))
                    {
                        talalat++;
                    }
                }
                if (talalat >= 10)
                {
                    for (int j = 0; j < this.forduloLista.get(i).getTalalatLista().size(); j++)
                    {
                        if (this.forduloLista.get(i).getTalalatLista().get(j).getTalalatokSzama() == talalat)
                        {
                            nyeremeny = this.forduloLista.get(i).getTalalatLista().get(j).getNyeremeny();
                        }
                    }
                }
                else
                {
                    nyeremeny = 0;
                }
            }
        }
        if (voltEJatek == false)
        {
            System.out.println("Nem volt ezen a napon totó.");
        }
        else
        {
            System.out.printf("Eredmény: találat: %d, nyeremeny: %d Ft", talalat, nyeremeny);
        }
    }
}
