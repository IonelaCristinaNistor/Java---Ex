package ex4;
/* 4. Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt();*/
import java.util.Random;
public class ex4 {
    public static void main(String[] args) {
        int cmmdc;
        Random random = new Random();
        int nr1 = random.nextInt(30);
        int nr2 = random.nextInt(30);

        System.out.print("Se genereaza numerele: ");
        System.out.print(nr1 + " " + nr2 + "\n");

        if(nr1 * nr2 == 0)
            cmmdc = nr1 + nr2;
        else
        {
            while(nr1 != nr2)
                if(nr1 > nr2)
                    nr1 = nr1 - nr2;
            else
                nr2 = nr2 - nr1;
            cmmdc = nr1;
        }
        System.out.println("CMMDC este: "+ cmmdc);
    }
}
