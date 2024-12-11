package ex3;
/* 3. Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător*/
import java.util.Scanner;
public class ex3 {
    public static void main(String[] args){
        int divizor;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dati un numar: ");
        int numar = scanner.nextInt();

        if(prim(numar) == 1)
            System.out.println("Numarul este prim!");
            else
                for(divizor = 2; divizor <= numar/ 2;divizor++)
                    if(numar % divizor == 0)
                        System.out.print(divizor + "\n");
    }

    public static int prim(int numar) {
        int divizor;
        if (numar == 0 || numar == 1)
            return  0;
        if (numar % 2 == 0 && numar != 2)
            return 0;
        for(divizor = 3; divizor <= numar/2;divizor = divizor + 2)
            if (numar % divizor == 0)
                return 0;
        return 1;
    }
}
