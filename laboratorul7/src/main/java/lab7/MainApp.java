package lab7;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<Integer, Carte>> typeReference = new TypeReference<>() {
        };
        Map<Integer, Carte> colectie = objectMapper.readValue(new File("src/main/resources/carti.json"), typeReference);
        colectie.forEach((key, val) -> System.out.println(key + "  " + val.toString()));

        System.out.println(" \n ");

        //2) Sa se stearga o carte din coletia MAP
        colectie.remove(3);
        System.out.println("Lista dupa stergerea cartii cu id 3: ");
        colectie.forEach((key, val)-> System.out.println(key + " " + val.toString()));

        //3) Sa se adauge o carte la colectia MAP(se va utiliza metoda putIfAbsent)
        System.out.println(" \n ");
        colectie.putIfAbsent(3,new Carte("Hotul de carti","Markus Zusak",2014));
        System.out.println("Lista dupa adaugare cheie noua: ");
        colectie.forEach((key, val)-> System.out.println(key + " " + val.toString()));

        //4) Sa se salveze in fisierul JSON modificarile facute asupra colectiei

        try {
            objectMapper.writeValue(new File("src/main/resources/carti.json"), colectie);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //5) Sa se creeze o colectie Set<Carte> care extrage din colectia Map cartile autorului
        //Yuval Noah Harari. Se va utiliza Stream API si colectori. Se va afisa colectia creata
        //cu ajutorul metodei forEach

        Set<Carte> cartiYuval = colectie.values().stream()
                .filter(carte -> carte.autorul().equals("Yuval Noah Harari"))
                .collect(Collectors.toSet());
        System.out.println();
        System.out.println("Cartile autorului Yuval Noah Harari: ");
        cartiYuval.forEach(System.out::println);

        //6) Sa se afiseze ordonat dupa titlu carti elementele din colectia set folosind
        //Stream API, expresii Lambda si referinte de metode
        System.out.println();
        System.out.println("Colectia de carti ordonata dupa titlu: ");
        cartiYuval.stream()
                .sorted(Comparator.comparing(Carte::titlul))
                .forEach(System.out::println);

        //7) Sa se afiseze datele celei mai vechi carti din colectia set folosind API si clasa Optional

        System.out.println();
        System.out.println("Cea mai veche carte: ");
        Optional<Carte> ceaMaiVeche = cartiYuval.stream()
                .min(Comparator.comparingInt(Carte::anul));
        if(ceaMaiVeche.isPresent())
        {
            System.out.println("Cea mai veche carte: " + ceaMaiVeche.get());
        }
        else
        {
            System.out.println("Nu exista carti in colectie!");
        }
    }
}