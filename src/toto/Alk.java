package toto;

import toto.szolgaltatas.TotoSzolgaltatas;

import java.util.Scanner;

public class Alk {
    public static void main(String[] args) {
        TotoSzolgaltatas t = new TotoSzolgaltatas();

        System.out.println("1 feladat:\n\nA legnagyobb nyeremeny amit rogzitettek: " + t.getMaxNyeremenyListabol() + " Ft");

        double sum = t.getElsoGyozelem() + t.getMasikGyozelem() + t.getDontetlen();
        double avgElso = t.getElsoGyozelem() / sum * 100;
        double avgMasik = t.getMasikGyozelem() / sum * 100;
        double avgDontetlen = t.getDontetlen() / sum * 100;
        System.out.println("\n2 feladat:\n\nStatisztika:\n#1 csapat nyert: " + Math.round(avgElso * 100.0) / 100.0 + "%,\n#2 csapat nyert: " + Math.round(avgMasik * 100.0) / 100.0 + "%,\ndontetlen: " + Math.round(avgDontetlen * 100.0) / 100.0 + "%");

        Scanner sc = new Scanner(System.in);
        System.out.print("\n3 feladat:\n\nKerem adjon meg egy datumot: ");
        String datum = sc.next();
        if (t.vanEIlyenDatum(datum) == false)
        {
            System.out.println("Ezen a napon nem volt játék!");
        }
        else
        {
            String tipp = "";
            do
            {
                System.out.print("Kerem adjon meg egy tippet: ");
                tipp = sc.next();
                if (tipp.length() != 14)
                {
                    System.out.println("14 tippnek kell lennie!");
                }
            }
            while(tipp.length() != 14);
            t.getEredmeny(datum, tipp);
        }
    }
}
