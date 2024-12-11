package lab6;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.deser.ZonedDateTimeDeserializer;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
public class MainApp {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<Angajat> angajati = mapper.readValue(new File("src/main/resources/angajati.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Angajat.class));

            // Test afișare listă de angajați
            afisareAngajati(angajati);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void afisareAngajati(List<Angajat> angajati) {
        angajati.forEach(System.out::println);
    }

    afisareAngajati(angajati);
    afisareAngajatiSalariuPeste(angajati, 2500);
    afisareAngajatiConducereLuna(angajati, "aprilie");
    afisareAngajatiFaraConducere(angajati);
    afisareNumeAngajatiMajuscule(angajati);
    afisareSalariiMici(angajati, 3000);
    afisarePrimulAngajat(angajati);
    afisareStatisticiSalarii(angajati);
    afisareMesajAngajatIon(angajati);
    afisareNumarAngajatiVara(angajati, LocalDate.now().getYear());
}

    private static void afisareAngajati(List<Angajat> angajati) {
        System.out.println("Lista de angajati:");
        angajati.forEach(System.out::println);
        System.out.println();
    }

    private static void afisareAngajatiSalariuPeste(List<Angajat> angajati, float salariu) {
        System.out.println("Angajatii cu salariul peste " + salariu + " RON:");
        angajati.stream()
                .filter(a -> a.getSalariu() > salariu)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void afisareAngajatiConducereLuna(List<Angajat> angajati, String luna) {
        System.out.println("Angajatii cu functie de conducere din luna " + luna + ":");
        int anTrecut = LocalDate.now().minusYears(1).getYear();
        angajati.stream()
                .filter(a -> a.getDataAngajarii().getYear() == anTrecut && a.getDataAngajarii().getMonth().name().equalsIgnoreCase(luna))
                .filter(a -> a.getPost().toLowerCase().contains("sef") || a.getPost().toLowerCase().contains("director"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void afisareAngajatiFaraConducere(List<Angajat> angajati) {
        System.out.println("Angajatii fara functie de conducere (in ordine descrescatoare a salariilor):");
        angajati.stream()
                .filter(a -> !a.getPost().toLowerCase().contains("sef") && !a.getPost().toLowerCase().contains("director"))
                .sorted((a1, a2) -> Float.compare(a2.getSalariu(), a1.getSalariu()))
                .forEach(System.out::println);
        System.out.println();
    }

    private static void afisareNumeAngajatiMajuscule(List<Angajat> angajati) {
        System.out.println("Numele angajatilor scris cu majuscule:");
        List<String> numeMajuscule = angajati.stream()
                .map(Angajat::getNume)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(numeMajuscule);
        System.out.println();
    }

    private static void afisareSalariiMici(List<Angajat> angajati, float limitaSalariu) {
        System.out.println("Salariile mai mici de " + limitaSalariu + " RON:");
        angajati.stream()
                .map(Angajat::getSalariu)
                .filter(salariu -> salariu < limitaSalariu)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void afisarePrimulAngajat(List<Angajat> angajati) {
        System.out.println("Primul angajat al firmei:");
        angajati.stream()
                .min((a1, a2) -> a1.getDataAngajarii().compareTo(a2.getDataAngajarii()))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nu exista angajati."));
        System.out.println();
    }

    private static void afisareStatisticiSalarii(List<Angajat> angajati) {
        System.out.println("Statistici salarii:");
        double salariuMediu = angajati.stream()
                .mapToDouble(Angajat::getSalariu)
                .average()
                .orElse(0.0);
        double salariuMinim = angajati.stream()
                .mapToDouble(Angajat::getSalariu)
                .min()
                .orElse(0.0);
        double salariuMaxim = angajati.stream()
                .mapToDouble(Angajat::getSalariu)
                .max()
                .orElse(0.0);

        System.out.println("Salariu mediu: " + salariuMediu);
        System.out.println("Salariu minim: " + salariuMinim);
        System.out.println("Salariu maxim: " + salariuMaxim);
        System.out.println();
    }

    private static void afisareMesajAngajatIon(List<Angajat> angajati) {
        boolean existaIon = angajati.stream()
                .map(Angajat::getNume)
                .anyMatch(nume -> nume.toLowerCase().contains("ion"));

        if (existaIon) {
            System.out.println("Firma are cel putin un Ion angajat.");
        } else {
            System.out.println("Firma nu are niciun Ion angajat.");
        }
        System.out.println();
    }

    private static void afisareNumarAngajatiVara(List<Angajat> angajati, int an) {
        System.out.println("Numarul de persoane care s-au angajat in vara anului " + an + ":");
        long numarAngajatiVara = angajati.stream()
                .filter(a -> a.getDataAngajarii().getYear() == an && a.getDataAngajarii().getMonth().getValue() >= 6 && a.getDataAngajarii().getMonth().getValue() <= 8)
                .count();
        System.out.println(numarAngajatiVara);
    }
}
}
