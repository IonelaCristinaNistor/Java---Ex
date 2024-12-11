package laboratorul10;

import org.springframework.stereotype.Component;

@Component
public class Tir extends Vehicul{
    private int incarcatura_max;
    public Tir(String marca, int pret, int incarcatura_max) {
        super(marca, pret);
        this.incarcatura_max = incarcatura_max;
    }
    public Tir() {}

    public int getIncarcatura_max() {
        return incarcatura_max;
    }

    public void setIncarcatura_max(int incarcatura_max) {
        this.incarcatura_max = incarcatura_max;
    }

    @Override
    public String toString() {
        return super.toString() + " Tir{" +
                "incarcatura_max=" + incarcatura_max +
                '}';
    }
}
