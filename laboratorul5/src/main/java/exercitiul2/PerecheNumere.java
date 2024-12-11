package exercitiul2;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PerecheNumere {
    private int numar1;
    private int numar2;

    public PerecheNumere()
    {
        this.numar1 = 0;
        this.numar2 = 0;
    }

    public PerecheNumere(int numar1, int numar2)
    {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    public int getNumar1()
    {
        return numar1;
    }

    public void setNumar1(int numar1)
    {
        this.numar1 = numar1;
    }

    public int getNumar2()
    {
        return numar2;
    }

    public void setNumar2(int numar2)
    {
        this.numar2 = numar2;
    }

    @Override
    public String toString()
    {
        return "Pereche numere {" + "numar 1 = " + numar1 +
                "numar2 = " + numar2 + "}";
    }
    public boolean Fibonacci()
    {
        int f1 = 0;
        int f2 = 1;
        int sum = f1 + f2;

        while(sum < numar1 || sum < numar2) {
            f1 = f2;
            f2 = sum;
            sum = f1 + f2;
        }
            return sum == numar2 && f1 == numar1;
    }

    public int cmmdc()
    {
        int a = numar1;
        int b = numar2;
        while(b != 0)
        {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public boolean SumaCifreloregala()
    {
        int suma1 = 0;
        int suma2 = 0;
        int n1 = numar1;
        int n2 = numar2;

        while(n1 != 0)
        {
            suma1 += n1 % 10;
            n1 /= 10;
        }
        while(n1 != 0)
        {
            suma2 += n2 % 10;
            n2 /= 10;
        }
        return suma1 == suma2;
    }

    public boolean nr_cifre_pare()
    {
        int cifre1 = 0;
        int cifre2 = 0;
        int n1 = numar1;
        int n2 = numar2;

        while(n1 != 0) {
            int cifra = n1 % 10;
            if (cifra % 2 == 0) {
                cifre1++;
            }
            n1 /= 10;
        }
        while(n2 != 0)
        {
            int cifra = n2 % 10;
            if(cifra % 2 == 0)
            {
                cifre2++;
            }
            n2 /= 10;
        }
        return cifre1 == cifre2;
    }
}
