package laboratorul10;

public class Autoturism extends Vehicul{
    private int volum_portb;
    private int kg;

    public Autoturism(String marca, int pret, int volum_portb, int kg) {
        super(marca, pret);
        this.volum_portb = volum_portb;
        this.kg = kg;
    }

    public Autoturism() {}

    public int getVolum_portb() {
        return volum_portb;
    }

    public void setVolum_portb(int volum_portb) {
        this.volum_portb = volum_portb;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return super.toString() + " Autoturism{" +
                "volum_portb=" + volum_portb +
                ", kg=" + kg +
                '}';
    }
}
