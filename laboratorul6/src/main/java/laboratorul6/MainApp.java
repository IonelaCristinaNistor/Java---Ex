package laboratorul6;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MainApp {
    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajat = mapper.readValue(file, new TypeReference<List<Angajat>>() {
            });
            return angajat;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static void afisare(List<Angajat> angajat, Predicate<Angajat> f)
    {
        for(Angajat a:angajat)
            if(f.test(a))
                System.out.println(a);
    }
    public static void main(String[] args) throws IOException {
        {
           /* List<Angajat> angajati=citire();
            System.out.println(angajati);
            for(Angajat a:angajati)
            {
                System.out.println(a);
            }
            */


            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Meniu:");
                System.out.println("0.Exit");
                System.out.println("1. Option 1");
                System.out.println("2. Option 2");
                System.out.println("3. Option 3");
                System.out.println("4. Option 4");
                System.out.println("5. Option 5");
                System.out.println("6. Option 6");
                System.out.println("7. Option 7");
                System.out.println("8. Option 8");
                System.out.println("9. Option 9");
                System.out.println("10. Option 10");

                System.out.println("Dati optiunea: ");
                choice = scanner.nextInt();

                switch (choice)
                {
                    case 0:
                        break;
                    case 1:
                        List<Angajat> angajati = citire();
                        angajati.forEach(System.out::println);//referinte la metode
                        break;
                    case 2:
                        System.out.println("Angajatii care au salariul peste 2500 RON");
                        List<Angajat> angajati1 = citire();
                       /*
                       afisare(angajati1, new Predicate<Angajat>() {
                            @Override
                            public boolean test(Angajat a)
                            {
                                return a.getSalariu() > 2500;
                            }
                        }); {
                        }
                        */
                        /*În exemplul de mai sus, am creat o listă de obiecte Angajat și am
                        folosit un stream pentru a filtra angajații cu salariul peste 2500 RON.
                         Am folosit metoda filter() a stream-ului și am dat ca argument o
                         expresie lambda care implementează interfața Predicate și verifică
                         dacă salariul angajatului este mai mare decât 2500.
                          După ce am filtrat lista, am colectat rezultatele folosind metoda
                           collect(), specificând ca tip de colecție o listă de obiecte Angajat.
                            Am afișat apoi numele angajaților din lista rezultată.*/
                        List<Angajat> salariulpeste2500 = angajati1.stream().filter(angajat -> angajat.getSalariu() > 2500)
                                .collect(Collectors.toList());
                        for(Angajat ang: salariulpeste2500)
                        {
                            System.out.println(ang.getNume() + " -> " + ang.getSalariu());
                        }
                        break;
                    case 3:
                        int anCurent = LocalDate.now().getYear();//anul curent
                        List<Angajat> angajati2 = citire();
                        List<Angajat> conducere = angajati2.stream()
                                .filter(angajat -> angajat.getPost().toLowerCase().contains("director"))
                                .filter(angajat -> angajat.getData_angajarii().getYear() == anCurent - 1
                                && angajat.getData_angajarii().getMonth() == Month.APRIL)
                                .collect(Collectors.toList());
                        System.out.println("Angajati cu functii de conducere din aprilie, anul trecut");
                        for(Angajat angajat : conducere)
                        {
                            System.out.print(angajat.getNume() + " -> " + angajat.getPost());
                        }
                        break;
                    case 4:
                        List<Angajat> angajati3 = citire();
                        List<Angajat> faraFctdeCond = angajati3.stream()
                                .filter(angajat -> !angajat.getPost().toLowerCase().contains("director"))
                                .sorted(Comparator.comparingDouble(Angajat::getSalariu).reversed())
                                .collect(Collectors.toList());
                        System.out.println("Angajati fara functie de conducere, sortati in ordine descrescatoare a salariului");
                        for(Angajat angajat: faraFctdeCond)
                        {
                            System.out.println(angajat.getNume() + " -> " + angajat.getSalariu());
                        }
                        break;
                    case 5:
                        List<Angajat> angajati4 = citire();
                        List<String> nume_maj = angajati4.stream()
                                .map(angajat -> angajat.getNume().toUpperCase())
                                .collect(Collectors.toList());
                        System.out.println("Numele angajatilor scris cu majuscule");
                        System.out.println(nume_maj);
                        break;
                    case 6:
                        List<Angajat> angajati5 = citire();
                        angajati5.stream()
                                .map(Angajat::getSalariu)
                                .filter(salariu -> salariu < 3000)
                                .forEach(System.out::println);
                        break;
                    case 7:
                        List<Angajat> angajati6 = citire();
                        Optional<Angajat> primulAngajat = angajati6.stream()
                            .sorted(Comparator.comparingInt(angajati6::indexOf))
                            .findFirst();
                        if(primulAngajat.isPresent())
                        {
                            System.out.println(primulAngajat.get());
                        }
                        else
                        {
                            System.out.println("Lista de angajati este goala");
                        }
                        break;
                    case 8:
                        List<Angajat> angajati7 = citire();
                        DoubleSummaryStatistics statisticiSalariu = angajati7.stream()
                                .mapToDouble(Angajat::getSalariu)
                                .summaryStatistics();
                        System.out.println("Salariul minim: " + statisticiSalariu.getMin());
                        System.out.println("Salariul mediu: " + statisticiSalariu.getAverage());
                        System.out.println("Salariul maxim: " + statisticiSalariu.getMax());
                        break;
                    case 9:
                        List<Angajat> angajati8 = citire();
                        Optional<Angajat> existaIon = angajati8.stream()
                                .filter(angajat -> angajat.getNume().toLowerCase().contains("ion"))
                                .findAny();
                        if(existaIon.isPresent())
                        {
                            System.out.println("Firma are cel putin un Ion angajat");
                        }
                        else
                        {
                            System.out.println("Firma nu are niciun Ion angajat");
                        }
                        break;
                    case 10:
                        List<Angajat> angajati9 = citire();
                        LocalDate dataCurenta = LocalDate.now();
                        LocalDate anulTrecut = dataCurenta.minusYears(1);
                        int nrAngajati = (int) angajati9.stream()
                                .filter(angajat -> angajat.getData_angajarii().isAfter(anulTrecut.withMonth(6))
                                        && angajat.getData_angajarii().isBefore(anulTrecut.withMonth(9)))
                                .count();
                        System.out.println("Numarul de persoane angajate in vara anului trecut: " + nrAngajati);
                        break;
                    default:
                        System.out.println("Ati introdus optiunea gresit!");
                        break;
                }
                System.out.println();
            }while(choice != 0);
            scanner.close();
        }
    }
}
