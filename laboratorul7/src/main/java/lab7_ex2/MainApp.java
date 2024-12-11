package lab7_ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MainApp {

    public static void scriere(Set<InstrumentMuzical> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/instrumente.json");
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire() {
        try {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzical> instrument = mapper.readValue(file, new TypeReference<Set<InstrumentMuzical>>(){});
            return instrument;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Set<InstrumentMuzical> instrumente = new HashSet<InstrumentMuzical>();
        InstrumentMuzical chitara1 = new Chitara("Samsung", 4500, TipChitara.ELECTRICA, 6);
        instrumente.add(new Chitara("Alcatel", 2456, TipChitara.ACUSTICA, 5));
        instrumente.add(new Chitara("Johnson", 5688, TipChitara.CLASICA, 7));
        instrumente.add(new SetTobe("Head&Shoulders", 9000, TipTobe.ELECTRONICE, 2, 3));
        instrumente.add(new SetTobe("Continental", 2000, TipTobe.ACUSTICE, 6, 5));
        instrumente.add(new SetTobe("Catrice", 1234, TipTobe.ELECTRONICE, 2, 4));

        //scriere(instrumente);

        Set<InstrumentMuzical> instrumentMuzicalSet = citire();
        instrumentMuzicalSet.stream().forEach(System.out::println);

        //5
        System.out.println();
        InstrumentMuzical chitara2 = new Chitara("Samsung", 4500, TipChitara.ELECTRICA, 6);
        if(chitara2.equals(chitara1))
        System.out.println("Elementul exista deja in colectia Set");
        else
        System.out.println("Elementul nu exista in colectia Set");

        //6
        System.out.println();
        instrumentMuzicalSet.removeIf(instrumentMuzical -> instrumentMuzical.getPret()>3000);
        System.out.println("Elementele dupa stergere: ");
        instrumentMuzicalSet.stream().forEach(System.out::println);

        //7
        System.out.println();
        instrumentMuzicalSet.stream().filter(instrumentMuzical -> instrumentMuzical instanceof Chitara)
                .forEach(System.out::println);

        //8
        System.out.println();
        instrumentMuzicalSet.stream().filter(instrumentMuzical -> instrumentMuzical.getClass()== SetTobe.class)
                .forEach(System.out::println);

        //9
        System.out.println();
        Optional<InstrumentMuzical> opt = instrumentMuzicalSet.stream().filter(instrumentMuzical ->
                        instrumentMuzical instanceof Chitara)
                .sorted((a,b)->((Chitara)b).getNr_corzi()-((Chitara)a).getNr_corzi()).findFirst();
        if(opt.isPresent())
            System.out.println(opt);
        else
            System.out.println("Nu avem elemente in chitara");

        //10
        System.out.println();
        instrumentMuzicalSet.stream().filter(instrumentMuzical -> instrumentMuzical instanceof SetTobe)
                .filter(instrumentMuzical -> ((SetTobe)instrumentMuzical).getTipTobe()==TipTobe.ACUSTICE)
                .sorted(Comparator.comparingInt(a->((SetTobe) a).getNr_tobe()))
                .forEach(System.out::println);
    }
}
