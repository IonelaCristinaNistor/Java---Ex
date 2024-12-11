package laboratorul4;

public class Echipament {
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private Situatie situatie;

    public Echipament(String denumire, int nr_inv, float pret, String zona_mag, Situatie situatie)
    {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = situatie;
    }

    public String getDenumire()
    {
        return denumire;
    }
    public int getNr_inv()
    {
        return nr_inv;
    }
    public float getPret()
    {
        return pret;
    }
    public void setPret(float pret)
    {
        this.pret = pret;
    }
    public String getZona_mag()
    {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag)
    {
        this.zona_mag = zona_mag;
    }

    public Situatie getSituatie()
    {
        return situatie;
    }
    public void setSituatie(Situatie situatie)
    {
        this.situatie = situatie;
    }
    public String toString()
    {
        return "Denumire: " + denumire + "Numar inventar: "
                + nr_inv + "Pret: " + pret + "Zona magazin: "
                + zona_mag + "Situatie echipament: " + situatie;
    }
}
