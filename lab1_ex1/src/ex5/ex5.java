package ex5;
import java.util.Random;
/*5. Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
Programul va determina dacă numărul aparține șirului lui Fobonacci.*/
//1 + 1 = 2
//1 + 2 = 3
//2 + 3 = 5
//3 + 5 = 8
//5 + 8 = 13
//8 + 13 = 21 ***
public class ex5 {
    public static void main(String[] args)
    {
        System.out.print("Se genereaza un numar: ");
        Random random = new Random();
        int nr = random.nextInt(20);
        System.out.println(nr);

        int a, b , c, ok;
        if(nr == 1)
            ok = 1;
        else {
            a = 1;
            b = 1;
            do {
                c = a + b;
                a = b;
                b = c;
            }while(c < nr);

            if (c == nr)
                ok = 1;
            else
                ok = 0;
        }
        if (ok == 0)
            System.out.print("Numarul nu apartine sirului Fibonacci!");
        else
            System.out.print("Numarul apartine sirului Fibonacci!");
    }
}
