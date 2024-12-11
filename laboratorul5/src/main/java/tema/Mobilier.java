package tema;
import java.util.List;
public class Mobilier {
    private String nume;
    private List<placa> placi;

    public Mobilier(String nume,List<placa>placi){
        this.nume=nume;
        this.placi=placi;
    }
    public String getNume(){
        return nume;
    }

    public List<placa> getPlaci() {
        return placi;
}

    @Override
    public String toString() {
        return super.toString() + " Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
