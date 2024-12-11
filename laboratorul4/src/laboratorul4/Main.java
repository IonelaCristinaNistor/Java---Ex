package laboratorul4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Echipament> echipamente = new ArrayList<>();

    public static void main(String[] args) {
        citesteEchipamente("electronice.txt");

        // Meniu
        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("========== Meniu ==========");
            System.out.println("1. Afișarea tuturor echipamentelor");
            System.out.println("2. Afișarea imprimantelor");
            System.out.println("3. Afișarea copiatoarelor");
            System.out.println("4. Afișarea sistemelor de calcul");
            System.out.println("5. Modificarea stării unui echipament");
            System.out.println("6. Setarea unui mod de scriere pentru o imprimantă");
            System.out.println("7. Setarea unui format de copiere pentru un copiator");
            System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9. Afișarea echipamentelor vândute");
            System.out.println("0. Ieșire");

            System.out.print("Selectați o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline

            switch (optiune) {
                case 1:
                    afisareEchipamente();
                    break;
                case 2:
                    afisareImprimante();
                    break;
                case 3:
                    afisareCopiatoare();
                    break;
                case 4:
                    afisareSistemeCalcul();
                    break;
                case 5:
                    modificareStareEchipament();
                    break;
                case 6:
                    setareModScriereImprimanta();
                    break;
                case 7:
                    setareFormatCopiereCopiator();
                    break;
                case 8:
                    instalareSistemOperareSistemCalcul();
                    break;
                case 9:
                    afisareEchipamenteVandute();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }

            System.out.println();
        } while (optiune != 0);

        scanner.close();
    }

    // Metoda pentru citirea echipamentelor din fișier
    private static void citesteEchipamente(String fisier) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fisier))) {
            echipamente = (List<Echipament>) input.readObject();
            System.out.println("Echipamentele au fost citite din fișier.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Eroare la citirea echipamentelor din fișier: " + e.getMessage());
        }
    }

    // Metoda pentru salvarea echipamentelor în fișier
    private static void salveazaEchipamente(String fisier) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fisier))) {
            output.writeObject(echipamente);
            System.out.println("Echipamentele au fost salvate în fișier.");
        } catch (IOException e) {
            System.out.println("Eroare la salvarea echipamentelor în fișier: " + e.getMessage());
        }
    }

    // Metoda pentru afișarea tuturor echipamentelor
    private static void afisareEchipamente() {
        for (Echipament echipament : echipamente) {
            System.out.println(echipament);
        }
    }

    // Metoda pentru afișarea imprimantelor
    private static void afisareImprimante() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Imprimanta) {
                System.out.println(echipament);
            }
        }
    }

    // Metoda pentru afișarea copiatoarelor
    private static void afisareCopiatoare() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Copiator) {
                System.out.println(echipament);
            }
        }
    }

    // Metoda pentru afișarea sistemelor de calcul
    private static void afisareSistemeCalcul() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof SistemCalcul) {
                System.out.println(echipament);
            }
        }
    }

    // Metoda pentru modificarea stării unui echipament
    private static void modificareStareEchipament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numărul de inventar al echipamentului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

        Echipament echipament = gasesteEchipament(nrInv);
        if (echipament != null) {
            System.out.print("Introduceți noua stare a echipamentului (ACHIZITIONAT, EXPUS, VANDUT): ");
            String stare = scanner.nextLine().toUpperCase();

            try {
                echipament.setStare(StareEchipament.valueOf(stare));
                System.out.println("Starea echipamentului a fost modificată.");
            } catch (IllegalArgumentException e) {
                System.out.println("Starea introdusă este invalidă!");
            }
        } else {
            System.out.println("Nu s-a găsit niciun echipament cu numărul de inventar specificat.");
        }
    }

    // Metoda pentru setarea modului de scriere al unei imprimante
    private static void setareModScriereImprimanta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numărul de inventar al imprimantei: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

        Echipament echipament = gasesteEchipament(nrInv);
        if (echipament instanceof Imprimanta) {
            Imprimanta imprimanta = (Imprimanta) echipament;

            System.out.print("Introduceți noul mod de scriere (COLOR, ALB_NEGRU): ");
            String modScriere = scanner.nextLine().toUpperCase();

            try {
                imprimanta.setModTiparire(ModTiparire.valueOf(modScriere));
                System.out.println("Modul de scriere al imprimantei a fost modificat.");
            } catch (IllegalArgumentException e) {
                System.out.println("Modul de scriere introdus este invalid!");
            }
        } else {
            System.out.println("Nu s-a găsit nicio imprimantă cu numărul de inventar specificat.");
        }
    }

    // Metoda pentru setarea formatului de copiere al unui copiator
    private static void setareFormatCopiereCopiator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numărul de inventar al copiatorului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

       /* Echipament echipament = gasesteEchipament(nrInv);
        if (echipament instanceof Copiator) {
            Copiator copiator = (Copiator) echipament;

            System.out.print("Introduceți noul format de copiere (A3, A4): ");
            String formatCopiere = scanner.nextLine().toUpperCase();

            try {
                Copiator.setFormat(Format.valueOf(formatCopiere));
                System.out.println("Formatul de copiere al copiatorului a fost modificat.");
            } catch (IllegalArgumentException e) {
                System.out.println("Formatul de copiere introdus este invalid!");
            }
        } else {
            System.out.println("Nu s-a găsit niciun copiator cu numărul de inventar specificat.");
        }
    }

        */

    // Metoda pentru instalarea unui sistem de operare pe un sistem de calcul
    private static void instalareSistemOperareSistemCalcul() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numărul de inventar al sistemului de calcul: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

        Echipament echipament = gasesteEchipament(nrInv);
        if (echipament instanceof Sisteme_de_calcul) {
            Sisteme_de_calcul sistemeDeCalcul = (Sisteme_de_calcul) echipament;

            System.out.print("Introduceți noul sistem de operare (WINDOWS, LINUX): ");
            String sistemOperare = scanner.nextLine().toUpperCase();

            try {
                Sisteme_de_calcul.setSist(Sistem_operare.valueOf(sistemOperare));
                System.out.println("Sistemul de operare al sistemului de calcul a fost instalat.");
            } catch (IllegalArgumentException e) {
                System.out.println("Sistemul de operare introdus este invalid!");
            }
        } else {
            System.out.println("Nu s-a găsit niciun sistem de calcul cu numărul de inventar specificat.");
        }
    }

    // Metoda pentru afișarea echipamentelor vândute
    private static void afisareEchipamenteVandute() {
        for (Echipament echipament : echipamente) {
            if (echipament.getSituatie() == Situatie.VANDUT) {
                System.out.println(echipament);
            }
        }
    }

    // Metoda pentru găsirea unui echipament după numărul de inventar
    private static Echipament gasesteEchipament(int nrInv) {
        for (Echipament echipament : echipamente) {
            if (echipament.getNr_inv() == nrInv) {
                return echipament;
            }
        }
        return null;
    }
}