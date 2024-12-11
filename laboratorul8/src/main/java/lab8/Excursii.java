package lab8;

public class Excursii {
    private int id;
    private int id_excursie;
    private String destinatie;
    private int anul;

    public Excursii(int id, int id_excursie, String destinatie, int anul) {
        this.id = id;
        this.id_excursie = id_excursie;
        this.destinatie = destinatie;
        this.anul = anul;
    }

    public Excursii() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_excursie() {
        return id_excursie;
    }

    public void setId_excursie(int id_excursie) {
        this.id_excursie = id_excursie;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }
}
