package ex2;

import java.io.*;

public class ex2 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader flux_in;
        PrintStream flux_out;

        String linie;
        String grupare;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Dati grupare: ");
        grupare = in.readLine();

        flux_out = new PrintStream("src/ex2/cantec_out.txt");
        flux_in = new BufferedReader(new FileReader("src/ex2/cantec_in.txt"));
        linie = flux_in.readLine();

        while(linie != null)
        {
            Vers vers = new Vers(linie);

            if(vers.cautare(grupare) == true)
            {
                vers.random();
                flux_out.println(vers.getVers() + " " + vers.numar_de_cuvinte() + " " + vers.numar_de_vocale() + " *");
            }
            else
            {
                vers.random();
                flux_out.println(vers.getVers() + " " + vers.numar_de_cuvinte() + " " + vers.numar_de_vocale());
            }
            linie = flux_in.readLine();
        }
    }
}
