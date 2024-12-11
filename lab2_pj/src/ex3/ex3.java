package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex3 {
   public static void main(String[] args) throws IOException
   {
       String string;
       String string_in;
       String pozitie;
       String poz_sterg;
       String nrcarac_sterg;

       int poz;
       int pozs;
       int sters;

       StringBuffer inserare;
       StringBuffer stergere;

       BufferedReader flux_in = new BufferedReader(new InputStreamReader((System.in)));

       System.out.println("****** INSERARE ******");
       System.out.print("Sir initial: ");
       string = flux_in.readLine();
       System.out.print("Sir de inserat");
       string_in = flux_in.readLine();
       System.out.print("Dati pozitia de unde doriti sa inceapa inserarea: ");
       pozitie = flux_in.readLine();
       poz = Integer.parseInt(pozitie);
       inserare = new StringBuffer(string);
       inserare.insert(poz,string_in);
       System.out.println("Sirul initial de dupa inserare: "+inserare);

       System.out.println("****** STERGERE ******");
       System.out.print("Dati sirul: ");
       string = flux_in.readLine();
       System.out.print("Numarul de caractere pe care doriti sa il steregeti: ");
       nrcarac_sterg = flux_in.readLine();
       sters = Integer.parseInt(nrcarac_sterg);
       System.out.print("Dati pozitia de unde doriti sa inceapa stergerea: ");
       poz_sterg = flux_in.readLine();
       pozs = Integer.parseInt(poz_sterg);
       stergere = new StringBuffer(string);
       stergere.delete(pozs, pozs + sters);
       System.out.println("Sirul initial dupa stergere: " +stergere);
   }
}
