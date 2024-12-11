package ex2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader
                (new FileInputStream("src/ex2/in.txt")));
        int s, suma = 0, c = 0;
        String linie;
        Float Ma;
        int min =  Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while((linie = flux_in.readLine()) != null)
        {
            s = Integer.parseInt(linie);
            if(s < min)
                min = s;
            if(s > max)
                max = s;
            c++;
            suma = suma + s;
        }
        Ma = (float)suma / (float)c;
        System.out.println("Minimul : " +min +" Maximul : "
                + max + " Suma : " +suma + " Media aritmetica : " +Ma);

    }

}
