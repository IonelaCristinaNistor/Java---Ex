 /*
1. Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.
 */
package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex1 {
    public static void main(String[] args) throws IOException{
        String linie;
        int nr = 0;

        BufferedReader flux_in;
        BufferedReader contor;

        contor = new BufferedReader((new FileReader("src/ex1/judete_in.txt")));
        linie = contor.readLine();

        while(linie != null)
        {
            nr++;
            linie = contor.readLine();
        }

        if(nr > 0) {
            int k = 0;
            int poz;

            String judet;
            String[] judete = new String[nr];

            flux_in = new BufferedReader(new FileReader("src/ex1/judete_in.txt"));
            linie = flux_in.readLine();
            while (linie != null) {
                judete[k] = linie;
                linie = flux_in.readLine();
                k++;
            }
            Arrays.sort(judete);

            System.out.println("Sortare: ");
            for (int i = 0; i <= k; i++)
            {
                System.out.println(judete[i]);
            }

            BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Dati numele judetului caruia doriti sa-i aflati pozitia: ");
            judet = x.readLine();

            poz = Arrays.binarySearch(judete, judet);
            poz = poz + 1;

            if (poz >= 0)
                System.out.println("Pozitia: "+poz);
            else
                System.out.println("Judetul nu exista");
        }
        else
            System.out.println("Fisierul este gol");
    }
}
