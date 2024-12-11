package laboratorul10;

public class Vehicul {
    private String marca;
    private int pret;

    public Vehicul(String marca, int pret) {
        this.marca = marca;
        this.pret = pret;
    }

    public Vehicul() {}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Vehicul{" +
                "marca='" + marca + '\'' +
                ", pret=" + pret +
                '}';
    }
}
