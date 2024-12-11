package lab8;

public class Persoane {
    private int id;
    private String nume;
    private int varsta;

    public Persoane(int id, String nume, int varsta) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_persoana) {
        this.id = id_persoana;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}